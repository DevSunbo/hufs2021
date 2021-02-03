package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.TeamProject;
import hufs2021.jeongbo.network.Pagination;
import hufs2021.jeongbo.network.response.TeamProjectResponse;
import hufs2021.jeongbo.repository.TeamProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/team-project")
public class TeamProjectApiController {

    @Autowired
    private TeamProjectRepository teamProjectRepository;

    @GetMapping("/search")
    public List<TeamProjectResponse> teamProjectSearch(@PageableDefault(sort = "projectNumber", direction = Sort.Direction.ASC, size = 5) Pageable pageable) {
        Page<TeamProject> teamProjects = teamProjectRepository.findAll(pageable);

        List<TeamProjectResponse> teamProjectResponseList = teamProjects.stream()
                .map(teamProject -> response(teamProject))
                .collect(Collectors.toList());

        //Todo: pagination도 리턴 필요
        Pagination pagination = Pagination.builder()
                .totalPages(teamProjects.getTotalPages())
                .totalElements(teamProjects.getTotalElements())
                .currentPage(teamProjects.getNumber())
                .currentElements(teamProjects.getNumberOfElements())
                .build();

        return teamProjectResponseList;
    }

    @GetMapping("/detail")
    public TeamProjectResponse teamProjectDetail(@RequestParam Integer id) {
        TeamProject teamProject = teamProjectRepository.findById(id).orElse(null);

        if(teamProject==null)
            return null;

        return response(teamProject);
    }

    private TeamProjectResponse response(TeamProject teamProject) {
        return TeamProjectResponse.builder()
                .pNumber(teamProject.getProjectNumber())
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
