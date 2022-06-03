public class test003 {

    public static void main(String args[]){
        int n=10000;
        int num=0;
        int num1=0;
        for(int i=1;i<=n;i++){
            int j=i;
            while(j!=0){
            int a=j%10;
            if(a==2||a==1||a==0||a==9){
                num+=i;
                num1++;
                break;
            }
           j/=10;
            }
        }
        System.out.println(num1);
        System.out.println(num);
    }
}
