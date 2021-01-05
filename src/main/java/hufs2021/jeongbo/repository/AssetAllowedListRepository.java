package hufs2021.jeongbo.repository;

import hufs2021.jeongbo.model.entity.Asset;
import hufs2021.jeongbo.model.entity.AssetAllowedList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetAllowedListRepository extends JpaRepository<AssetAllowedList, Integer> {
}
