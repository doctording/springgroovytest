import org.springframework.beans.factory.annotation.Autowired
import com.example.service.TbUserService

class Foo {

    @Autowired
    TbUserService tbUserService

//    Object run() {
//        // do something
//        def f = tbUserService.getById(1)
//        if (f != null) {
//            return f.name
//        }
//        return null
//    }

    Object run() {
        // do something
        def f = tbUserService.fortest()
        if (f != null) {
            return f
        }
        return null
    }

}