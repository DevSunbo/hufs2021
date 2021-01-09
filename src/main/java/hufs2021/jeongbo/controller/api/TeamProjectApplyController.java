package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.TeamProjectApply;
import hufs2021.jeongbo.network.Header;
import hufs2021.jeongbo.network.request.TeamProjectApplyRequest;
import hufs2021.jeongbo.network.response.TeamProjectApplyResponse;
import hufs2021.jeongbo.repository.TeamProjectApplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/team-project-apply")
public class TeamProjectApplyController {

    @Autowired
    private TeamProjectApplyRepository teamProjectApplyRepository;

    @PostMapping("/create")
    @ResponseBody
    public Header<TeamProjectApplyResponse> create(@RequestBody TeamProjectApplyRequest teamProjectApplyRequest) {
        TeamProjectApply teamProjectApply = TeamProjectApply.builder()
//                .paNumber(teamProjectApplyRequest.getPaNumber())
                .paContent(teamProjectApplyRequest.getPaContent())
                .paApproved(teamProjectApplyRequest.getPaApproved())
                .fId(teamProjectApplyRequest.getFId())
                .createdAt(LocalDateTime.now())
                .createdBy(teamProjectApplyRequest.getCreatedBy())
                .studentId(teamProjectApplyRequest.getStudentId())
                .pNumber(teamProjectApplyRequest.getPNumber())
                .build();

        TeamProjectApply newTeamProjectApply = teamProjectApplyRepository.save(teamProjectApply);

        if(newTeamProjectApply!=null)
            return Header.OK(response(newTeamProjectApply));
        else
            return Header.ERROR();
    }

    private TeamProjectApplyResponse response(TeamProjectApply teamProjectApply) {
        return TeamProjectApplyResponse.builder()
                .paNumber(teamProjectApply.getPaNumber())
                .paContent(teamProjectApply.getPaContent())
                .paApproved(teamProjectApply.getPaApproved())
                .fId(teamProjectApply.getFId())
                .createdAt(teamProjectApply.getCreatedAt())
                .createdBy(teamProjectApply.getCreatedBy())
                .updatedAt(teamProjectApply.getUpdatedAt())
                .updatedBy(teamProjectApply.getUpdatedBy())
                .studentId(teamProjectApply.getStudentId())
                .pNumber(teamProjectApply.getPNumber())
                .build();
    }
}
