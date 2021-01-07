package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.File;
import hufs2021.jeongbo.network.Header;
import hufs2021.jeongbo.network.response.FileResponse;
import hufs2021.jeongbo.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
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
        else
            return Header.ERROR();
    }

    private FileResponse response(File file) {
        return FileResponse.builder()
                .fNumber(file.getFNumber())
                .fName(file.getFName())
                .createdAt(file.getCreatedAt())
                .createdBy(file.getCreatedBy())
                .build();
    }
}
