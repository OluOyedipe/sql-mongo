package com.example.sqlmongo.sqlserver;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_info")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;

    public User(String string, String string2) {
        // TODO Auto-generated constructor stub
        name = string;
        email = string2;
    }
}
