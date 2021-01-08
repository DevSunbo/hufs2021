package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.AssetAllowedList;
import hufs2021.jeongbo.model.entity.AssetAllowedList;
import hufs2021.jeongbo.model.entity.AssetAllowedListPK;
import hufs2021.jeongbo.repository.AssetAllowedListRepository;
import hufs2021.jeongbo.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/assetAllowedList") // localhost:8080/api/asset
public class AssetAllowedListController {
    @Autowired
    AssetAllowedListRepository assetAllowedListRepository;

    @GetMapping("/all")
    @ResponseBody
    public List<AssetAllowedList> read(){
        return assetAllowedListRepository.findAll();
    }

    @GetMapping("")
    public Optional<AssetAllowedList> readId(@RequestParam(name = "id") Integer id, @RequestParam(name = "number") Integer number){
        AssetAllowedListPK assetAllowedListPK = new AssetAllowedListPK(id, number);
        return assetAllowedListRepository.findById(assetAllowedListPK);
    }

    @PostMapping("")
    @ResponseBody
    public void create(@RequestBody AssetAllowedList aal){

        AssetAllowedList assetAllowedList = AssetAllowedList.builder()
                .studentId(aal.getStudentId())
                .caNumber(aal.getCaNumber())
                .createdAt(LocalDateTime.now())
                .createdBy(aal.getCreatedBy())
                .updatedAt(aal.getUpdatedAt())
                .updatedBy(aal.getUpdatedBy())
                .build();

        //System.out.println(ai.getAiNumber());
        AssetAllowedList newAssetInventory = assetAllowedListRepository.save(assetAllowedList);
        return ;
    }

    @PutMapping("")
    public void update(@RequestBody AssetAllowedList aal){
        //Optional<AssetAllowedList> assetInventoryById = assetAllowedListRepository.findById(id); // 한 raw 데이터 받기
        AssetAllowedListPK assetAllowedListPK = new AssetAllowedListPK(aal.getStudentId(),aal.getCaNumber());
        AssetAllowedList assetAllowedList = AssetAllowedList.builder()
                .studentId(aal.getStudentId())
                .caNumber(aal.getCaNumber())
                .createdAt(assetAllowedListRepository.findById(assetAllowedListPK).get().getCreatedAt())
                .createdBy(assetAllowedListRepository.findById(assetAllowedListPK).get().getCreatedBy())
                .updatedAt(LocalDateTime.now())
                .updatedBy(aal.getUpdatedBy())
                .build();
        //System.out.println(ai.getAiNumber());
        AssetAllowedList newAssetInventory = assetAllowedListRepository.save(assetAllowedList);
        return ;
    }

    @GetMapping("")
    public void delete(@RequestParam(name = "id") Integer id, @RequestParam(name = "number") Integer number){
        AssetAllowedListPK assetAllowedListPK = new AssetAllowedListPK(id, number);
        System.out.println("Delete id : "+id);
        assetAllowedListRepository.deleteById(assetAllowedListPK);
    }
}
