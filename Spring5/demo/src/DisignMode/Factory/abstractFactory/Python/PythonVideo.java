package DisignMode.Factory.abstractFactory.Python;

import DisignMode.Factory.abstractFactory.IVideo;

public class PythonVideo implements IVideo {

    @Override
    public void record() {
        System.out.println("录制python视频");
    }
}
