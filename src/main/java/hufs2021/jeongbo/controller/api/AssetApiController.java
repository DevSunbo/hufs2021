package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.dto.AssetDto;
import hufs2021.jeongbo.model.entity.Asset;
import hufs2021.jeongbo.model.entity.AssetInventory;
import hufs2021.jeongbo.model.entity.Category;
import hufs2021.jeongbo.repository.AssetInventoryRepository;
import hufs2021.jeongbo.repository.AssetRepository;
import hufs2021.jeongbo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/asset")
public class AssetApiController {
    @Autowired
    AssetRepository assetRepository;

    @Autowired
    AssetInventoryRepository assetInventoryRepository;

    @Autowired
    CategoryRepository categoryRepository;

    AssetDto assetDto;

    List<Asset> assetList;
    List<AssetInventory> assetInventorieList;
    List<Category> categoryList;

    public void read(@RequestParam(name = "caRental" String caRental )){
        //assetList = assetRepository.findAll();
        //assetInventorieList = assetInventoryRepository.findAll();
        List<Integer> caNumbers = new ArrayList<>();
        ca
    }

}
