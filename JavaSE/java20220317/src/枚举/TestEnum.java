package 枚举;

public class TestEnum {
    public static void main(String[] args) {

        System.out.println(SeasonC.class);

        SeasonC seasonC=SeasonC.WIN;
        System.out.println(seasonC.SPR);

    }

//    public String f(SeasonC c){
//        switch (c){
//            case SPR:return"春天";
//            case SUM:return"夏天";
//            case AUT:return"秋天";
//            case WIN:return"冬天";
//
//        }
//
//        return null;
//
//    }
}
