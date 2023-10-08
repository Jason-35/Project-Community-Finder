package pcf.jjs.project_community_finder_server.Users;

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
public class UsersService {
    private final UsersRepository usersRepository;
    // Dependency Injection for accountRepository which serves as access to the database
    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }
    // Service for creating new accounts. Need to redo the error for when an account already exist
    public Map<String, String> createAccount(@Valid Users users){

//        Account newAccount = new Account(account.getUsername(), account.getPassword(), account.getEmail());

        Optional<Users> usersOptional = usersRepository.findUsersByEmail(users.getEmail());
        if(usersOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        usersRepository.save(users);
        Map<String, String> msgMap = new HashMap<>();
        msgMap.put("message","Saved Successfully");
        return msgMap;
    }
}
