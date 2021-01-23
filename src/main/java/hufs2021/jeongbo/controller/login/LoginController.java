package hufs2021.jeongbo.controller.login;

import hufs2021.jeongbo.dto.LoginDto;
import hufs2021.jeongbo.exceptions.LoginNotExistIdException;
import hufs2021.jeongbo.model.entity.User;
import hufs2021.jeongbo.model.network.Header;
import hufs2021.jeongbo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;
    //TODO : interceptor로 보내는 메소드
    //TODO : password hash해서 일치 확인

    @PostMapping("")
    public Header login(@RequestBody LoginDto loginDto) throws LoginNotExistIdException {
        System.out.println(loginDto);
        User user = userRepository.findById(loginDto.getSid()).orElseThrow(() ->new LoginNotExistIdException("id"));
        if(passwordEncoder.matches(loginDto.getPassword(), user.getPassword())){
            System.out.println("Login success");
        }
        else{
            throw new LoginNotExistIdException("pw");
        }
        //userRepository.findByPassword(passwordEncoder.encode(loginDto.getPassword())).orElseThrow(() -> new LoginNotExistIdException("pw"));
        //System.out.println("Login success");
        return Header.OK();


    }
}