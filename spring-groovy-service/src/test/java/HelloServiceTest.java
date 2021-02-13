import com.example.DemoServiceApplication;
import com.example.demorepo.repository.model.TbUser;
import com.example.service.HelloService;
import com.example.service.TbUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {DemoServiceApplication.class})
public class HelloServiceTest {

	@Autowired
	HelloService helloService;

	@Test
	public void testHelloSay(){
		String rs = helloService.say("abc");
		Assert.assertTrue("groovy2:abc".equals(rs));
	}

}
