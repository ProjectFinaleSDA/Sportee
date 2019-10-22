package com.sportee.sportee.data.DAO;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String userName;
    private String password;

    @OneToOne(mappedBy = "user")
    private SporteeMember member;



    @Builder
    public User(int id, String userName, String password) {
        this.id=id;
        this.userName = userName;
        this.password = password;
    }

}
