package hufs2021.jeongbo.controller.login;

import hufs2021.jeongbo.model.dto.SessionDto;
import hufs2021.jeongbo.network.Header;
import hufs2021.jeongbo.network.request.SessionRequestVo;
import hufs2021.jeongbo.network.request.UserRequest;
import hufs2021.jeongbo.network.response.UserResponse;
import hufs2021.jeongbo.service.login.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/register")
    @ResponseBody
    public Header<UserResponse> register(@RequestBody UserRequest userRequest) {
        return sessionService.register(userRequest);
    }

//    @PostMapping(value = "/process", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/process", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest request, SessionRequestVo sessionRequestVo) {
        SessionDto sessionDto = sessionService.authentication(sessionRequestVo.getStudentId(), sessionRequestVo.getPassword());

        System.out.println("rlakdlfsj");


        if (sessionDto != null) {
            HttpSession session = request.getSession(true);


            session.setAttribute("student_id", sessionDto.getStudentId());
            session.setAttribute("name", sessionDto.getName());
            session.setAttribute("role", sessionDto.getRole());

            System.out.println(session.getAttribute("student_id"));
            System.out.println(session.getAttribute("name"));
            System.out.println(session.getAttribute("role"));
            return "redirect:/success";
        }
        else
            return "redirect:/error";
    }
}
