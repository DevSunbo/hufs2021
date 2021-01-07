package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.File;
import hufs2021.jeongbo.network.Header;
import hufs2021.jeongbo.network.response.FileResponse;
import hufs2021.jeongbo.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/file", produces = "application/json")
public class FileController {

    @Autowired
    private FileRepository fileRepository;

    @GetMapping("/create")
    @ResponseBody
    public Header<FileResponse> create() {
        File file = File.builder()
                .fNumber(3)
                .fName("김정호의 회사 지원서")
                .createdAt(LocalDateTime.now())
                .createdBy(1234)
                .build();

//        System.out.println(file.getFNumber() + " " + file.getFName());

//        File file = File.builder()
//                .fNumber(fileRequest.getFNumber())
//                .fName(fileRequest.getFName())
//                .createdAt(LocalDateTime.now())
//                .createdBy(1234)
//                .build();

//        System.out.println(file.getFName() + " " + file.getFName() + " ");

        File newFile = fileRepository.save(file);
//
        if(newFile!=null)
            return Header.OK(response(newFile));
        else
            return Header.ERROR();
    }

    @GetMapping("/readall")
    @ResponseBody
    public Header<FileResponse> readAll() {
        List<File> fileList = fileRepository.findAll();

        if(fileList!=null){
            fileList.stream().forEach(file -> {
                System.out.println("파일 아이디: " + file.getFId());
                System.out.println("파일 번호: " + file.getFNumber());
                System.out.println("파일 명: " + file.getFName());
                System.out.println("등록일: " + file.getCreatedAt());
                System.out.println("등록자: " + file.getCreatedBy());
                System.out.println("---------------");
            });
            return Header.OK();
        }
        return Header.ERROR();
    }

    @GetMapping("/read/{f_id}")
    public Header<FileResponse> read(@PathVariable(name = "f_id") Integer id) {
        return fileRepository.findById(id).map(file -> {
            System.out.println("파일 아디: " + file.getFId());
            System.out.println("파일 번호: " + file.getFNumber());
            System.out.println("파일 명: " + file.getFName());
            System.out.println("등록일: " + file.getCreatedAt());
            System.out.println("등록자: " + file.getCreatedBy());
            System.out.println("---------------");
            return Header.OK(response(file));
        }).orElseGet(Header::ERROR);
    }

    @GetMapping

    private FileResponse response(File file) {
        return FileResponse.builder()
                .fId(file.getFId())
                .fNumber(file.getFNumber())
                .fName(file.getFName())
                .createdAt(file.getCreatedAt())
                .createdBy(file.getCreatedBy())
                .updatedAt(file.getUpdatedAt())
                .updatedBy(file.getUpdatedBy())
                .build();
    }

    private FileResponse response(List<File> fileList) { //안됨
        List<FileResponse> fileResponseList = new ArrayList<>();

        fileList.stream().forEach(file -> {
            FileResponse fileResponse = FileResponse.builder()
                    .fId(file.getFId())
                    .fNumber(file.getFNumber())
                    .fName(file.getFName())
                    .createdAt(file.getCreatedAt())
                    .createdBy(file.getCreatedBy())
                    .updatedAt(file.getUpdatedAt())
                    .updatedBy(file.getUpdatedBy())
                    .build();

            fileResponseList.add(fileResponse);
        });

        return (FileResponse) fileResponseList;
    }


}
