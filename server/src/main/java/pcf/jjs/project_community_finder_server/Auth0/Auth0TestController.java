package pcf.jjs.project_community_finder_server.Auth0;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pcf.jjs.project_community_finder_server.Users.UsersRepository;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/auth0")
public class Auth0TestController {



    @GetMapping(value = "/public")
    public ResponseEntity<ResponseDTO> publicEndpoint() {
        return ResponseEntity.ok(new ResponseDTO("Public Endpoint Working fine !"));
    }

    @DeleteMapping(value = "/private")
    public ResponseEntity<ResponseDTO> privateEndpoint() {

        return ResponseEntity.ok(new ResponseDTO("Private Endpoint Working fine !"));
    }
}