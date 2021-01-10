package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.AssetHistory;
import hufs2021.jeongbo.repository.AssetHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asset/history") // localhost:8080/api/asset/history
public class AssetHistoryController {
    @Autowired
    AssetHistoryRepository assetHistoryRepository;

    @GetMapping("/all")
    @ResponseBody
    public List<AssetHistory> read(){
        return assetHistoryRepository.findAll();
    }

    @GetMapping("")
    public Optional<AssetHistory> readId(@RequestParam(name = "id") Integer id){
        return assetHistoryRepository.findById(id);
    }

    @PostMapping("")
    @ResponseBody
    public void create(@RequestBody AssetHistory ah){

        AssetHistory assetHistory = AssetHistory.builder()
                .ahNumber(ah.getAhNumber())
                .ahAiNumber(ah.getAhAiNumber())
                .ahApplicationdate(ah.getAhApplicationdate())
                .ahReturndate(ah.getAhReturndate())
                .studentId(ah.getStudentId())
                .createdAt(LocalDateTime.now())
                .createdBy(ah.getCreatedBy())
                .updatedAt(ah.getUpdatedAt())
                .updatedBy(ah.getUpdatedBy())
                .build();
        //System.out.println(ai.getAiNumber());
        AssetHistory newAssetHistory = assetHistoryRepository.save(assetHistory);
        return ;
    }

    @PutMapping("")
    public void update(@RequestBody AssetHistory ah){
        //Optional<AssetHistory> assetInventoryById = assetHistoryRepository.findById(id); // 한 raw 데이터 받기

        AssetHistory assetHistory = AssetHistory.builder()
                .ahNumber(ah.getAhNumber())
                .ahAiNumber(ah.getAhAiNumber())
                .ahApplicationdate(ah.getAhApplicationdate())
                .ahReturndate(ah.getAhReturndate())
                .studentId(ah.getStudentId())
                .createdAt(assetHistoryRepository.findById(ah.getAhNumber()).get().getCreatedAt())
                .createdBy(assetHistoryRepository.findById(ah.getAhNumber()).get().getCreatedBy())
                .updatedAt(LocalDateTime.now())
                .updatedBy(ah.getUpdatedBy())
                .build();
        //System.out.println(ai.getAiNumber());
        AssetHistory newAssetHistory = assetHistoryRepository.save(assetHistory);
        return ;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Integer id){
        System.out.println("Delete id : "+id);
        assetHistoryRepository.deleteById(id);
    }
}