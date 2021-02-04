package hufs2021.jeongbo.repository;

import hufs2021.jeongbo.model.entity.AssetInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssetInventoryRepository extends JpaRepository<AssetInventory, Integer> {
    public  List<AssetInventory> findByCaNumber(Integer caNumber);

    public List<AssetInventory> findByCaNumberAndAiStatus(Integer caNumber, Integer aiStatus);
}
