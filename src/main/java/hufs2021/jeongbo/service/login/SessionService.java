package hufs2021.jeongbo.service.login;

import hufs2021.jeongbo.model.dto.SessionDto;
import hufs2021.jeongbo.model.entity.User;
import hufs2021.jeongbo.network.Header;
import hufs2021.jeongbo.network.request.UserRequest;
import hufs2021.jeongbo.network.response.UserResponse;
import hufs2021.jeongbo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SessionService {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public Header<UserResponse> register(UserRequest userRequest) {
        User user = User.builder()
                .studentId(userRequest.getStudentId())
                .name(userRequest.getName())
                .phoneNumber(userRequest.getPhoneNumber())
                .email(userRequest.getEmail())
                .password(passwordEncoder().encode(userRequest.getPassword()))
                .createdAt(LocalDateTime.now())
                .createdBy(userRequest.getCreatedBy())
                .mCode(userRequest.getMCode())
                .build();

        if(user.getStudentId().equals("") || user.getEmail().equals(""))
            return Header.ERROR("null error");

        User newUser = userRepository.save(user);

        if(newUser==null)
            return Header.ERROR();
        return Header.OK(response(newUser));

    }

    /*public String login(SessionRequestVo sessionRequestVo) {
        HttpServletRequest request;
        Integer studentId = sessionRequestVo.getStudentId();
        String password = sessionRequestVo.getPassword();

        SessionDto authResult = this.authentication(studentId, password);


        if(authResult!=null){
            HttpSession session = request.getSession(true);
            session.setAttribute("student_id", );
        }
        else
            return "error";


        return null;
    }*/

    public SessionDto authentication(Integer studentId, String password) {
        User user = userRepository.findById(studentId).orElse(null);

        if (user == null)
            return null;

        if(!passwordEncoder().matches(password, user.getPassword()))
            return null;
        else{
            SessionDto sessionDto = SessionDto.builder()
                    .studentId(user.getStudentId())
                    .name(user.getName())
                    .role(user.getRole())
                    .build();

            return sessionDto;
        }

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
