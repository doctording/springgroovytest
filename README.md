spring + groovy

直接运行api，然后脚本或浏览器访问api即可(相当于开了后面，可以对任意bean进行方法调用执行)

![](./imgs/test.png)

---

groovy脚本执行springBean方法

目的：直接post请求，请求体能执行bean，如下执行helloBean的func方法和func2方法

```java
// func方法
helloBean.func();

// func2方法
helloBean.func2(1, 2);
```

即想怎么调用spring bean的方法就怎么调用着玩；不用像以前还要对每个方法单独写个测试的controller方法

实现具体见：`springgroovytest/spring-groovy-api/src/main/java/com/example/demoapi/control/GroovyScriptController.java`
