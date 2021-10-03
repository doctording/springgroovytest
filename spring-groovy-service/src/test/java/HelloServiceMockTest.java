import com.example.service.HelloService;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
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

	@Test
	public void testByteBuddy() throws Exception{
		String helloWorld = new ByteBuddy()
				.subclass(Object.class)
				.method(ElementMatchers.named("toString"))
				.intercept(FixedValue.value("Hello World!"))
				.make()
				.load(getClass().getClassLoader())
				.getLoaded()
				.newInstance()
				.toString();
		Assert.assertEquals(helloWorld, "Hello World!");
	}

}
