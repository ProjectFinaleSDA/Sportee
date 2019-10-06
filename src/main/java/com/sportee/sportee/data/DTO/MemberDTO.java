package com.sportee.sportee.data.DTO;

import com.sportee.sportee.data.DAO.Role;
import com.sportee.sportee.data.DAO.SporteeMember;
import lombok.Getter;

import java.util.Date;

@Getter
public class MemberDTO {

    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String role;


    public MemberDTO(SporteeMember member) {
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.birthDate = member.getBirthDate();
        this.role = member.getRole().getName();


    }
}
