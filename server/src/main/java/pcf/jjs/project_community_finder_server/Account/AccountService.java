package pcf.jjs.project_community_finder_server.Account;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    // Dependency Injection for accountRepository which serves as access to the database
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    // Service for creating new accounts. Need to redo the error for when an account already exist
    public Map<String, String> createAccount(@Valid Account account){

//        Account newAccount = new Account(account.getUsername(), account.getPassword(), account.getEmail());

        Optional<Account> accountOptional = accountRepository.findAccountByEmail(account.getEmail());
        if(accountOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        accountRepository.save(account);
        Map<String, String> msgMap = new HashMap<>();
        msgMap.put("message","Saved Successfully");
        return msgMap;
    }
}
