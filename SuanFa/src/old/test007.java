package old;

public class test007{

    public static int count=0;

    public static void dfs(int min,int max,int num){

        if(num<0){
            return ;
        }

        if(num==0){

            count++;

            return ;
        }

        for(int i=min;i<max;i++){

            dfs(i+1,max,num-i*i);
        }

    }


    public static void main(String[] args){


        dfs(0,45,2019);

        System.out.println("count:"+count);


    }



}