package 枚举;

public class test {
    public static void main(String[] args) {
//        int seasonA=SeasonA.SPRING;
//
//        System.out.println(f(SeasonA.SUM));
//
//        SeasonB seasonB=SeasonB.SUM;

        SeasonB seasonB=SeasonB.SUM;
        f(seasonB.SUM);
//        f(new SeasonB())
        System.out.println();

    }
    public static String f(SeasonB seasonB){


        return null;
    }

//    有问题
//    public static String f(int season){
//
//        switch(season){
//            case SeasonA.SPRING:return "春天";
//            case SeasonA.SUM:return "夏天";
//            case SeasonA.AUT:return "秋天";
//            case SeasonA.WIN:return "冬天";
//        }
//        return null;
//    }
}
