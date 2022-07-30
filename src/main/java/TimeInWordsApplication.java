import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.webTemplate.config.web",  // MVC @Configuration
        "com.webTemplate.config.jpa", // Database @Configuration -> does Entity Scan and Repository scan
        "com.webTemplate.service", // Service scan @Service
        "com.webTemplate.controler", // Controller scan @Controller
})
public class TimeInWordsApplication {

    TimeInWordService timeInWordService= new TimeInWordService();
    @RequestMapping("/")
    String home(@RequestParam String time) {
        return timeInWordService.convert(time);
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(TimeInWordsApplication.class, args);
    }
}
