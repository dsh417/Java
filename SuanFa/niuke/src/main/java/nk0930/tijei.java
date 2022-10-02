package nk0930;


import java.util.List;

/*
* 题目：
* 小红小紫，谁先使得x>y就赢，可知两人都很聪明
* x操作二选一：
*   x翻倍
*   x自加1
* 求：
*   小红是否有必胜的把握
* 如：
*   x=2，y=9
*   小红：x翻倍=4
*   无论小紫如何操作都是小红赢
*
* どぞ!
*
* */
public class tijei {
    static int x=4;
    static int y=9;
    public static void main(String[] args) {

        System.out.println(pd());
    }
//    动态规划
    public static boolean pd(){
//        选取 y/2 +1 到 y的值，不包括y
//        这一串数字表示小红的解集,必胜的解集
        int tempX=(y/2)+1;
        if(tempX<x)tempX=x;
//        如果小红能轮到这个数字可知有必胜把握
        boolean t=false;
        for (int i = tempX; i < y; i++) {
            if(dfs(i)){
                t=true;
                break;
            }
        }
        return t;
    }

    private static boolean dfs(int tempX) {
        if(tempX<x)return false;
        if(tempX==x)return true;
        if(
                dfs(tempX-1)
                &&
                dfs(tempX/2)
        ){
            return true;
        }else {
            return false;
        }
    }


}
