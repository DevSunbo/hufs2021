package hufs2021.jeongbo.controller.login;

import hufs2021.jeongbo.model.entity.User;
import hufs2021.jeongbo.model.network.Header;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignupController {

    @PostMapping("/")
    public Header signup(@RequestBody User user){
        return Header.OK();
    }
}
