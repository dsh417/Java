package DisignMode.Prototype.DeepClones;

import java.io.*;
import java.util.Date;

public class Qitiandasheng extends Monkey implements Serializable,Cloneable{
    public JinGuBang jinGuBang;

    public Qitiandasheng(){
        this.birthday=new Date();
        this.jinGuBang=new JinGuBang();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        return this.deepClone();

    }

    private Object deepClone() {
        try {
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            ObjectOutputStream oos=new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois=new ObjectInputStream(bis);

            Qitiandasheng copy=(Qitiandasheng) ois.readObject();
            copy.birthday =new Date();
            return copy;



        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Qitiandasheng shallowClone(Qitiandasheng target){
        Qitiandasheng qitiandasheng=new Qitiandasheng();
        qitiandasheng.height= target.height;
        qitiandasheng.weight= target.weight;

        qitiandasheng.jinGuBang= target.jinGuBang;
        qitiandasheng.birthday=new Date();

        return qitiandasheng;
    }
}
