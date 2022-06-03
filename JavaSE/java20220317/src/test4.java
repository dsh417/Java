public class test4 {
    public static String[][] chess=new String[16][16];

    static{
        //运行前自动执行
        System.out.print("  ");
        for (int i = 0; i < chess.length; i++) {
            System.out.print(Integer.toHexString(i)+" ");
        }
        System.out.println();

        for (int i = 0; i < chess.length; i++) {
            System.out.print(Integer.toHexString(i)+" ");

            for (int j = 0; j < chess[i].length; j++) {
                chess[i][j]="*";
                System.out.print(chess[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

    }
}
