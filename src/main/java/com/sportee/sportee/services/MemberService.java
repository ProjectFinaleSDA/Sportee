package com.sportee.sportee.services;

import com.sportee.sportee.data.DAO.Role;
import com.sportee.sportee.data.DAO.SporteeMember;
import com.sportee.sportee.data.DAO.User;
import com.sportee.sportee.data.DTO.MemberDTO;
import com.sportee.sportee.data.repositories.MemberRepository;
import com.sportee.sportee.data.repositories.RoleRepository;
import com.sportee.sportee.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements IMemberService {

    private MemberRepository memberRepository;
    private RoleRepository roleRepository;
    private UserRepository userRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository, RoleRepository roleRepository, UserRepository userRepository) {
        this.memberRepository = memberRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<MemberDTO> getAllMembers() {
        List<MemberDTO> members = new ArrayList<MemberDTO>();
        Iterable<SporteeMember> all = memberRepository.findAll();
        all.forEach(m -> members.add(new MemberDTO(m)));
        return members;
    }

    public void modifyMember(Integer id, Optional<String> firstName, Optional<String> lastName,
                             Optional<java.sql.Date> birthDate, Optional<Integer> height) {
        Optional<SporteeMember> member = memberRepository.findById(id);
        member.ifPresent(m -> {
            firstName.ifPresent(n -> m.setFirstName(n));
            lastName.ifPresent(l -> m.setLastName(l));
            birthDate.ifPresent(b -> m.setBirthDate(b));
            height.ifPresent(h -> m.setHeight(h));
            memberRepository.save(m);
        });
    }

    @Override
    public void insertMember(String firstName, String lastName, Date birthDate, int height, int roleId, int userId) {
        Optional<Role> role = roleRepository.findById(roleId);
        Optional<User> user = userRepository.findById(userId);
        role.ifPresent(r -> {

                    SporteeMember m = SporteeMember.builder().firstName(firstName).lastName(lastName)
                    .birthDate(birthDate).height(height).role(r).user(user.get()).build();

            memberRepository.save(m);

        });
    }



    @Override
    public void deleteMember(Integer id) {
        memberRepository.deleteById(id);
    }


}
