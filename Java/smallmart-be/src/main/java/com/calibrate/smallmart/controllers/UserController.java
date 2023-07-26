package com.calibrate.smallmart.controllers;

import com.calibrate.smallmart.managers.UserManager;
import com.calibrate.smallmart.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {


    @PostMapping("/user")
    public ArrayList getUserInfo(@RequestBody Email emailAddress) {

        User user = UserManager.userManager.get(emailAddress.getEmail());

        ArrayList<User> AccountInfo = new ArrayList<>();
        AccountInfo.add(user);

        return AccountInfo;
    }

}
@AllArgsConstructor @NoArgsConstructor @Getter
class Email {
    private String email;

}
