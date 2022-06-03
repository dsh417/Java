public class test009 {
    public static void main(String[] args) {
        int kapian[]=new int[10];
        for(int i=1;i<99999;i++){
            int j=i;
            while(j!=0){
                int temp=j%10;
                kapian[temp]++;
                if(kapian[temp]>2021){
                    System.out.println(i-1);
                    return;
                }
                j/=10;
            }
        }
        ;
    }
}
