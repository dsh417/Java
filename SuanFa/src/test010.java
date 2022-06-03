import java.util.HashSet;
public class test010 {
    public static void main(String args[]){
        int N=20;
        int M=21;
        HashSet<Line> hash=new HashSet<>();
        for(int x1=0;x1<N;x1++){
            for(int y1=0;y1<M;y1++){
                for(int x2=0;x2<N;x2++){
                    for(int y2=0;y2<M;y2++){
                        if(y1==y2 || x1==x2)continue;
                        double temp=getk(x1,y1,x2,y2);
                        double b=y1-temp*x1;
                        hash.add(new Line(temp,b));

                    }
                }
            }
        }
        System.out.println(hash.size()+N+M);
    }

    public static double getk(int x1, int y1, int x2, int y2){
        return (double)(y1-y2)/(x1-x2);
    }

    public static int getGcd(int i,int j){
        int temp=1;
        int gcd=1;
        while(temp<=i && temp<=j){
            if(temp%i==0 && temp%j==0){
                gcd=temp;
            }
            temp++;
        }
        return gcd;
    }

    public static class Line{

        private double k;
        private double b;

        public Line(double k1,double b1){
            this.k=k1;
            this.b=b1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if(o==null){
                return false;
            }
            if(this.getClass()!=o.getClass()){
                return false;
            }

            Line line=(Line) o;
            if(line.k==this.k && line.b==this.b ){
                return true;
            }

            return false;

        }

        @Override
        public int hashCode() {
            int pemit=17;
            int result=1;
            result=pemit*result+Double.hashCode(k);
            result=pemit*result+Double.hashCode(b);
            return result;
        }
    }
}


