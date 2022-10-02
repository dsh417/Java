package test;
import java.io.File;
import java.io.IOException;

public class FileText {
    public static void main(String[] args) throws IOException, InterruptedException {
//        第三题
        String path="/Users/duanshuheng/Downloads/jdk-19_macos-aarch64_bin";
        FileStack(path);
    }

    public static void FileStack(String path){
        try {
            File file=new File(path);
            File[] files=file.listFiles();
            for (File f : files) {
                if(f.isDirectory()){
                    FileStack(path+"/"+f.getName());
                }else {
                    int num=0;
                    FileDelete(f);
                }
            }
            file.deleteOnExit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void FileDelete(File file){
        file.deleteOnExit();
    }
}
