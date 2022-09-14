package disign.Template.simple;
/*
* 模版类有一个或多个实现方法，而这几个实现方法有固定的执行顺序
* */
public abstract class NetworkcCourse {
    protected final void createCourse(){
        //发布预习资料
        this.postPreResource();
        //制作课件ppt
        this.createPPT();
        //在线直播
        this.liveVideo();
        //提交课堂日记
        this.postNote();
        //提交源码
        this.postSource();

        //如果有作业，检查作业，如果没有，流程结束
        if(needHomework()) {
            checkHomework();
        }
    }


    //    钩子方法
    protected boolean needHomework() {
        return false;
    }

    abstract void checkHomework();



    final void postSource(){
        System.out.println("提交源代码");
    }
    final void postNote(){
        System.out.println("提交课程笔记");
    }
    final void liveVideo(){
        System.out.println("直播授课");
    }
    final void createPPT(){
        System.out.println("创建备课ppt");
    }
    final void postPreResource(){
        System.out.println("分发预习资料");
    }
}
