package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.Category;
import hufs2021.jeongbo.model.entity.Category;
import hufs2021.jeongbo.repository.AssetRepository;
import hufs2021.jeongbo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/category") // localhost:8080/api/category
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/all")
    @ResponseBody
    public List<Category> read(){
        return categoryRepository.findAll();
    }

    @GetMapping("")
    public Optional<Category> readId(@RequestParam(name = "id") Integer id){
        return categoryRepository.findById(id);
    }

    @PostMapping("")
    @ResponseBody
    public void create(@RequestBody Category ca){

        Category category = Category.builder()
                .caNumber(ca.getCaNumber())
                .caRental(ca.getCaRental())
                .caKind(ca.getCaKind())
                .caName(ca.getCaName())
                .createdAt(LocalDateTime.now())
                .createdBy(ca.getCreatedBy())
                .updatedAt(ca.getUpdatedAt())
                .updatedBy(ca.getUpdatedBy())
                .build();
        //System.out.println(ai.getAiNumber());
        Category newAssetInventory = categoryRepository.save(category);
        return ;
    }

    @PutMapping("")
    public void update(@RequestBody Category ca){
        //Optional<Category> assetInventoryById = categoryRepository.findById(id); // 한 raw 데이터 받기

        Category category = Category.builder()
                .caNumber(ca.getCaNumber())
                .caRental(ca.getCaRental())
                .caKind(ca.getCaKind())
                .caName(ca.getCaName())
                .createdAt(categoryRepository.findById(ca.getCaNumber()).get().getCreatedAt())
                .createdBy(categoryRepository.findById(ca.getCaNumber()).get().getCreatedBy())
                .updatedAt(LocalDateTime.now())
                .updatedBy(ca.getUpdatedBy())
                .build();
        //System.out.println(ai.getAiNumber());
        Category newAssetInventory = categoryRepository.save(category);
        return ;
    }

    @GetMapping("/{id}")
    public void delete(@PathVariable(name = "id") Integer id){
        System.out.println("Delete id : "+id);
        categoryRepository.deleteById(id);
    }
}
