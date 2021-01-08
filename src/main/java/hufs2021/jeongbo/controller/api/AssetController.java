package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.Asset;
import hufs2021.jeongbo.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asset") // localhost:8080/api/asset
public class AssetController {
    @Autowired
    AssetRepository assetRepository;

    @GetMapping("/all")
    @ResponseBody
    public List<Asset> read(){
        return assetRepository.findAll();
    }

    @GetMapping("")
    public Optional<Asset> readId(@RequestParam(name = "id") Integer id){
        return assetRepository.findById(id);
    }

    @PostMapping("")
    @ResponseBody
    public void create(@RequestBody Asset a){

        Asset asset = Asset.builder()
                .aId(a.getAId())
                .aMajor(a.getAMajor())
                .aGrade(a.getAGrade())
                .aDeadline(a.getADeadline())
                .caNumber(a.getCaNumber())
                .createdAt(LocalDateTime.now())
                .createdBy(a.getCreatedBy())
                .updatedAt(a.getUpdatedAt())
                .updatedBy(a.getUpdatedBy())
                .build();
        //System.out.println(ai.getAiNumber());
        Asset newAssetInventory = assetRepository.save(asset);
        return ;
    }

    @PutMapping("")
    public void update(@RequestBody Asset a){
        //Optional<Asset> assetInventoryById = assetRepository.findById(id); // 한 raw 데이터 받기

        Asset asset = Asset.builder()
                .aId(a.getAId())
                .aMajor(a.getAMajor())
                .aGrade(a.getAGrade())
                .aDeadline(a.getADeadline())
                .caNumber(a.getCaNumber())
                .createdAt(assetRepository.findById(a.getAId()).get().getCreatedAt())
                .createdBy(assetRepository.findById(a.getAId()).get().getCreatedBy())
                .updatedAt(LocalDateTime.now())
                .updatedBy(a.getUpdatedBy())
                .build();
        //System.out.println(ai.getAiNumber());
        Asset newAssetInventory = assetRepository.save(asset);
        return ;
    }

    @GetMapping("/{id}")
    public void delete(@PathVariable(name = "id") Integer id){
        System.out.println("Delete id : "+id);
        assetRepository.deleteById(id);
    }
}
