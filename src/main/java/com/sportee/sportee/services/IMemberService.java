package com.sportee.sportee.services;

import com.sportee.sportee.data.DTO.MemberDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IMemberService {

    List<MemberDTO> getAllMembers();

    void modifyMember(Integer id, Optional<String> firstName, Optional<String> lastName,
                    Optional<Date> birthDate, Optional<Integer> height);

    void insertMember(String firstName, String lastName, Date birthDate, int height);

    void deleteMember(Integer id);

}
