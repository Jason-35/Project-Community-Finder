package pcf.jjs.project_community_finder_server.Room;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pcf.jjs.project_community_finder_server.Room.dto.RoomDTO;
import pcf.jjs.project_community_finder_server.Users.Users;
import pcf.jjs.project_community_finder_server.Users.UsersRepository;

@Service
public class RoomService {
    public final RoomRepository roomRepository;
    private final UsersRepository usersRepository;

    RoomService(RoomRepository roomRepository, UsersRepository usersRepository){
        this.roomRepository = roomRepository;
        this.usersRepository = usersRepository;
    }

    public String createRoom(RoomDTO roomDTO){
        String email = roomDTO.email;
        String username = roomDTO.username;
        String roomName = roomDTO.roomName;
        String status = roomDTO.status;
        List<String> tags = roomDTO.tags;
        String description = roomDTO.description;

        Optional<Users> userOpt = usersRepository.findUsersByEmail(email);

        
        Users user = userOpt.get();
        Room createdRoom = new Room(user, username, roomName, status, description, tags);

        user.getRooms().add(createdRoom);

        usersRepository.save(user);
        
        return "ha";
    }



}
