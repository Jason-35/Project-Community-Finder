package pcf.jjs.project_community_finder_server.Account;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/account")
public class AccountController {
    public final AccountService accountService;
    AccountController(AccountService accountService){
        this.accountService = accountService;
    }
    @PostMapping(path = "createAccount")
    public void createAccount(@RequestBody Account account){
        accountService.createAccount(account);
    }
}
