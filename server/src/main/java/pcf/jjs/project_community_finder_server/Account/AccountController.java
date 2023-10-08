package pcf.jjs.project_community_finder_server.Account;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "api/account")
public class AccountController {
    public final AccountService accountService;
    AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    /**
     * Controller for creating new Accounts
     * @param account An account entity from the Account.java class
     * @return ResponseEntity with Created code with response body
     */
    @PostMapping(path = "createAccount")
    public  ResponseEntity<Map<String,String>> createAccount(@RequestBody @Valid Account account){
        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
    }

    @GetMapping
    public String hello(){
        return "Hello World";
    }
}
