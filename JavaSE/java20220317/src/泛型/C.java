package 泛型;
//E是C类的参数

/*
* E是C类的参数
* 表示任意类型
* 当调用传什么类型就是什么类型
* 如果没传，当O使用
* 泛型只在编译期间有效
* 运行当做Object
*
* 一般用于
*   设计（架构）
*   安全
*   方便
*
* extends不是继承，是限制只能传某个类型及其子类型
* */
public class C <E,T extends Number>{
    private E e;

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public T f(E e){
        return null;
    }

}
