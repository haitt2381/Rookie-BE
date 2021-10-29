package com.nashtech.rookie.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column( name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "email")
    private String email;

    @Column(name = "image")
    private String image;

    @Column(name = "active")
    private boolean active;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String username, String email, String encode) {
        this.username = username;
        this.email = email;
        this.password = encode;
        this.firstName = "test";
        this.lastName="test";
        this.gender = true;
        this.image = "image";
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }
}
