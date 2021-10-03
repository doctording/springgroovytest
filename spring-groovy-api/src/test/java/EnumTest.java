import com.alibaba.fastjson.JSON;
import com.example.demoapi.enums.TypeEnum;
import org.junit.Test;

/**
 * @Author mubi
 * @Date 2021/6/5 10:59
 */
public class EnumTest {

    @Test
    public void testTypeEnum() throws Exception {
        TypeEnum typeEnum = TypeEnum.TYPE1;
        String jsonString = JSON.toJSONString(typeEnum);
        System.out.println(jsonString);
        TypeEnum typeEnum1 = JSON.parseObject(jsonString, TypeEnum.class);
        System.out.println(typeEnum1);
    }
}
