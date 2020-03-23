package com.github.nez.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid")@GenericGenerator(name="uuid", strategy = "uuid2")
    String id;
    String twitterAccessToken;
    String facebookAccessToken;
    String username;
    String password;
}
