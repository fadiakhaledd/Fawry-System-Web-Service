package com.FawrySystem.FawrySystemService.models;

public class Admin extends User {

    public Admin(String username, String email, String password)
    {
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);

    }

}

