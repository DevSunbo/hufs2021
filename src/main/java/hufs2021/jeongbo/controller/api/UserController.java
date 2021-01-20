package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.User;
import hufs2021.jeongbo.network.Header;
import hufs2021.jeongbo.network.request.UserRequest;
import hufs2021.jeongbo.network.response.UserResponse;
import hufs2021.jeongbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    @ResponseBody
    public Header<UserResponse> create(@RequestBody UserRequest userRequest) {

        return userService.create(userRequest);
    }

    @GetMapping("/readall")
    @ResponseBody
    public Header<UserResponse> readAll() {

        return userService.readAll();
    }

    @GetMapping("/read")
    @ResponseBody
    public Header<UserResponse> read(@RequestParam Integer id) {

        return userService.read(id);
    }

    @PutMapping("/update")
    @ResponseBody
    public Header<UserResponse> update(@RequestBody UserRequest userRequest) {

        return userService.update(userRequest);
    }

    @DeleteMapping("/delete")
    public Header<UserResponse> delete(@RequestParam Integer id) {

        return userService.delete(id);
    }

    private UserResponse response(User user) {
        return UserResponse.builder()
                .studentId(user.getStudentId())
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .password(user.getPassword())
                .createdAt(user.getCreatedAt())
                .createdBy(user.getCreatedBy())
                .updatedAt(user.getUpdatedAt())
                .updatedBy(user.getUpdatedBy())
                .mCode(user.getMCode())
                .build();

    }
}
