package hufs2021.jeongbo.repository;

import hufs2021.jeongbo.JeongboApplicationTests;
import hufs2021.jeongbo.model.entity.AssetInventory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AssetInventoryRepositoryTest extends JeongboApplicationTests {
    @Autowired
    private AssetInventoryRepository assetInventoryRepository;

    @Test
    public void create(){
        AssetInventory assetInventory = new AssetInventory();
        assetInventory.setAiNumber(11);
        assetInventory.setAiSerial(202101061);
        assetInventory.setAiExpiration(LocalDate.of(2021,1,30));
        assetInventory.setAiStatus(1);
        assetInventory.setAiRoom(206);
        assetInventory.setCaNumber(1);
        assetInventory.setCreatedAt(LocalDateTime.now());
        assetInventory.setCreatedBy(1234);

        AssetInventory newAssetInventory = assetInventoryRepository.save(assetInventory);
    }
    @Test
    public void read(){
        List<AssetInventory> AssetInventory = assetInventoryRepository.findAll();
        System.out.println("AssetInventory : " + AssetInventory);
    }

}