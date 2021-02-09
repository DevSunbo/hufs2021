package hufs2021.jeongbo.controller.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import hufs2021.jeongbo.model.entity.User;
import hufs2021.jeongbo.network.response.UserResponse;
import hufs2021.jeongbo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class HeaderApiController {

    @Autowired
    UserRepository userRepository;

    /*@GetMapping("/userinfo")
    public Map<String, String > userInfo(){
        HashMap<String, String> map = new HashMap<>();
        User user = userRepository.findByStudentId(201601806);
        map.put("studentId", user.getStudentId()+"");
        map.put("name", user.getName());
        return map;

    }*/

    @GetMapping("/userinfo")
    public String userInfo(){
        List<JsonObject> userList = new ArrayList<>();
        JsonArray jsonElements = new JsonArray();
        User user = userRepository.findByStudentId(201601806);
        JsonObject obj = new JsonObject();
        obj.addProperty("studentId", user.getStudentId());
        obj.addProperty("name", user.getName());
        userList.add(obj);

        System.out.println("ojb " + userList);
        return userList.toString();

    }
}
