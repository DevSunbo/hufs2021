package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.repository.TeamProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teamproject")
public class TeamProjectController {

    @Autowired
    private TeamProjectRepository teamProjectRepository;
}
