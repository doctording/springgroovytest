package com.example.demoapi.control;

import com.example.demoapi.util.SpringContextUtils;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
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

    @GetMapping(value = "/groovy/{id}")
    public String myTest1(@PathVariable String id){
        try {
            ClassLoader parent = this.getClass().getClassLoader();
            GroovyClassLoader loader = new GroovyClassLoader(parent);
            Class groovyClass = loader.parseClass(
                    new File("spring-groovy-api/src/main/java/com/example/demoapi/hello.groovy")
            );

            GroovyObject groovyObject = (GroovyObject)groovyClass.newInstance();
            String result = (String) groovyObject.invokeMethod("test", id);
            return result;
        } catch (Exception ex) {
            return ex.toString();
        }
    }
}
