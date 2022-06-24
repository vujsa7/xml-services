package com.dislinkt.profileservice.service;

import com.dislinkt.profileservice.model.Profile;
import org.springframework.data.domain.Page;


import java.util.List;
import java.util.Optional;

public interface ProfileService {
    Optional<Profile> findById(String id);
    Optional<Profile> findByUsername(String username);
    List<Profile> findProfiles(String query, boolean authenticated);
    Page<Profile> findProfiles(String query, Integer size, boolean authenticated);
    void save(Profile profile);
    void saveInfo(Profile profile);
    void update(Profile profile, boolean isNewUsername);
    List<String> getPublicProfileIds();
}
