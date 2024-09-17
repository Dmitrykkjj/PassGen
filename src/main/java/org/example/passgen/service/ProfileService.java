package org.example.passgen.service;

import org.example.passgen.models.Profile;
import org.example.passgen.repository.ProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> retrieveAll() {
        return profileRepository.findAll();
    }

    public void create(Profile profile) {
        profileRepository.save(profile);
    }

    public Profile findById(int id) {
        return profileRepository.getReferenceById(id);
    }

    public void delete(int id) {
        profileRepository.deleteById(id);
    }

    public void update(Profile profile) {
        Optional<Profile> row = profileRepository.findById(profile.getId());
        if (row.isPresent()) {
            Profile item = row.get();
            if (!profile.getLogin().isEmpty()) {
                item.setLogin(profile.getLogin());
            }
            if (!profile.getPassword().isEmpty()) {
                item.setPassword(profile.getPassword());
            }
            if (!profile.getSite().isEmpty()) {
                item.setSite(profile.getSite());
            }
            profileRepository.save(item);
        }
    }
}
