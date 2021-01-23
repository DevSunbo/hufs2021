package hufs2021.jeongbo.controller.page;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
//@RequestMapping("templates")
public class PageController {

    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("/index");
    }

    @GetMapping("mypage")
    public ModelAndView myPage(){
        return new ModelAndView("/mypage");
    }
}
