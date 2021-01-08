package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.AssetNotice;
import hufs2021.jeongbo.model.entity.AssetNotice;
import hufs2021.jeongbo.repository.AssetNoticeRepository;
import hufs2021.jeongbo.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/notice") // localhost:8080/api/notice
public class AssetNoticeController {
    
    @Autowired
    AssetNoticeRepository assetNoticeRepository;

    @GetMapping("/all")
    @ResponseBody
    public List<AssetNotice> read(){
        return assetNoticeRepository.findAll();
    }

    @GetMapping("")
    public Optional<AssetNotice> readId(@RequestParam(name = "id") Integer id){
        return assetNoticeRepository.findById(id);
    }

    @PostMapping("")
    @ResponseBody
    public void create(@RequestBody AssetNotice an){

        AssetNotice assetNotice = AssetNotice.builder()
                .anNumber(an.getAnNumber())
                .anContent(an.getAnContent())
                .createdAt(LocalDateTime.now())
                .createdBy(an.getCreatedBy())
                .updatedAt(an.getUpdatedAt())
                .updatedBy(an.getUpdatedBy())
                .build();
        //System.out.println(ai.getAiNumber());
        AssetNotice newAssetNotice = assetNoticeRepository.save(assetNotice);
        return ;
    }

    @PutMapping("")
    public void update(@RequestBody AssetNotice an){
        //Optional<AssetNotice> assetInventoryById = assetNoticeRepository.findById(id); // 한 raw 데이터 받기

        AssetNotice assetNotice = AssetNotice.builder()
                .anNumber(an.getAnNumber())
                .anContent(an.getAnContent())
                .createdAt(assetNoticeRepository.findById(an.getAnNumber()).get().getCreatedAt())
                .createdBy(assetNoticeRepository.findById(an.getAnNumber()).get().getCreatedBy())
                .updatedAt(LocalDateTime.now())
                .updatedBy(an.getUpdatedBy())
                .build();

        //System.out.println(ai.getAiNumber());
        AssetNotice newAssetNotice = assetNoticeRepository.save(assetNotice);
        return ;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Integer id){
        System.out.println("Delete id : "+id);
        assetNoticeRepository.deleteById(id);
    }
}