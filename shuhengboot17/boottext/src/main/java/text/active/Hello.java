package text.active;
import org.springframework.web.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @RequestMapping("/hello")
    public String hello(){
        return "hello,spring boot!";
    }
}
