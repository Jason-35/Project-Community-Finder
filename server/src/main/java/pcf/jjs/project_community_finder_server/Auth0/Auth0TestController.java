package pcf.jjs.project_community_finder_server.Auth0;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/auth0")
public class Auth0TestController {

    @GetMapping(value = "/public")
    public ResponseEntity<ResponseDTO> publicEndpoint() {
        return ResponseEntity.ok(new ResponseDTO("Public Endpoint Working fine !"));
    }

    @GetMapping(value = "/private")
    public ResponseEntity<ResponseDTO> privateEndpoint() {
        return ResponseEntity.ok(new ResponseDTO("Private Endpoint Working fine !"));
    }
}