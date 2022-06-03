import java.lang.reflect.Array;
import java.util.Arrays;

public class test2 {
    public static void main(String[] args) {
         int[] a={5,3,1,2,4};
//         selectSort(a);
        bubleSort(a);
         System.out.println(Arrays.toString(a));
    }

    public static void selectSort(int[] a){
        //顺序排序
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i]>a[j]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
    }

    public static void bubleSort(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-1-i; j++) {
                if(a[j]>a[j+1]){
                    int temp=a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                }
            }
            
        }
    }

    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int num=0;



        }
        
    }
}
