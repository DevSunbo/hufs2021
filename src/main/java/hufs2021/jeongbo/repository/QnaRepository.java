package hufs2021.jeongbo.repository;

import hufs2021.jeongbo.model.entity.Qna;
import hufs2021.jeongbo.model.key.QnaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QnaRepository extends JpaRepository<Qna, QnaId> {
    public List<Qna> findTop20ByOrderByQaNumberDesc();
}
