package com.sportee.sportee.data.DTO;

import com.sportee.sportee.data.DAO.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDTO {
private int id;
    private String userName;
    private String password;



    public UserDTO(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.password = user.getPassword();
    }
}
