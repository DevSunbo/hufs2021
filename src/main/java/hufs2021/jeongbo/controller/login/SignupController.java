package hufs2021.jeongbo.controller.login;

import hufs2021.jeongbo.model.entity.User;
import hufs2021.jeongbo.model.network.Header;
import hufs2021.jeongbo.model.network.request.StudyRoomApiRequest;
import hufs2021.jeongbo.network.request.UserRequest;
import hufs2021.jeongbo.network.response.UserResponse;
import hufs2021.jeongbo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("")
    public Header<UserResponse> signup(@RequestBody UserRequest userRequest) {
        System.out.println(userRequest);
        String encodedPassword = passwordEncoder.encode(userRequest.getPassword());  //BCryptPasswordEncoder

        System.out.println(userRequest.getEmail());
        System.out.println(encodedPassword);
        User user = User.builder()
                .studentId(userRequest.getStudentId())
                .name(userRequest.getName())
                .phoneNumber(userRequest.getPhoneNumber())
                .email(userRequest.getEmail())
                .password(encodedPassword)
                .createdAt(LocalDateTime.now())
                .createdBy(userRequest.getCreatedBy())
                .mCode(1)
                .build();

        /*User user = new User();
        user.setStudentId(userRequest.getStudentId());
        user.setName(userRequest.getName());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setEmail(userRequest.getEmail());
        user.setPassword(encodedPassword);
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy(userRequest.getCreatedBy());
        user.setMCode(userRequest.getMCode());*/


        System.out.println("user + " + user.getEmail());
        User newUser = userRepository.save(user);

        if (newUser != null)
            return Header.OK();
        else
            return Header.ERROR("error");
    }

}
