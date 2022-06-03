public class test005 {

    public static void main(String args[]){
        int Num=0;
        int Max=2019;
        for(int i=0;i<Max;i++){
            int i_Temp=i;
            while(i_Temp!=0){
                if(i_Temp%10==2 || i_Temp%10==4){
                    continue;
                }
                i_Temp/=10;
            }
            for(int j=i+1;j<Max;j++){
                int j_Temp=i;
                while(j_Temp!=0){
                    if(j_Temp%10==2 || j_Temp%10==4){
                        continue;
                    }
                    j_Temp/=10;
                }
                for(int k=j+1;k<Max;k++){
                    int k_Temp=i;
                    while(k_Temp!=0){
                        if(k_Temp%10==2 || k_Temp%10==4){
                            continue;
                        }
                        k_Temp/=10;
                    }
                    if(i+k+j==Max){
                        Num++;
                    }
                }
            }
        }
        System.out.println(Num);
    }
}
