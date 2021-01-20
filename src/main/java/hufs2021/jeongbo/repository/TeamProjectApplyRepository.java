package hufs2021.jeongbo.repository;

import hufs2021.jeongbo.model.entity.TeamProjectApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamProjectApplyRepository extends JpaRepository<TeamProjectApply, Integer> {
}
