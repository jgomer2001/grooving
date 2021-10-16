package io.jans.groovypoc;

import groovy.lang.GroovyClassLoader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;
        
public class test {
    static final Charset utf8 = StandardCharsets.UTF_8;    
    static ClassLoader loader = test.class.getClassLoader();
    
    static void test1(String fileName) throws Exception {
        
        Reader r = new InputStreamReader(loader.getResourceAsStream(fileName), utf8);

        GroovyClassLoader gcl = new GroovyClassLoader();
        Class cls = gcl.parseClass(r, fileName);
        System.out.println("\nClass name is: " + cls.getName());
        
        Method aMethod = null;
        for (Method m : cls.getDeclaredMethods()) {
            String name = m.getName();
            System.out.println("Method found " + name + ". Modifiers: " + m.getModifiers());
            if (name.equals("doIt")) {
                aMethod = m;
            }
        }
        
        Object obj = cls.newInstance();
        aMethod.invoke(obj, new Object[]{});
        System.out.println();
        
    }
    
    static void test2(String fileName) throws Exception {
        Reader r = new InputStreamReader(loader.getResourceAsStream(fileName), utf8);

        GroovyClassLoader gcl = new GroovyClassLoader();
        Object object = gcl.parseClass(r, fileName).newInstance();
        Callable<Void> obj = (Callable<Void>) object;
        
        obj.call();
        obj.call();
        obj.call();
        obj.call();
    }
    
    static void test3(String fileName) throws Exception {
        Reader r = new InputStreamReader(loader.getResourceAsStream(fileName), utf8);

        GroovyClassLoader gcl = new GroovyClassLoader();
        gcl.parseClass(r, fileName).newInstance();
    }
    
    public static void main(String... args) throws Exception {
    
        System.out.println("Please uncomment the lines below one by one");
        
        //test1("file1.groovy");
        //test1("file2.java");        
        //test2("file3.java");
        //test3("file4.java");
        
    }

}