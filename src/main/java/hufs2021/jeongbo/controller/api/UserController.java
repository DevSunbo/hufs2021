package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.User;
import hufs2021.jeongbo.network.Header;
import hufs2021.jeongbo.network.request.UserRequest;
import hufs2021.jeongbo.network.response.UserResponse;
import hufs2021.jeongbo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    @ResponseBody
    public Header<UserResponse> create(@RequestBody UserRequest userRequest) {
        User user = User.builder()
                .studentId(userRequest.getStudentId())
                .name(userRequest.getName())
                .phoneNumber(userRequest.getPhoneNumber())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .createdAt(LocalDateTime.now())
                .createdBy(userRequest.getCreatedBy())
                .mCode(userRequest.getMCode())
                .build();

        User newUser = userRepository.save(user);

        if(newUser!=null)
            return Header.OK();
        else
            return Header.ERROR();
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
