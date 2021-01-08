package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.TeamProject;
import hufs2021.jeongbo.network.Header;
import hufs2021.jeongbo.network.request.TeamProjectRequest;
import hufs2021.jeongbo.network.response.TeamProjectResponse;
import hufs2021.jeongbo.repository.TeamProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/team-project")
public class TeamProjectController {

    @Autowired
    private TeamProjectRepository teamProjectRepository;

    @PostMapping("/create")
    @ResponseBody
    public Header<TeamProjectRequest> create(@RequestBody TeamProjectRequest teamProjectRequest) {
        TeamProject teamProject = TeamProject.builder()
                .pField(teamProjectRequest.getPField())
                .pName(teamProjectRequest.getPName())
                .pMin(teamProjectRequest.getPMin())
                .pMax(teamProjectRequest.getPMax())
                .pDeadline(teamProjectRequest.getPDeadline())
                .pMainLanguage(teamProjectRequest.getPMainLanguage())
                .pLocation(teamProjectRequest.getPLocation())
                .pContent(teamProjectRequest.getPContent())
                .fId(teamProjectRequest.getFId())
                .createdAt(LocalDateTime.now())
                .createdBy(teamProjectRequest.getCreatedBy())
                .studentId(teamProjectRequest.getStudentId())
                .build();

        TeamProject newTeamProject = teamProjectRepository.save(teamProject);

        if(newTeamProject!=null)
            return Header.OK();
        else
            return Header.ERROR();

//        return teamProjectRequest;
    }

    private TeamProjectResponse response(TeamProject teamProject) {
        return TeamProjectResponse.builder()
                .pNumber(teamProject.getPNumber())
                .pField(teamProject.getPField())
                .pName(teamProject.getPName())
                .pMin(teamProject.getPMin())
                .pMax(teamProject.getPMax())
                .pDeadline(teamProject.getPDeadline())
                .pMainLanguage(teamProject.getPMainLanguage())
                .pLocation(teamProject.getPLocation())
                .pContent(teamProject.getPContent())
                .fId(teamProject.getFId())
                .createdAt(teamProject.getCreatedAt())
                .createdBy(teamProject.getCreatedBy())
                .updatedAt(teamProject.getUpdatedAt())
                .updatedBy(teamProject.getUpdatedBy())
                .studentId(teamProject.getStudentId())
                .build();
    }
}
