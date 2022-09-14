package disign.Proxy.DynamicProxy.TearJDKProxy;

import java.io.*;

public class GPClassLoader extends ClassLoader {
    private File classPathFile;

    public GPClassLoader() {
        //构造器。获取要动态生成文件的地址并新建文件
        String classPath=GPClassLoader.class.getResource("").getPath();
        this.classPathFile=new File(classPath);
    }

    public Class<?> findClass(String name)throws ClassNotFoundException {
        String className=GPClassLoader.class.getPackage().getName()+"."+name;

        if(classPathFile!=null){
            File classFile=new File(classPathFile,name.replaceAll("\\.","/")+".class");
            if(classFile.exists()){
                FileInputStream in=null;
                ByteArrayOutputStream out=null;

                try {
                    in=new FileInputStream(classFile);
                    out=new ByteArrayOutputStream();
                    byte[] buff=new byte[1024];
                    int len;
                    while((len=in.read(buff))!=-1){
                        out.write(buff,0,len);
                    }
                    return defineClass(className,out.toByteArray(),0,out.size());

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }finally {
                    if (null != in) {
                        try {
                            in.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    if(null!=out){
                        try {
                            out.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
        return null;
    }
}
