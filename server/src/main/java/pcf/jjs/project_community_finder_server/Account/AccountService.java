package pcf.jjs.project_community_finder_server.Account;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    // Dependency Injection for accountRepository which serves as access to the database
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    // Service for creating new accounts. Need to redo the error for when an account already exist
    public void createAccount(Account account){
        Optional<Account> accountOptional = accountRepository.findAccountByEmail(account.getEmail());
        if(accountOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        accountRepository.save(account);
    }
}
