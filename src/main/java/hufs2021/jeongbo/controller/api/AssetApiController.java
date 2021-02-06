package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.exceptions.NotExistDBException;
import hufs2021.jeongbo.model.dto.AssetDto;
import hufs2021.jeongbo.model.entity.Asset;
import hufs2021.jeongbo.model.entity.AssetInventory;
import hufs2021.jeongbo.model.entity.Category;
import hufs2021.jeongbo.repository.AssetInventoryRepository;
import hufs2021.jeongbo.repository.AssetRepository;
import hufs2021.jeongbo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/api/asset")
public class AssetApiController {
    private final EntityManager entityManager;

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    AssetInventoryRepository assetInventoryRepository;

    @Autowired
    CategoryRepository categoryRepository;



    List<Asset> assetList;
    List<AssetInventory> assetInventorieList;
    List<AssetInventory> assetInventoryCount;
    List<Category> categoryList;
    List<AssetDto> assetDtoList;

    public AssetApiController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @GetMapping("/read")
    public void read(
            @RequestParam(name = "caRental") String caRental,
            @RequestParam(name = "caKind") String caKind,
            @RequestParam(name = "caName") String caName){
            //@RequestParam(name = "assetDeadline") LocalDate assetDeadline) {
        //assetList = assetRepository.findAll();
        //assetInventorieList = assetInventoryRepository.findAll();

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% " + caRental);
        Integer caNum = 0;
        List<Integer> caNumbers = new ArrayList<>();
        try {
            if (caRental == null || caRental.trim().isEmpty()) {
                throw new NotExistDBException("caRental");
            } else {
                if (caKind == null || caKind.trim().isEmpty()) {
                    categoryList = categoryRepository.findByCaRental(caRental);
                    //caNum = categoryRepository.findByCaRental(caRental);
                    if(caNum == null)
                        throw new NullPointerException();
                } else {
                    if (caName == null || caName.trim().isEmpty()) {
                        categoryList = categoryRepository.findByCaRentalAndCaKind(caRental, caKind);
                        //caNum = categoryRepository.findByCaRentalAndCaKind(caRental, caKind);
                        if(caNum == null)
                            throw new NullPointerException();
                    } else {
                        categoryList = categoryRepository.findByCaRentalAndCaKindAndCaName(caRental, caKind, caName);
                        //caNum = categoryRepository.findByCaRentalAndCaKindAndCaName(caRental, caKind, caName);
                        if(caNum == null)
                            throw new NullPointerException();
                    }
                }
            }
        } catch (NullPointerException e) {
        }
        catch (NotExistDBException e){}
        categoryList.stream().forEach(ca -> {  // TODO: 2021.02.03 caNumber가 1개만 나오는데 List에서 Stream 말고 값을 빼오는것을 모르겠음 -sunbo
            caNumbers.add(ca.getCaNumber());
        });
        caNum = caNumbers.get(0);
        System.out.println("caNum     " + caNum);

        assetList = assetRepository.findByCaNumber(caNum);
        assetInventoryCount = assetInventoryRepository.findByCaNumberAndAiStatus(caNum, 1);
        assetInventorieList = assetInventoryRepository.findByCaNumber(caNum);
        System.out.println("ailist " + assetInventorieList);
        assetDtoList = new ArrayList<>();
        assetInventorieList.stream().forEach(ai ->{
            AssetDto newAssetDto = new AssetDto();
            System.out.println();
            System.out.println("ai&&&&&&&&&&&&&  " + ai);
            newAssetDto.setCaRental(caRental);
            newAssetDto.setCaKind(caKind);
            newAssetDto.setCaName(caName);
            newAssetDto.setRestAsset(assetInventoryCount.size());
            newAssetDto.setAssetDeadline(LocalDate.now());
            System.out.println(assetInventoryCount.size());
            System.out.println("assetDto   :  " + newAssetDto);
            assetDtoList.add(newAssetDto);
        });

        //TODO: 2021.02.06 caNum 분류 3개에 맞춰 추가하기 OR category assetinventory 합쳐서 분류 3개 만으로 find 하기 -sunbo
        assetDtoList.stream().forEach(System.out::println);




    }

}
