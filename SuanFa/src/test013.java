import javax.swing.*;


//杨辉三角

public class test013 {
    public static void main(String []args){

        int [][] num=new int[9999][9999];
        //横
        int n=6;
        int num2=3;
        num [1][1]=1;
        num [2][1]=1;
        num [2][2]=1;
        for(int i=3;i<=n;i++){
            //纵
            int temp1=0;
            int temp2=0;
            for(int j=1;j<=i;j++){
                if(num[i-1][j]!=0) {
                    temp1=num[i-1][j];
                }else {
                    temp1=0;
                };
                if(num[i-1][j-1]!=0){
                    temp2=num[i-1][j-1];
                }else{
                    temp2=0;
                }

                num[i][j]=temp1+temp2;
                num2++;
                //System.out.print(i+" ");
                //System.out.print(j+"\n");
                if(n==num[i][j]){
                    System.out.println(i+" "+j+"是答案:"+num2);
                    return;
                }
            }
       }





    }
}
