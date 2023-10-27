package pcf.jjs.project_community_finder_server.Users;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import pcf.jjs.project_community_finder_server.Users.dto.UserEdit;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }
    /**
     * Service for creating an account and storing it in the database
     * Searches the user repository to check is
     * @param users a valid user entity
     * @return a map of type <String, String> if the creation of user is successful
     */
    public Map<String, String> createAccount(@Valid Users users){
        Optional<Users> usersOptional = usersRepository.findUsersByEmail(users.getEmail());
        if(usersOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

        usersRepository.save(users);
        Map<String, String> msgMap = new HashMap<>();
        msgMap.put("message","Saved Successfully");
        return msgMap;
    }

    /**
     * Service for getting the user's current setting. 
     * User's repository is queried and stored each field into a map of String and Object
     * @param email used to find the current user's repository
     * @return a Map of type <String, Object>
     */
    public Map<String, Object> getUserSettings(String email){
        Optional<Users> usersOptional = usersRepository.findUsersByEmail(email);

        if(usersOptional.isPresent() == false){
            throw new EntityNotFoundException();
        }

        Users user = usersOptional.get();
        // System.out.println(user.getEmail());
        Map<String, Object> userMap = new HashMap<>();

        userMap.put("email", user.getEmail());
        userMap.put("bio", user.getBio());
        userMap.put("user", user.getUsername());
        userMap.put("framework", user.getFramework());
        userMap.put("languages", user.getLanguages());
        userMap.put("experience", user.getExperience());
        return userMap;
    }

    /**
     * Service for editing the user's setting
     * 
     * @param email the email used to get the user's repository
     * @param editBody an dto object containing the data that will be changed
     * @return a map with success if everything is valid
     */
    public Map<String, String> editUserSetting(String email, UserEdit editBody){
        Optional<Users> usersOptional = usersRepository.findUsersByEmail(email);
        
        if(usersOptional.isPresent() == false){
            throw new EntityNotFoundException();
        }

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

    public String deleteUser(String email){
        // usersRepository.deleteUsersByEmail(email);
        usersRepository.deleteAll();
        return "Deleted";
    }
}
