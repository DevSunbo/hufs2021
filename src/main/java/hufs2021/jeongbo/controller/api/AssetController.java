package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.AssetInventory;
import hufs2021.jeongbo.repository.AssetInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api") // localhost:8080/api
public class AssetController {
    @Autowired
    AssetInventoryRepository assetInventoryRepository;

    @GetMapping("assetInventory")
    @ResponseBody
    public List<AssetInventory> read(){
        return assetInventoryRepository.findAll();
    }
}
