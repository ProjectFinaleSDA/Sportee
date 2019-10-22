package com.sportee.sportee.services;

import com.sportee.sportee.data.DTO.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserDTO> getAllUsers();

//    void sendMail(Integer userId, String subject, String content);

    void modifyUser(Integer id, Optional<String> name, Optional<String> email);

    void insertUser(String name, String password);

    void delete(Integer id);

//    void changeAddress(Integer userId, Optional<String> city, Optional<String> country, Optional<String> street);

//    metoda ne conecteaza la un serviciu exterior aplicatiei noastre
//    String getServiceTitle(Integer id) throws NotFoundException;

    String getUserName(Integer id) throws NotFoundException;

}
