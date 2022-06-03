package Factory.abstractFactory.Python;

import Factory.abstractFactory.IVideo;

public class PythonVideo implements IVideo {

    @Override
    public void record() {
        System.out.println("录制python视频");
    }
}
