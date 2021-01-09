package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.TeamProjectApply;
import hufs2021.jeongbo.network.Header;
import hufs2021.jeongbo.network.request.TeamProjectApplyRequest;
import hufs2021.jeongbo.network.response.TeamProjectApplyResponse;
import hufs2021.jeongbo.repository.TeamProjectApplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/readall")
    @ResponseBody
    public Header<TeamProjectApplyResponse> readAll() {
        List<TeamProjectApply> teamProjectApplyList = teamProjectApplyRepository.findAll();

        if(teamProjectApplyList!=null){
            teamProjectApplyList.stream().forEach(teamProjectApply -> {
                System.out.println(teamProjectApply.getPaNumber());
                System.out.println(teamProjectApply.getPaContent());
                System.out.println(teamProjectApply.getPaApproved());
                System.out.println(teamProjectApply.getFId());
                System.out.println(teamProjectApply.getCreatedAt());
                System.out.println(teamProjectApply.getCreatedBy());
                System.out.println(teamProjectApply.getUpdatedAt());
                System.out.println(teamProjectApply.getUpdatedBy());
                System.out.println(teamProjectApply.getStudentId());
                System.out.println(teamProjectApply.getPNumber());
                System.out.println("------------------------------");
            });
            return Header.OK();
        }
        else
            return Header.ERROR();
    }

    @GetMapping("/read")
    @ResponseBody
    public Header<TeamProjectApplyResponse> read(@RequestParam Integer number) {
        return teamProjectApplyRepository.findById(number)
                .map(teamProjectApply -> {
                    System.out.println(teamProjectApply.getPaNumber());
                    System.out.println(teamProjectApply.getPaContent());
                    System.out.println(teamProjectApply.getPaApproved());
                    System.out.println(teamProjectApply.getFId());
                    System.out.println(teamProjectApply.getCreatedAt());
                    System.out.println(teamProjectApply.getCreatedBy());
                    System.out.println(teamProjectApply.getUpdatedAt());
                    System.out.println(teamProjectApply.getUpdatedBy());
                    System.out.println(teamProjectApply.getStudentId());
                    System.out.println(teamProjectApply.getPNumber());
                    System.out.println("--------------------------------");
                    return teamProjectApply;
                }).map(teamProjectApply -> Header.OK(response(teamProjectApply)))
                .orElseGet(Header::ERROR);
    }

    @PutMapping("/update")
    @ResponseBody
    public Header<TeamProjectApplyResponse> update(@RequestBody TeamProjectApplyRequest teamProjectApplyRequest) {
        return teamProjectApplyRepository.findById(teamProjectApplyRequest.getPaNumber())
                .map(teamProjectApply -> {
                    teamProjectApply.setPaContent(teamProjectApplyRequest.getPaContent());
                    teamProjectApply.setPaApproved(teamProjectApplyRequest.getPaApproved());
                    teamProjectApply.setFId(teamProjectApplyRequest.getFId());
                    teamProjectApply.setUpdatedAt(LocalDateTime.now());
                    teamProjectApply.setUpdatedBy(teamProjectApplyRequest.getUpdatedBy());
                    return teamProjectApply;
                }).map(teamProjectApply -> teamProjectApplyRepository.save(teamProjectApply))
                .map(teamProjectApply -> Header.OK(response(teamProjectApply)))
                .orElseGet(Header::ERROR);
    }

    @DeleteMapping("/delete")
    public Header<TeamProjectApplyResponse> delete(@RequestParam Integer number) {
        Optional<TeamProjectApply> teamProjectApplyOptional = teamProjectApplyRepository.findById(number);

        teamProjectApplyOptional.ifPresent(teamProjectApply -> teamProjectApplyRepository.delete(teamProjectApply));

        return Header.OK();
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
