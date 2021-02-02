package hufs2021.jeongbo.controller.apiXXXXXXX;

import hufs2021.jeongbo.model.entity.Category;
import hufs2021.jeongbo.model.network.Header;
import hufs2021.jeongbo.model.network.request.CategoryApiRequest;
import hufs2021.jeongbo.model.network.response.CategoryApiResponse;
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
    public List<Category> read() {
        return categoryRepository.findAll();
    }

    @GetMapping("")
    public Header<CategoryApiResponse> readId(@RequestParam(name = "id") Integer id) {
        return categoryRepository.findById(id)
                .map(item -> response(item))
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @PostMapping("")
    @ResponseBody
    public Header<CategoryApiResponse> create(@RequestBody Header<CategoryApiRequest> request) {
        CategoryApiRequest categoryApiRequest = request.getData();

        Category category = Category.builder()
                .caNumber(categoryApiRequest.getCaNumber())
                .caRental(categoryApiRequest.getCaRental())
                .caKind(categoryApiRequest.getCaKind())
                .caName(categoryApiRequest.getCaName())
                .createdAt(LocalDateTime.now())
                .createdBy(categoryApiRequest.getCreatedBy())
                .updatedAt(categoryApiRequest.getUpdatedAt())
                .updatedBy(categoryApiRequest.getUpdatedBy())
                .build();
        //System.out.println( categoryApiRequest.getAiNumber());
        Category newAsset = categoryRepository.save(category);


        //System.out.println( categoryApiRequest.getAiNumber());
        return Header.OK(response(newAsset));
    }

    @PutMapping("")
    public Header<CategoryApiResponse> update(@RequestBody Header<CategoryApiRequest> request) {
        //Optional<Category> assetInventoryById = categoryRepository.findById(id); // 한 raw 데이터 받기
        CategoryApiRequest categoryApiRequest = request.getData();


        Optional<Category> optional = categoryRepository.findById(categoryApiRequest.getCaNumber());


        return optional.map(list -> {
            list
                    .setCaNumber(categoryApiRequest.getCaNumber())
                    .setCaRental(categoryApiRequest.getCaRental())
                    .setCaKind(categoryApiRequest.getCaKind())
                    .setCaName(categoryApiRequest.getCaName())
                    .setCreatedAt(categoryRepository.findById(categoryApiRequest.getCaNumber()).get().getCreatedAt())
                    .setCreatedBy(categoryRepository.findById(categoryApiRequest.getCaNumber()).get().getCreatedBy())
                    .setUpdatedAt(LocalDateTime.now())
                    .setUpdatedBy(categoryApiRequest.getUpdatedBy());
            return list;
        })
                .map(list -> categoryRepository.save(list))
                .map(list -> response(list))
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @DeleteMapping("/{id}")
    public Header delete(@PathVariable(name = "id") Integer id) {
        System.out.println("Delete id : " + id);
        Optional<Category> optional = categoryRepository.findById(id);

        return optional.map(item -> {
            categoryRepository.delete(item);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    public CategoryApiResponse response(Category category) {

        CategoryApiResponse assetAllowedListApiResponse = CategoryApiResponse.builder()
                .caNumber(category.getCaNumber())
                .caRental(category.getCaRental())
                .caKind(category.getCaKind())
                .caName(category.getCaName())
                .createdAt(category.getCreatedAt())
                .createdBy(category.getCreatedBy())
                .updatedAt(category.getUpdatedAt())
                .updatedBy(category.getUpdatedBy())
                .build();
        return assetAllowedListApiResponse;
    }
}