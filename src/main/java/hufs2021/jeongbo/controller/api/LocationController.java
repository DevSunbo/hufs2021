package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.Location;
import hufs2021.jeongbo.model.entity.Location;
import hufs2021.jeongbo.model.entity.Location;
import hufs2021.jeongbo.model.network.Header;
import hufs2021.jeongbo.model.network.request.LocationApiRequest;
import hufs2021.jeongbo.model.network.request.LocationApiRequest;
import hufs2021.jeongbo.model.network.response.LocationApiResponse;
import hufs2021.jeongbo.model.network.response.LocationApiResponse;
import hufs2021.jeongbo.repository.AssetRepository;
import hufs2021.jeongbo.repository.LocationRepository;
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
    LocationRepository  locationRepository;

    @GetMapping("/all")
    @ResponseBody
    public List<Location> read() {
        return  locationRepository.findAll();
    }

    @GetMapping("")
    public Header<LocationApiResponse> readId(@RequestParam(name = "id") Integer id) {
        return  locationRepository.findById(id)
                .map(item -> response(item))
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @PostMapping("")
    @ResponseBody
    public Header<LocationApiResponse> create(@RequestBody Header<LocationApiRequest> request) {
        LocationApiRequest locationApiRequest = request.getData();

        Location location = Location.builder()
                .roomLocation(locationApiRequest.getRoomLocation())
                .roomPupose(locationApiRequest.getRoomPupose())
                .manager(locationApiRequest.getManager())
                .managerPhoneNumber(locationApiRequest.getManagerPhoneNumber())
                .managerOfficePn(locationApiRequest.getManagerOfficePn())
                .createdAt(LocalDateTime.now())
                .createdBy(locationApiRequest.getCreatedBy())
                .updatedAt(locationApiRequest.getUpdatedAt())
                .updatedBy(locationApiRequest.getUpdatedBy())
                .build();
        //System.out.println( locationApiRequest.getAiNumber());
        Location newAsset =  locationRepository.save(location);


        //System.out.println( locationApiRequest.getAiNumber());
        return Header.OK(response(newAsset));
    }

    @PutMapping("")
    public Header<LocationApiResponse> update(@RequestBody Header<LocationApiRequest> request) {
        //Optional<Location> assetInventoryById =  locationRepository.findById(id); // 한 raw 데이터 받기
        LocationApiRequest locationApiRequest = request.getData();


        Optional<Location> optional =  locationRepository.findById(locationApiRequest.getRoomLocation());


        return optional.map(list -> {
            list
                    .setRoomLocation(locationApiRequest.getRoomLocation())
                    .setRoomPupose(locationApiRequest.getRoomPupose())
                    .setManager(locationApiRequest.getManager())
                    .setManagerPhoneNumber(locationApiRequest.getManagerPhoneNumber())
                    .setManagerPhoneNumber(locationApiRequest.getManagerOfficePn())
                    .setCreatedAt( locationRepository.findById(locationApiRequest.getRoomLocation()).get().getCreatedAt())
                    .setCreatedBy( locationRepository.findById(locationApiRequest.getRoomLocation()).get().getCreatedBy())
                    .setUpdatedAt(LocalDateTime.now())
                    .setUpdatedBy(locationApiRequest.getUpdatedBy());
            return list;
        })
                .map(list ->  locationRepository.save(list))
                .map(list -> response(list))
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @DeleteMapping("/{id}")
    public Header delete(@PathVariable(name = "id") Integer id) {
        System.out.println("Delete id : " + id);
        Optional<Location> optional =  locationRepository.findById(id);

        return optional.map(item -> {
             locationRepository.delete(item);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    public LocationApiResponse response(Location location) {

        LocationApiResponse assetAllowedListApiResponse = LocationApiResponse.builder()
                .roomLocation(location.getRoomLocation())
                .roomPupose(location.getRoomPupose())
                .manager(location.getManager())
                .managerPhoneNumber(location.getManagerPhoneNumber())
                .managerOfficePn(location.getManagerOfficePn())
                .createdAt(location.getCreatedAt())
                .createdBy(location.getCreatedBy())
                .updatedAt(location.getUpdatedAt())
                .updatedBy(location.getUpdatedBy())
                .build();
        return assetAllowedListApiResponse;
    }
}