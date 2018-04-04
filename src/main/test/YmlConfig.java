import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:application.yml"}, encoding = "utf-8")
public class YmlConfig {

    @Value("${server.port}")
    public static String port;
    @Value("${server.address}")
    public static String address;
    @Value("${server.name}")
    public static String name;



}

