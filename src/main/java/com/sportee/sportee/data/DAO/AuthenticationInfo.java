package com.sportee.sportee.data.DAO;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class AuthenticationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String password;

    @OneToOne(mappedBy = "authenticationInfo")
    private User user;

    @Builder
    public AuthenticationInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

}
