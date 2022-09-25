package old;

import java.util.Scanner;

public class test003Answer {

    public static Boolean check(int i) {
        if((i + "").indexOf("2") != -1 || (i + "").indexOf("0") != -1 || (i + "").indexOf("1") != -1 || (i + "").indexOf("9") != -1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            if(check(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

}
