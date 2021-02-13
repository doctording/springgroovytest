package com.example.demoapi.control;

import com.example.demoapi.util.SpringContextUtils;
import com.example.service.HelloService;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.lang.reflect.Method;

/**
 * @Author mubi
 * @Date 2021/2/12 18:29
 */
@RestController
public class GroovyController {

    @Autowired
    private HelloService helloService;

    @PostMapping("/runScript")
    public Object runScript(String script) throws Exception {
        if (script != null) {
            // 这里其实就是groovy的api动态的加载生成一个Class，然后反射生成对象，然后执行run方法，最后返回结果
            // 1. 通过SpringContextUtils.autowireBean可以实现自动注入bean
            // 2. 然后引用其它bean，实现对这个bean的方法的测试调用
            ClassLoader parent = this.getClass().getClassLoader();
            GroovyClassLoader loader = new GroovyClassLoader(parent);
            Class clazz = loader.parseClass(script);
            Method run = clazz.getMethod("run");
            Object o = clazz.newInstance();
            SpringContextUtils.autowireBean(o);
            Object ret = run.invoke(o);
            return ret;
        } else {
            return "no script";
        }
    }

    /**
     * 修改hello.groovy，每次调用都生成新的对象 ==》即可以动态改变方法返回
     * @param id
     * @return
     */
    @GetMapping(value = "/groovy/{id}")
    public String myTest1(@PathVariable String id){
        try {
            ClassLoader parent = this.getClass().getClassLoader();
            GroovyClassLoader loader = new GroovyClassLoader(parent);
            String path = "spring-groovy-api/src/main/java/com/example/demoapi/hello.groovy";
            // 加载groovy文件得到Class
            Class groovyClass = loader.parseClass(new File(path));
            // 实例化对象并调用
            GroovyObject groovyObject = (GroovyObject)groovyClass.newInstance();
            String result = (String) groovyObject.invokeMethod("test", id);
            return result;
        } catch (Exception ex) {
            return ex.toString();
        }
    }

    @GetMapping(value = "/groovy-hello/{what}")
    public String helloGroovy(@PathVariable String what){
        return helloService.say(what);
    }
}
