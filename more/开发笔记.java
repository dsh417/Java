选题
设计思想
题目要求

开发流程

架构
	实体层：
		Flight对象，储存前端传递的数据，继承 Serializable 接口（可序列化，所有储存数据的对象必须实现的接口）

	业务层：
		FlightService接口，要求有 查询方法
			新增异常SelectException，继承Exception，共2个异常（     * 1,查询对象的创建异常、* 2,服务器失败异常）

	持久层：
		selectByFlightDao接口，要求有访问数据库的方法（返回一个集合）
			新增异常DataException 继承RuntimeException，共两个异常（    * 1，封装用户信息异常 * 2，访问数据库异常）



	开始做实现，业务层开始：
		业务层加Impl包，创建FlightServiceImpl实现对象
		、需要用到Dao，但是这里不能因为没写就不能写下去了！
		需要工厂，并且不应该关心实现类是谁，不应该持久层做耦合，我只关心持久层给我提供了什么功能！

		写工厂
		Factory工厂包，创建一个类ObjectFacotry，用来读配置文件缓存下来，因为只读一次（单例模式）
		读的流选择，由于配置文件是key=value，
			我们用Buffreader（带缓冲）读，由于需要的是StreamReader，外面套一层InputStreamReader
			while读数据，每行是key，vlaue，静态的东西，所以写static map<,>访问
			我要读的value不是字符串，是一个对象，所以应该是object
			用split分割key和value（* value反射一个对象）
			并且读出错就抛出一错误（不是异常，初始化都错误怎么运行），关流

			核心的是传key，获得对象，对象是我们根据字符串里创建出来的对象
	
	核心的是三层架构：
		在业务层实现类FlightServiceImpl，我们没有对象，也可以用工厂获得（用接口调用实现类也是多态的一个表现）
			接口已经给我提供实现的功能了，比如说我要在数据库查的功能
		
		这里我们已经查到数据了，但是还没有真的实现，来到Dao，创建实现类
		这里我们要实现查询方法，因为写jdbc代码很麻烦
			我们封装了jdbc代码

	JDBC的封装
		Util包
			JDBCUtil：
			我们把数据库的链接信息写在properties文件里，因为只读一次，静态代码块（用Preperties读）
				我们写了Connection方法，返回链接信息

			JDBCTemplate：
			因为JDBC中间的处理重复，无非是给个sql语句查询，要一个结果集，或者更新数据库操作，所以进行封装
				
				来到提交数据库预处理这部分，ps=prepareStatement
				涉及到开不开事务问题，应该在业务开始时候开，不应该在模板链里面开

				然后给sql里的value写值，params这里不用可变长参数，用的是数组，虽然可变长参数就是数组。
				通过setParams也就是setObject方法给数据库传值

				链接关闭问题，事务在外部，所以链接不能关

				关于结果集处理，我用的是模板回调接口的设计模式
				调用者需要，需要外部传对象过来，但是这个对象是会变的，所以我创建了一个接口RowMapper，通过
					调用RowMapper来调用外部的对象，这个RowMapper我通过参数获得

				真正要传的传是接口的实现类，



	回到SelectDaoImpl，Search是队友实现的select，返回结果集。
	这里持久层就写完了。

	现在是事务和关闭连接
	
	来到业务层实现类FlightServiceImpl，整个查询是一个逻辑，需要加事务
	我不能直接使用JDBCUtil.getConnection()获得链接，因为不是同一个链接,相当于又开了一个链接
	来到JDBCUtil.getConnection
	所以我要求getConnection()给我同一个链接
	所以    
	//要做： 保证一个事务一个连接 or 保证一个业务是一个连接
    //      如果在web上，每个人都来请求查询或者注册功能，那么要的其实是
    //      一个线程是一个连接（每个人都是一个线程）
    //      一个事务是一个线程
    //我可以说连接需要对线程单例

	单例模式需要有地方保存，没有就创建并保存下来，有就获取，这就是单例
	线程可以用GetId来获取唯一表示
	那么 我用Map来保存，
		比如：这个connection保存在1号线程
	这里我用threadLocal来做，放和取都是对当前线程来使用的
	我将threadLocal放到属性，在静态代码创建
	之后，如果有程序调用get没有获取到con，就是没有线程，这时候就创建一个con和线程就可以
		这样就做到了 一个线程是一个连接
	
	之前在持久层里，模板是没有关连接的，我现在需要关连接，
		关应该关本线程相关的连接

	现在只要是一个线程，在如何地方getConnection获得链接，都是同一个链接
	现在可以回到业务层实现类FlightServiceImpl里加事务

	但是这里有问题，不能直接写在这里，
		1，写业务逻辑 不应该去写事务（因为事务问题还有异常处理要考虑）
		2，这个方法里有事务代码耦合的话，不能复用
		3，如果事务改变了，这行代码改到了，有很多代码需要改

	这里我用代理模式来做
		业务层加代理，新建一个proxy包，新建一个FlightServiceProxy类实现同样的接口，知道实现什么方法。
		查询方法，查询方法刚刚写过，现在拿过来用，
		在构造方法里这样写，
			用个工厂ObjectFactory

		配置写在了object.txt

		在regist里面，代理类的方法调用他的查询方法，只不过在它的外面加一个事务

		准备提交事务，但是事务代码是会变的，应该给事务加个接口
		创建transaction，及其接口
		事务有那么几部分
			开始事务
			提交事务
			回滚事务
		在FlightServiceProxy代理里，用接口实现类
		通过工厂，getObjcet获得

		在异常里，我们方法里异常是调用数据库产生的异常
		应该是用DataException

		然后就是实现transaction，通过getConnection获得链接，然后开始事务
		链接现在可以关闭了，因为事务结束就可以关闭连接了
		在提交和回滚里关闭连接。



