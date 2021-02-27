package com.example.demoapi.control;

import com.example.demoapi.util.SpringContextUtils;
import com.example.service.TbUserService;
import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @Author mubi
 * @Date 2021/2/27 21:16
 */
@RestController
public class GroovyScriptController {

    @PostMapping(value = "/groovy/script/execute")
    public Object execute() throws Exception {
        String scriptStr = "import org.springframework.beans.factory.annotation.Autowired\n" +
                "import com.example.service.TbUserService\n" +
                "\n" +
                "class Foo {\n" +
                "\n" +
                "    @Autowired\n" +
                "    TbUserService tbUserService\n" +
                "\n" +
                "    Object run() {\n" +
                "        // do something\n" +
                "        def f = tbUserService.fortest()\n" +
                "        if (f != null) {\n" +
                "            return f\n" +
                "        }\n" +
                "        return null\n" +
                "    }\n" +
                "\n" +
                "}";
        ClassLoader parent = this.getClass().getClassLoader();
        GroovyClassLoader loader = new GroovyClassLoader(parent);
        Class clazz = loader.parseClass(scriptStr);
        Method run = clazz.getMethod("run");
        Object o = clazz.newInstance();
        SpringContextUtils.autowireBean(o);
        Object ret = run.invoke(o);
        return ret;
    }

    @Autowired
    TbUserService tbUserService;

    /**
     * 执行 tbUserService Bean的相关方法
     * eg1: tbUserService.getById(1)
     * eg2: tbUserService.fortest()
     * @param scriptStr
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/groovy/script/execute/tb")
    public Object executeBinding(@RequestBody String scriptStr) throws Exception {
        Binding groovyBinding = new Binding();
        groovyBinding.setVariable("tbUserService", tbUserService);
        GroovyShell groovyShell = new GroovyShell(groovyBinding);
        Script script = groovyShell.parse(scriptStr);
        Object ret = script.run();
        return ret;
    }

    @PostMapping(value = "/groovy/script/execute/service")
    public Object executeBindingService(@RequestBody String scriptStr) throws Exception {
        GroovyShell groovyShell = new GroovyShell();
        Script script = groovyShell.parse(scriptStr);
        // 设置binding, 如下绑定所有的bean
        // 但是理论上，只需要绑定scriptStr使用到的bean就行
        Binding groovyBinding = new Binding();
//        Map<String, Object> beanMap = SpringContextUtils.getContext().getBeansOfType(Object.class);
//        for (String beanName : beanMap.keySet()) {
//            groovyBinding.setVariable(beanName, beanMap.get(beanName));
//        }
        List<String> beanNameList = Arrays.asList("tbUserService", "helloService");
        for (String beanName : beanNameList) {
            groovyBinding.setVariable(beanName, SpringContextUtils.getBean(beanName));
        }
        script.setBinding(groovyBinding);
        Object ret = script.run();
        return ret;
    }
}
