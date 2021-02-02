package hufs2021.jeongbo.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Getlogin")
public class GetLoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm() {
        return "loginPage";
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

//        if(session!=null)
        return "successPage";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error(HttpServletRequest request) {
        return "error";
    }
}
