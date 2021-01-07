package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.AssetInventory;
import hufs2021.jeongbo.repository.AssetInventoryRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assetInventory") // localhost:8080/api/assetInventory
public class AssetInventoryController {
    @Autowired
    AssetInventoryRepository assetInventoryRepository;

    @GetMapping("/all")
    @ResponseBody
    public List<AssetInventory> read(){
        return assetInventoryRepository.findAll();
    }

    @GetMapping("/")
    public Optional<AssetInventory> readId(@RequestParam(name = "id") Integer id){
        return assetInventoryRepository.findById(id);
    }

    @PostMapping("/")
    @ResponseBody
    public void create(@RequestBody AssetInventory ai){

        AssetInventory assetInventory = AssetInventory.builder()
                .aiNumber(ai.getAiNumber())
                .aiSerial(ai.getAiSerial())
                .aiExpiration(LocalDate.of(2021, 1, 30))
                .aiStatus(ai.getAiStatus())
                .aiRoom(ai.getAiRoom())
                .aiUser(ai.getAiUser())
                .caNumber(ai.getCaNumber())
                .createdAt(LocalDateTime.now())
                .createdBy(1234)
                .updatedAt(LocalDateTime.now())
                .updatedBy(1234)
                .build();
        //System.out.println(ai.getAiNumber());
        AssetInventory newAssetInventory = assetInventoryRepository.save(assetInventory);
        return ;
    }

    @GetMapping("/update")
    public void update(@RequestParam(name = "id") Integer id, @RequestParam(name = "user") Integer user){
        Optional<AssetInventory> assetInventoryById = assetInventoryRepository.findById(id); // 한 raw 데이터 받기

        AssetInventory assetInventory = AssetInventory.builder()
                .aiNumber(assetInventoryById.get().getAiNumber())
                .aiSerial(assetInventoryById.get().getAiSerial())
                .aiExpiration(LocalDate.of(2021, 1, 30))
                .aiStatus(assetInventoryById.get().getAiStatus())
                .aiRoom(assetInventoryById.get().getAiRoom())
                .aiUser(user)
                .caNumber(assetInventoryById.get().getCaNumber())
                .createdAt(LocalDateTime.now())
                .createdBy(1234)
                .updatedAt(LocalDateTime.now())
                .updatedBy(1234)
                .build();

        System.out.println(assetInventory.getAiUser());
        AssetInventory newAssetInventory = assetInventoryRepository.save(assetInventory);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") Integer id){
        System.out.println("Delete id : "+id);
        assetInventoryRepository.deleteById(id);
    }
}
