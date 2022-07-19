package DisignMode.Factory.abstractFactory.Java;

import DisignMode.Factory.abstractFactory.INote;

public class JavaNote implements INote {
    @Override
    public void edit() {
        System.out.println("编写JAVA笔记");
    }
}
