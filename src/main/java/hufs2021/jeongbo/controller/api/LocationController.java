package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.Location;
import hufs2021.jeongbo.model.entity.Location;
import hufs2021.jeongbo.repository.AssetRepository;
import hufs2021.jeongbo.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/location") // localhost:8080/api/location
public class LocationController {
    @Autowired
    LocationRepository locationRepository;

    @GetMapping("/all")
    @ResponseBody
    public List<Location> read(){
        return locationRepository.findAll();
    }

    @GetMapping("")
    public Optional<Location> readId(@RequestParam(name = "id") Integer id){
        return locationRepository.findById(id);
    }

    @PostMapping("")
    @ResponseBody
    public void create(@RequestBody Location lo){

        Location location = Location.builder()
                .roomLocation(lo.getRoomLocation())
                .roomPupose(lo.getRoomPupose())
                .manager(lo.getManager())
                .managerPhoneNumber(lo.getManagerPhoneNumber())
                .managerOfficePn(lo.getManagerOfficePn())
                .createdAt(LocalDateTime.now())
                .createdBy(lo.getCreatedBy())
                .updatedAt(lo.getUpdatedAt())
                .updatedBy(lo.getUpdatedBy())
                .build();
        //System.out.println(ai.getAiNumber());
        Location newAssetInventory = locationRepository.save(location);
        return ;
    }

    @PutMapping("")
    public void update(@RequestBody Location lo){
        //Optional<Location> assetInventoryById = locationRepository.findById(id); // 한 raw 데이터 받기

        Location location = Location.builder()
                .roomLocation(lo.getRoomLocation())
                .roomPupose(lo.getRoomPupose())
                .manager(lo.getManager())
                .managerPhoneNumber(lo.getManagerPhoneNumber())
                .managerOfficePn(lo.getManagerOfficePn())
                .createdAt(locationRepository.findById(lo.getRoomLocation()).get().getCreatedAt())
                .createdBy(locationRepository.findById(lo.getRoomLocation()).get().getCreatedBy())
                .updatedAt(LocalDateTime.now())
                .updatedBy(lo.getUpdatedBy())
                .build();
        //System.out.println(ai.getAiNumber());
        Location newAssetInventory = locationRepository.save(location);
        return ;
    }

    @GetMapping("/{id}")
    public void delete(@PathVariable(name = "id") Integer id){
        System.out.println("Delete id : "+id);
        locationRepository.deleteById(id);
    }
}