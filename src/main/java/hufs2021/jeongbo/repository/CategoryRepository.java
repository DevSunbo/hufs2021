package hufs2021.jeongbo.repository;

import hufs2021.jeongbo.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public List<Category> findByCaRentals(String caRental);
    public List<Category> findByCaKinds(String caRental, String caKind);
    public List<Category> findByCaNames(String caRental, String caKind, String caName);

    public Integer findByCaRental(String caRental);
    public Integer findByCaKind(String caRental, String caKind);
    public Integer findByCaName(String caRental, String caKind, String caName);


}
