package org.example.passgen.controller;

import org.example.passgen.dto.ProfileDto;
import org.example.passgen.models.Profile;
import org.example.passgen.service.ProfileService;
import org.example.passgen.tools.PasswordGenerator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/index")
public class Controller {

    private final ProfileService profileService;
    private final PasswordGenerator passwordGenerator;

    public Controller(ProfileService profileService, PasswordGenerator passwordGenerator) {
        this.profileService = profileService;
        this.passwordGenerator = passwordGenerator;
    }

    @GetMapping("/generator/{length}")
    public String generatePassword(@PathVariable("length") int length) {
        return passwordGenerator.generateNewPassword(length);
    }

    @GetMapping("/list")
    public List<Profile> allProfile() {
        return profileService.retrieveAll();
    }

    @PostMapping("/new-profile")
    public void createNewProfile(@RequestBody ProfileDto profileDto) {
        Profile profile = new Profile();
        profile.setLogin(profileDto.getLogin());
        profile.setPassword(profileDto.getPassword());
        profile.setSite(profileDto.getSite());
        profileService.create(profile);
    }

    @PatchMapping("/update-profile")
    public void update(@RequestBody Profile profile) {
        profileService.update(profile);
    }

    @GetMapping("/list/{id}")
    public Profile getProfile(@PathVariable int id) {
        return profileService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProfile(@PathVariable int id) {
        profileService.delete(id);
    }

}
