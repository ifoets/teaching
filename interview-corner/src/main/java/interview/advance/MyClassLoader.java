package interview.advance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader{

    private final String classDir;

    public MyClassLoader(String classDir)
    {
        this.classDir = classDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException
    {
       try{
           String path =classDir +"/"+name.replace('.','/')+".class";
           byte[] bytes = Files.readAllBytes(Paths.get(path));
           return defineClass(name,bytes,0,bytes.length);
       }catch (IOException e)
       {
           throw  new ClassNotFoundException("Can not load class : "+name, e);
       }
    }
}
