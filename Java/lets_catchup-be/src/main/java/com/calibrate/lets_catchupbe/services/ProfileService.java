package com.calibrate.lets_catchupbe.services;

import com.calibrate.lets_catchupbe.models.Friend;
import com.calibrate.lets_catchupbe.models.Profile;
import com.calibrate.lets_catchupbe.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;


    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    public Profile getProfileById(String id) {
        return profileRepository.findById(id).orElse(null);
    }

    public Profile getProfileByEmail(String email) {

        Optional<Profile> Profile = profileRepository.findByEmail(email);
        return Profile.orElse(null);
    }

    public void createProfile(Profile profile) {
        profile.setFullName();
        profileRepository.save(profile);
    }
    public void friendRequest(String profileId, String requestProfileId) {
        Profile account = getProfileById(profileId);
        Profile request = getProfileById(requestProfileId);
        if(request.getFullName().equals(null)){
            request.setFullName();
        }

        Friend friend = new Friend(request.getId(), request.getFullName());

        account.requestConnection(friend);
        profileRepository.save(account);

    }

    public void acceptRequest(String profileId, String requestProfileId) {
        Profile account = getProfileById(profileId);
        Profile requester = getProfileById(requestProfileId);
        Friend accountFriend = new Friend(account.getId(), account.getFullName());

        ArrayList<Friend> requestList = account.getFriendRequest();

        for (int i = 0; i < requestList.size(); i++) {
            Friend request = requestList.get(i);
            if (request.getId().equals(requestProfileId)) {
                account.acceptConnection(request);
                requester.acceptConnection(accountFriend);
                requestList.remove(i); // Safely remove the element by index
                i--; // Decrement the index to account for the removed element
                profileRepository.save(account);
                profileRepository.save(requester);
            }
        }
    }





}




