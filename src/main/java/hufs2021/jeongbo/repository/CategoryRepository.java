package hufs2021.jeongbo.repository;

import hufs2021.jeongbo.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
