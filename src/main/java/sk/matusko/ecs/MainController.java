package sk.matusko.ecs;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/")
    public String home() {
        return "Hello Docker World, i have added webhooks";
    }
}
