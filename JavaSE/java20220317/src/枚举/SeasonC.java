package 枚举;

public enum SeasonC {
    SPR,
    SUM,
    AUT,
    WIN;

    private SeasonC(){

    }

    @Override
    public String toString() {
        switch (this){
            case SPR : return "春天";
            case SUM : return "夏天";
            case AUT : return "秋天";
            case WIN : return "冬天";

        }

        return null;
    }

    //      允许的语法
//    SPR(1),
//    SUM(2),
//    AUT(3),
//    WIN(4);
//
//    private SeasonC(int i){
//
//    }
}
