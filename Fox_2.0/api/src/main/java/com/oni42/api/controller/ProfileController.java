package com.oni42.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private String name = "Max Mustermann";
    private String email = "max@beispiel.de";
    private int age = 30;

    @GetMapping
    public Profile getProfile() {
        return new Profile(name, email, age);
    }

    @PutMapping
    public String updateProfile(@RequestBody Profile newProfile) {
        this.name = newProfile.getName();
        this.email = newProfile.getEmail();
        this.age = newProfile.getAge();
        return "Profil erfolgreich aktualisiert!";
    }

    // Innere Klasse als DTO
    static class Profile {
        private String name;
        private String email;
        private int age;

        // Konstruktoren
        public Profile() {}
        public Profile(String name, String email, int age) {
            this.name = name;
            this.email = email;
            this.age = age;
        }

        // Getter und Setter
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
    }
}
