package hufs2021.jeongbo.controller.page;

import hufs2021.jeongbo.dto.SessionDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
//@RequestMapping("templates")
public class PageController {

    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("/index");
    }

    @GetMapping("/mypage")
    public ModelAndView myPage(HttpServletRequest request, HttpServletResponse response, Object handler){
        HttpSession httpSession = request.getSession();
        System.out.println(httpSession);
        SessionDto sessionItem = (SessionDto) httpSession.getAttribute("USER");
        System.out.println(sessionItem);
        return new ModelAndView("/mypage");
    }

    @GetMapping("/mypage/changepassword")
    public ModelAndView changePw(){
        return new ModelAndView("/changepassword");
    }

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("/login");
    }
}
