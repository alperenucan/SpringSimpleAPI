package com.internship.tutorial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kullanici")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    @Column(name = "userName")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "eMaiL",unique = true)
    private String email;
    @Column(name = "age")
    private Integer age;

    public User(String username, String password, String email, Integer age) {

    }
}
