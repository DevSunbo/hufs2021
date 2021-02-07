package hufs2021.jeongbo.repository;

import hufs2021.jeongbo.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public List<Category> findByCaRental(String caRental);
    public List<Category> findByCaRentalAndCaKind(String caRental, String caKind);
    public List<Category> findByCaRentalAndCaKindAndCaName(String caRental, String caKind, String caName);

   /* public Integer findByCaRental(String caRental);

    public Integer findByCaRentalAndCaKind(String caRental, String caKind);
    public Integer findByCaRentalAndCaKindAndCaName(String caRental, String caKind, String caName);*/



}
