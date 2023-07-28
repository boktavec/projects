package com.calibrate.lets_catchupbe.controllers;

import com.calibrate.lets_catchupbe.models.Profile;
import com.calibrate.lets_catchupbe.services.ProfileService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProfileController {
    private final ProfileService profileService;
    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }


    @PostMapping("/create-profile")
    public void createProfile(@RequestBody Profile profile) {
        profileService.createProfile(profile);
    }

    @GetMapping("/get-profile/{id}")
    public Profile getProfile(@PathVariable String id) {
        Profile profile = profileService.getProfileById(id);

        return profile;
    }

    @GetMapping("/login/{email}")
    public Profile profileLogin(@PathVariable String email) {
        Profile profile = profileService.getProfileByEmail(email);

        return profile;
    }

    @PostMapping("/friend-request")
    public void requestFriendship(@RequestBody FriendRequest request){
        String accountId = request.getAccountId();
        String requestId = request.getRequestId();
        profileService.friendRequest(accountId, requestId);
    }

    @PostMapping("/accept-request")
    public void acceptFriendship(@RequestBody FriendRequest friend) {
        String accountId = friend.getAccountId();
        String requestId = friend.getRequestId();
        profileService.acceptRequest(accountId, requestId);
    }
}
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
class FriendRequest {
    private String accountId;
    private String requestId;


}

//@Getter @AllArgsConstructor @NoArgsConstructor
//class Login {
//    private String email;
//        }
