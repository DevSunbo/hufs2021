package hufs2021.jeongbo.service;

import hufs2021.jeongbo.model.entity.User;
import hufs2021.jeongbo.model.enumclass.RoleEnum;
import hufs2021.jeongbo.network.Header;
import hufs2021.jeongbo.network.request.UserRequest;
import hufs2021.jeongbo.network.response.UserResponse;
import hufs2021.jeongbo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    public Header<UserResponse> create(UserRequest userRequest) {
        PasswordEncoder passwordEncoder = passwordEncoder();
        String encodedPassword = passwordEncoder.encode(userRequest.getPassword());

        User user = User.builder()
                .studentId(userRequest.getStudentId())
                .name(userRequest.getName())
                .phoneNumber(userRequest.getPhoneNumber())
                .email(userRequest.getEmail())
                .password(encodedPassword)
                .role(RoleEnum.USER)
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

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public Header<UserResponse> readAll() {
        List<User> userList = userRepository.findAll();

        if (userList != null) {
            userList.stream().forEach(user -> {
                System.out.println(user.getStudentId());
                System.out.println(user.getName());
                System.out.println(user.getPhoneNumber());
                System.out.println(user.getEmail());
                System.out.println(user.getPassword());
                System.out.println(user.getCreatedAt());
                System.out.println(user.getCreatedBy());
                System.out.println(user.getUpdatedAt());
                System.out.println(user.getUpdatedBy());
                System.out.println(user.getMCode());
                System.out.println("-----------------------------");
            });
            return Header.OK();
        }
        else
            return Header.ERROR();
    }

    public Header<UserResponse> read(Integer id) {
        return userRepository.findById(id)
                .map(user -> {
                    System.out.println(user.getStudentId());
                    System.out.println(user.getName());
                    System.out.println(user.getPhoneNumber());
                    System.out.println(user.getEmail());
                    System.out.println(user.getPassword());
                    System.out.println(user.getCreatedAt());
                    System.out.println(user.getCreatedBy());
                    System.out.println(user.getUpdatedAt());
                    System.out.println(user.getUpdatedBy());
                    System.out.println(user.getMCode());
                    System.out.println("-----------------------------");
                    return user;
                }).map(user -> Header.OK(response(user)))
                .orElseGet(Header::ERROR);
    }

    public Header<UserResponse> update(UserRequest userRequest) {
        return userRepository.findById(userRequest.getStudentId())
                .map(user -> {
                    user.setStudentId(userRequest.getStudentId());
                    user.setName(userRequest.getName());
                    user.setPhoneNumber(userRequest.getPhoneNumber());
                    user.setEmail(userRequest.getEmail());
                    user.setPassword(userRequest.getPassword());
                    user.setUpdatedAt(LocalDateTime.now());
                    user.setUpdatedBy(userRequest.getUpdatedBy());
                    user.setMCode(userRequest.getMCode());
                    return user;
                }).map(user -> userRepository.save(user))
                .map(user -> Header.OK(response(user)))
                .orElseGet(Header::ERROR);
    }

    public Header<UserResponse> delete(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);

        userOptional.ifPresent(user -> userRepository.delete(user));

        return Header.OK();
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

    public Header<UserResponse> authenticate(String email, String password) {
        User user = userRepository.findByEmail(email).orElse(null);

        if(passwordEncoder().matches(password, user.getPassword()))
            return Header.OK(response(user));
        return Header.ERROR();
//        passwordEncoder().matches(password, user.getPassword()); //후자는 암호화된 패스워드 익셉션 필요

    }
}