package Factory.abstractFactory.Python;

import Factory.abstractFactory.INote;

public class PythonNote implements INote {
    @Override
    public void edit() {
        System.out.println("编写python笔记");
    }
}