MVC
开发模式

model		数据模型
view		显示逻辑
controller	控制器

是一种软件架构的开发模式
将一个操作分成三种不同的部分
model：封装了业务逻辑，对于业务数据按一定的规则进行加工
view：封装了显示逻辑（如jsp是view）
controller：协调视图模型
			请求不再直接访问数据模型和视图
			而是统一交给控制器
			由控制器来分发给合适的模型来处理
			模型处理后，也不再返回给视图
			而是交给控制器
			由控制器选择合适的视图，将结果展示给客户

优点：
		1，多个视图可以共享同一个模型
		2，不同的模块方便维护
		3，使用者关心的只有url
		4，方便工作的分配

缺点：
		1，mvc只是一个设计思想，对于实际的系统，需要做详细设计
		2，增加代码量









XML
EXtensible Markub Language

作用
		保存和传输数据


xml文件
		文本文件
		扩展名.xml
		











ssh2

表示层
		struts2 JSF springmvc

业务层
		spring EJB

持久层
		hibernate JPA mybatis

struts2
		实现了mvc

		struts2与struts1
		封装了WebWork


		struts2优点
			提高了Action组件灵活性（摆脱了框架api，Servlet容器的api的依赖性）
			提供了对多种视图技术的整合
			提供了拦截器和拦截器栈（允许对struts2二次开发）

		struts2框架的主要结构，重要组件
			核心控制器
					使用过滤器实现
							实现组件为
									org.apache.struts2.dispatcher.FileterDispatcher 2.1.8版本以前

									org.apache.struts2.dispatcher.ng.filter.StrutsPrePareAndExecuterFilter 2.1.8版本开始

			Action组件
					普通的JavaBean，可以选择 继承/实现 一些框架的api
				
			Result组件
					用于衔接视图响应技术，如jsp，freemarker，stream，json，excel，pdf，图表等

			Interceptor组件
					用于封装通用的功能，可以在Action业务方法执行前后处理

			
		核心jar包
				struts2-core.jar

		struts2框架配置
				struts-default.xml （内置）
				作用：预定义了一些Result组件，Interceptor组件，拦截器栈组件

				xml定义结构
					定义了一系列<bean>元素，用于底层创建JavaBean对象使用
				
				<package>元素，用于存放Result，Interceptor，Action组件的定义
				<result-types>元素，用于定义Result组件
				<interceptors>元素，用于定义Interceptor和InterceptorStack组件
				<action>元素，用于定义Action组件

		struts.xml（自定义）
				定义在类加载路径下
				配置结构跟struts-defalut.xml相同
				作用 自定义Result组件，Interceptor组件，拦截器栈组件

		defalut.properties(内置)



Spring:
		业务逻辑组件框架
		
		程序结构良好
		简化开发

		高低原则
				高内聚，低耦合
		
		开闭原则
				对扩展开，对修改闭（加功能不要修改原来的代码）

Spring开发包
		dist/
				spring.jar
				spring-sec.jar
				modules/spring-*.jar
				resources/约束文件		(建议使用.xsd)

		docs/
				api/
				reference/
		
		lib/
				第三方jar包

主要内容:
		IOC容器		使组件关系松散
		AOP容器		使应用易于扩展
		通用支持	简化开发

IOC容器:
		概念
				IOC Inversion Of Control
					反转控制(控制权交给spring，如serviceimpl只需要知道dao里有某个方法可以使用，而不用new或者工厂)

				DI Dependency Injection
					依赖注入

		IOC容器类型
				BeanFactory bf;

				BeanFactory userService=

				ApplacationContext