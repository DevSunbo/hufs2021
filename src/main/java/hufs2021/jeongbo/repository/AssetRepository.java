package hufs2021.jeongbo.repository;

import hufs2021.jeongbo.model.entity.Asset;
import hufs2021.jeongbo.model.entity.AssetInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {
    public List<Asset> findTop20ByOrderByAssetIdDesc();

    public List<Asset> findByCaNumber(Integer caNumber);
}
