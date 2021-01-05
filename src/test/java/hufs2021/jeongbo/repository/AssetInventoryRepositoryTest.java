package hufs2021.jeongbo.repository;

import hufs2021.jeongbo.JeongboApplicationTests;
import hufs2021.jeongbo.model.entity.AssetInventory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
class AssetInventoryRepositoryTest extends JeongboApplicationTests {
    @Autowired
    private AssetInventoryRepository assetInventoryRepository;

    @Test
    public void read(){
        List<AssetInventory> AssetInventory = assetInventoryRepository.findAll();
        System.out.println("AssetInventory : " + AssetInventory);
    }

}