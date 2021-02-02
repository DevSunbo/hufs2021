package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.Asset;
import hufs2021.jeongbo.model.entity.Qna;
import hufs2021.jeongbo.model.network.Header;
import hufs2021.jeongbo.repository.AssetRepository;
import hufs2021.jeongbo.repository.QnaRepository;
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
    AssetRepository assetRepository;

    List<Qna> qnaList;
    List<Asset> assetList;

    @GetMapping("")
    public void home(){
        //qnaList = readQnA();
        assetList = readAsset();

        List<Asset> assets = new ArrayList<>();
        assetList.stream().forEach(asset -> {
            Asset newAsset = new Asset();
            newAsset.setAssetId(asset.getAssetId());
            newAsset.setAGrade(asset.getAGrade());
            assets.add(newAsset);
            //asset.getAssetId();
        });

        assets.stream().forEach(System.out::println);
    }

    private List<Qna> readQnA(){

        qnaList = qnaRepository.findTop20ByOrderByQaNumberDesc();
        System.out.println(qnaList);
        qnaList.stream().forEach(System.out::println);
        return qnaList;
    }

    private List<Asset> readAsset(){
        assetList = assetRepository.findTop20ByOrderByAssetIdDesc();
        return assetList;
    }

}
