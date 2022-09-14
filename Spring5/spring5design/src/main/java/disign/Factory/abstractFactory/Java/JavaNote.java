package disign.Factory.abstractFactory.Java;

import disign.Factory.abstractFactory.INote;

public class JavaNote implements INote {
    @Override
    public void edit() {
        System.out.println("编写JAVA笔记");
    }
}
