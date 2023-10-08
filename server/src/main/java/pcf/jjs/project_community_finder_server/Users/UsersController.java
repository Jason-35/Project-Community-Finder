package pcf.jjs.project_community_finder_server.Users;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "api/account")
public class UsersController {
    public final UsersService usersService;
    UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    /**
     * Controller for creating new Users
     * @param users An users entity from the Account.java class
     * @return ResponseEntity with Created code with response body
     */
    @PostMapping(path = "createAccount")
    public  ResponseEntity<Map<String,String>> createAccount(@RequestBody @Valid Users account){
        return new ResponseEntity<>(usersService.createAccount(account), HttpStatus.CREATED);
    }

    @GetMapping
    public String hello(){
        return "Hello World";
    }
}
