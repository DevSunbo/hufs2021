package hufs2021.jeongbo.repository;

import hufs2021.jeongbo.model.entity.AssetNotice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetNoticeRepository extends JpaRepository<AssetNotice, Integer> {
    public List<AssetNotice> findTop20ByOrderByAnNumberDesc();
}
