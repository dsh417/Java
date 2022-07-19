package DisignMode.Factory.abstractFactory.Java;

import DisignMode.Factory.abstractFactory.IVideo;

public class JavaVideo implements IVideo {

    @Override
    public void record() {
        System.out.println("录制java视频");
    }
}
