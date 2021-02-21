package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.Asset;
import hufs2021.jeongbo.model.entity.AssetNotice;
import hufs2021.jeongbo.model.entity.Qna;
import hufs2021.jeongbo.model.entity.TeamProject;
import hufs2021.jeongbo.model.network.Header;
import hufs2021.jeongbo.repository.AssetNoticeRepository;
import hufs2021.jeongbo.repository.QnaRepository;
import hufs2021.jeongbo.repository.TeamProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/homepage")
public class HomeController {
    //TODO: 로고 버튼, 로그인, 회원가입 버튼, 메뉴바 버튼, +more 버튼 - 페이지 이동
    //TODO: Q&A , 기자재 조회, 팀 프로젝트 read

    @Autowired
    QnaRepository qnaRepository;

    @Autowired
    AssetNoticeRepository assetNoticeRepository;

    @Autowired
    TeamProjectRepository teamProjectRepository;

    List<Qna> qnaList;
    List<AssetNotice> assetNoticeList;
    List<TeamProject> teamProjectList;

    @GetMapping("")
    public void home(){

        //List<Qna> qnas = readQnA();
//        List<AssetNotice> assets = readAssetnotice();
//        List<TeamProject> teamProjects = readTeamProject();
//        assets.stream().forEach(System.out::println);

//        return "teamproject";
    }

    private List<Qna> readQnA(){

        qnaList = qnaRepository.findTop20ByOrderByQaNumberDesc();
        List<Qna> qnas = new ArrayList<>();
        qnaList.stream().forEach(q ->{
            Qna newQna = new Qna();
            newQna.setQaContent(q.getQaContent());
            newQna.setCreatedAt(q.getCreatedAt());
            qnas.add(newQna);
        });

        return qnaList;
    }

    private List<AssetNotice> readAssetnotice(){
        assetNoticeList = assetNoticeRepository.findTop20ByOrderByAnNumberDesc();
        List<AssetNotice> assets = new ArrayList<>();
        assetNoticeList.stream().forEach(a -> {
            AssetNotice newAssetNotice = new AssetNotice();
            newAssetNotice.setAnContent(a.getAnContent());
            newAssetNotice.setCreatedAt(a.getCreatedAt());
            assets.add(newAssetNotice);
            //asset.getAssetId();
        });
        return assets;
    }

    private List<TeamProject> readTeamProject(){
        teamProjectList = teamProjectRepository.findTop20ByOrderByProjectNumberDesc();
        List<TeamProject> teamProjects = new ArrayList<>();
        teamProjectList.stream().forEach(a -> {
            TeamProject newTeamProject = new TeamProject();
            newTeamProject.setPContent(a.getPContent());
            newTeamProject.setCreatedAt(a.getCreatedAt());
            teamProjects.add(newTeamProject);
            //asset.getAssetId();
        });
        return teamProjectList;
    }

}
