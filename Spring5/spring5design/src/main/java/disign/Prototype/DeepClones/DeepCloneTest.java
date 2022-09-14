package disign.Prototype.DeepClones;

public class DeepCloneTest {
    public static void main(String[] args) {
        Qitiandasheng qitiandashen=new Qitiandasheng();

        try {
            Qitiandasheng clone= (Qitiandasheng) qitiandashen.clone();
            System.out.println("深克隆："+(qitiandashen.jinGuBang== clone.jinGuBang));


        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        } finally {
        }

        Qitiandasheng q=new Qitiandasheng();
        Qitiandasheng n=q.shallowClone(q);
        System.out.println("浅克隆："+(q.jinGuBang==n.jinGuBang));


    }
}
