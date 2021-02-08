package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.User;
import hufs2021.jeongbo.network.response.UserResponse;
import hufs2021.jeongbo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HeaderApiController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/userInfo")
    public Map<String, String > userInfo(){
        HashMap<String, String> map = new HashMap<>();
        User user = userRepository.findByStudentId(201601806);
        map.put("name", user.getName());
        return map;

    }
}
