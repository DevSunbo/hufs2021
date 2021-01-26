package hufs2021.jeongbo.controller.login;

import hufs2021.jeongbo.controller.page.PageController;
import hufs2021.jeongbo.dto.LoginDto;
import hufs2021.jeongbo.dto.SessionDto;
import hufs2021.jeongbo.exceptions.LoginNotExistIdException;
import hufs2021.jeongbo.model.entity.User;
import hufs2021.jeongbo.model.network.Header;
import hufs2021.jeongbo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    PageController pageController;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;
    //TODO : interceptor로 보내는 메소드
    //TODO : password hash해서 일치 확인

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Header login(@RequestBody LoginDto loginDto, HttpServletRequest request) throws LoginNotExistIdException {
        System.out.println("Json" + loginDto);
        User user = userRepository.findById(loginDto.getSid()).orElseThrow(() ->new LoginNotExistIdException("id"));
        if(passwordEncoder.matches(loginDto.getPassword(), user.getPassword())){
            System.out.println("Login success");
            /*System.out.println("name : " + user.getName());
            System.out.println("sid : " + user.getStudentId());
            System.out.println(user);*/

           /* SessionDto sessionDto = new SessionDto(user.getName(), user.getStudentId());

            HttpSession httpSession = request.getSession(true);
            httpSession.setAttribute("USER", sessionDto);*/
            /*httpSession.setAttribute("name", user.getName());
            httpSession.setAttribute("sid", user.getStudentId());*/


        }
        else{
            throw new LoginNotExistIdException("pw");
        }
        //userRepository.findByPassword(passwordEncoder.encode(loginDto.getPassword())).orElseThrow(() -> new LoginNotExistIdException("pw"));
        //System.out.println("Login success");
        return Header.OK();
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView loginForm(LoginDto loginDto, HttpServletRequest request) throws LoginNotExistIdException {
        System.out.println("form " + loginDto);
        User user = userRepository.findById(loginDto.getSid()).orElseThrow(() ->new LoginNotExistIdException("id"));
        if(passwordEncoder.matches(loginDto.getPassword(), user.getPassword())){
            System.out.println("Login success");
            /*System.out.println("name : " + user.getName());
            System.out.println("sid : " + user.getStudentId());
            System.out.println(user);*/

            SessionDto sessionDto = new SessionDto(user.getName(), user.getStudentId());

            HttpSession httpSession = request.getSession(true);
            httpSession.setAttribute("USER", sessionDto);
            /*httpSession.setAttribute("name", user.getName());
            httpSession.setAttribute("sid", user.getStudentId());*/

            return new RedirectView("mypage");

        }
        else{
            throw new LoginNotExistIdException("pw");
        }
        //userRepository.findByPassword(passwordEncoder.encode(loginDto.getPassword())).orElseThrow(() -> new LoginNotExistIdException("pw"));
        //System.out.println("Login success");
    }


}