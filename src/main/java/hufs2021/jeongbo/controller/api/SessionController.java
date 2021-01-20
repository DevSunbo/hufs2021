package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.network.Header;
import hufs2021.jeongbo.network.request.UserRequest;
import hufs2021.jeongbo.network.response.UserResponse;
import hufs2021.jeongbo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class SessionController {

    /*@Autowired
    private UserService userService;*/

    @Autowired
    private SessionService sessionService;

    /*@PostMapping("/session")
    public ResponseEntity<SessionResponseDto> create(
            @RequestBody SessionRequestDto resource
            ) throws URISyntaxException {
        String url = "/session";

        String email = resource.getEmail();
        String password = resource.getPassword();

//        userService.authenticate(email, password);

        String accessToken = "ACCESSTOKEN";
        return ResponseEntity.created(new URI(url))
                .body(SessionResponseDto.builder()
                        .accessToken(accessToken)
                        .build());
    }*/

    @PostMapping("/register")
    @ResponseBody
    public Header<UserResponse> register(@RequestBody UserRequest userRequest) {
        return sessionService.register(userRequest);
    }


    /*@PostMapping("/login")
    public Header<UserResponse> login(@RequestBody UserRequest userRequest) {
        return userService.authenticate(userRequest.getEmail(), userRequest.getPassword());
    }*/
}
