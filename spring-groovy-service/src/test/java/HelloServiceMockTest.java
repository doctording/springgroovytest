import com.example.service.HelloService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HelloServiceMockTest {

	@Test
	public void testHelloSay(){
		HelloService helloService = Mockito.mock(HelloService.class);
		String str = "abc";
		Mockito.when(helloService.say(Mockito.anyString())).thenReturn("xx:" + str);
		String what = helloService.say("xxx");
		Assert.assertEquals(what, "xx:" + str);
	}

}
