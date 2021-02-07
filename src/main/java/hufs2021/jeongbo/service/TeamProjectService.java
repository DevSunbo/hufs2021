package hufs2021.jeongbo.service;

import hufs2021.jeongbo.model.entity.TeamProject;
import hufs2021.jeongbo.network.Header;
import hufs2021.jeongbo.network.request.TeamProjectRequest;
import hufs2021.jeongbo.network.response.TeamProjectResponse;
import hufs2021.jeongbo.repository.TeamProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TeamProjectService {

    @Autowired
    private TeamProjectRepository teamProjectRepository;

    public Header<TeamProjectResponse> create(TeamProjectRequest teamProjectRequest) {
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

    public Header<TeamProjectResponse> readAll() {
        List<TeamProject> teamProjectList = teamProjectRepository.findAll();

        if (teamProjectList != null) {
            teamProjectList.stream().forEach(teamProject -> {
                System.out.println(teamProject.getProjectNumber());
                System.out.println(teamProject.getPName());
                System.out.println(teamProject.getPMin());
                System.out.println(teamProject.getPMax());
                System.out.println(teamProject.getPDeadline());
                System.out.println(teamProject.getPMainLanguage());
                System.out.println(teamProject.getPLocation());
                System.out.println(teamProject.getPContent());
                System.out.println(teamProject.getFId());
                System.out.println(teamProject.getCreatedAt());
                System.out.println(teamProject.getCreatedBy());
                System.out.println(teamProject.getUpdatedAt());
                System.out.println(teamProject.getUpdatedBy());
                System.out.println(teamProject.getStudentId());
                System.out.println("----------------------------------");
            });
            return Header.OK();
        }
        else
            return Header.ERROR();
    }

    public Header<TeamProjectResponse> read(Integer number) {
        return teamProjectRepository.findById(number)
                .map(teamProject -> {
                    System.out.println(teamProject.getProjectNumber());
                    System.out.println(teamProject.getPName());
                    System.out.println(teamProject.getPMin());
                    System.out.println(teamProject.getPMax());
                    System.out.println(teamProject.getPDeadline());
                    System.out.println(teamProject.getPMainLanguage());
                    System.out.println(teamProject.getPLocation());
                    System.out.println(teamProject.getPContent());
                    System.out.println(teamProject.getFId());
                    System.out.println(teamProject.getCreatedAt());
                    System.out.println(teamProject.getCreatedBy());
                    System.out.println(teamProject.getUpdatedAt());
                    System.out.println(teamProject.getUpdatedBy());
                    System.out.println(teamProject.getStudentId());
                    return teamProject;
                }).map(teamProject -> Header.OK(response(teamProject)))
                .orElseGet(Header::ERROR);
    }

    public Header<TeamProjectResponse> update(TeamProjectRequest teamProjectRequest) {
        return teamProjectRepository.findById(teamProjectRequest.getPNumber())
                .map(teamProject -> {
                    teamProject.setPName(teamProjectRequest.getPName());
                    teamProject.setPMin(teamProjectRequest.getPMin());
                    teamProject.setPMax(teamProjectRequest.getPMax());
                    teamProject.setPDeadline(teamProjectRequest.getPDeadline());
                    teamProject.setPMainLanguage(teamProjectRequest.getPMainLanguage());
                    teamProject.setPLocation(teamProjectRequest.getPLocation());
                    teamProject.setPContent(teamProjectRequest.getPContent());
                    teamProject.setFId(teamProjectRequest.getFId());
                    teamProject.setUpdatedAt(LocalDateTime.now());
                    teamProject.setUpdatedBy(teamProjectRequest.getUpdatedBy());
                    return teamProject;
                }).map(teamProject -> teamProjectRepository.save(teamProject))
                .map(teamProject -> Header.OK(response(teamProject)))
                .orElseGet(Header::ERROR);
    }

    public Header<TeamProjectResponse> delete(Integer number) {
        Optional<TeamProject> teamProjectOptional = teamProjectRepository.findById(number);

        teamProjectOptional.ifPresent(teamProject -> teamProjectRepository.delete(teamProject));

        Optional<TeamProject> deletedTeamProject = teamProjectRepository.findById(number);

        return Header.OK();
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
