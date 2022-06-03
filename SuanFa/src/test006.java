//把2019分解成3个各不相同的正整数之和，并且要求每个正整数都不包含数字2和4，一共有多少种不同的分解方法?
//注意交换3个整数的顺序被视为同一种方法，例如1001+1000+18被视为同一种。

public class test006 {
    public static void main(String []args){
        int n=2019;
        int m=0;
        for(int i=0;i<n;i++){
            if((i+"").indexOf('2')!=-1||(i+"").indexOf('4')!=-1){
                continue;
            }
            int j_max=n-i;
            if(i+1>=j_max)continue;
            for(int j=i+1;j<j_max;j++){
                if((j+"").indexOf('2')!=-1||(j+"").indexOf('4')!=-1){
                    continue;
                }
                int k_max=n-i;
                if(j+1>=k_max)continue;
                for(int k=j+1;k<k_max;k++){
                    if((k+"").indexOf('2')!=-1||(k+"").indexOf('4')!=-1){
                        continue;
                    }
                    if(i+j+k==n){
                        m++;
                    }
                }
            }
        }
        System.out.println(m);
    }
}
