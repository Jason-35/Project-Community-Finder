package pcf.jjs.project_community_finder_server.Users;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import pcf.jjs.project_community_finder_server.Users.dto.UserEdit;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.ArrayList;
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
        Optional<Users> usersOptional = usersRepository.findUsersByEmail(users.getEmail());
        if(usersOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        usersRepository.save(users);
        Map<String, String> msgMap = new HashMap<>();
        msgMap.put("message","Saved Successfully");
        return msgMap;
    }

    public Map<String, Object> getUserSettings(String email){
        Optional<Users> usersOptional = usersRepository.findUsersByEmail(email);
        Users user = usersOptional.get();
        Map<String, Object> userMap = new HashMap<>();

        userMap.put("email", user.getEmail());
        userMap.put("bio", user.getBio());
        userMap.put("user", user.getUsername());
        userMap.put("framework", user.getFramework());
        userMap.put("languages", user.getLanguages());
        userMap.put("experience", user.getExperience());
        return userMap;
    }

    public Map<String, String> editUserSetting(String email, UserEdit editBody){
        Optional<Users> usersOptional = usersRepository.findUsersByEmail(email);
        Users user = usersOptional.get();

        if (editBody.bio != null){
            user.setBio(editBody.bio);
        }

        if (editBody.experience != null){
            user.setExperience(editBody.experience);
        }

        if (editBody.frameworks != null){
            user.setFramework(editBody.frameworks);
        }

        if (editBody.languages != null){
            user.setLanguages(editBody.languages);
        }

        usersRepository.save(user);

        
        Map<String, String> msgMap = new HashMap<>();
        msgMap.put("message","Success");
        return msgMap;
    }
}
