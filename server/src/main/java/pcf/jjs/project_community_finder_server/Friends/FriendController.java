package pcf.jjs.project_community_finder_server.Friends;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pcf.jjs.project_community_finder_server.Friends.dto.FriendDTO;


@RestController
@RequestMapping(path = "/api/friends")
public class FriendController {

    public final FriendService friendService;


    FriendController(FriendService friendService) {
        this.friendService = friendService;
    }


    @GetMapping("/getFriends")
    public List<String> getFriendsUsername(@RequestParam String email){
        return friendService.getFriendsUsernames(email);
        
    }

    @DeleteMapping("/deleteFriend")
    public String deleteFriend(@RequestParam String userEmail, @RequestParam String friendEmail){
        friendService.deleteFriend(userEmail, friendEmail);
        return "removed " + friendEmail + " and " + userEmail + " as friends";
    }
}
