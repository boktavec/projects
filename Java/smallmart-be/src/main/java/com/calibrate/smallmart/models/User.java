package com.calibrate.smallmart.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter @NoArgsConstructor
public class User {
    private String userFirstName, userLastName, userEmail, userAddress, userPaymentInfo;

    public User(String userFirstName, String userLastName, String userEmail, String userAddress, String userPaymentInfo) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.userPaymentInfo = userPaymentInfo;
    }

    @Override
    public String toString() {
        return "{" +
                "userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userPaymentInfo='" + userPaymentInfo +
                '}';
    }
}
