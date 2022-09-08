package disign.Factory.abstractFactory.Java;

import disign.Factory.abstractFactory.IVideo;

public class JavaVideo implements IVideo {

    @Override
    public void record() {
        System.out.println("录制java视频");
    }
}
