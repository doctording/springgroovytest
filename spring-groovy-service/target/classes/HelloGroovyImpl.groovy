

import com.example.service.HelloService

class HelloGroovyImpl implements HelloService {

    private String prefix = "groovy2:"

    @Override
    String say(String what) {
        return prefix + what
    }
}
