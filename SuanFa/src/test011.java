
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class Line implements Comparable<Line>{
    double k, b;
    public Line(double kk, double bb){
        this.k = kk;
        this.b = bb;
    }
    @Override
    public int compareTo(Line o) {
        if( Double.compare(this.k, o.k) == 0 ) return Double.compare(this.b, o.b);
        return Double.compare(this.k, o.k);
    }

}
public class test011 {
    static int N = 20, M = 21;
    //	static int N = 2, M = 3;
    static Line[] q = new Line[1000000];
    static double esp = 10E-8;
    //计算斜率
    public static double getK(int x1, int y1, int x2, int y2) {
        return (double) (y1 - y2) /(x1 - x2) ;
    }
    public static void main(String[] args) {
        int t = 0;
        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < M; j ++) {
                //(i, j) --> (x, y)
                for(int x = 0; x < N; x ++) {

                    if( i == x) continue;
                    for(int y = 0; y < M; y ++) {
                        if( y == j) continue;
                        double k = getK(i, j, x, y);
                        double b = j - k * i;
                        q[t ++] = new Line(k, b);
                        System.out.println(k+" "+b+" ");
                    }
                }

            }
        }
        //排序

        Arrays.sort(q, 0, t);
        int res = 1; //k ：{1,1,2,2,3,3}  {1,2,3}
        for( int i = 1; i < t; i ++)
            if( Math.abs(q[i].k - q[i - 1].k ) > esp || Math.abs(q[i].b - q[i - 1].b ) > esp)
                res ++;

        System.out.println(res + N + M);
    }
}

