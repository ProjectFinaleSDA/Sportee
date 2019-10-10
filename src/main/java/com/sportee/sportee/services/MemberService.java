package com.sportee.sportee.services;

import com.sportee.sportee.data.DAO.Role;
import com.sportee.sportee.data.DAO.SporteeMember;
import com.sportee.sportee.data.DTO.MemberDTO;
import com.sportee.sportee.data.repositories.MemberRepository;
import com.sportee.sportee.data.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements IMemberService {

    private MemberRepository memberRepository;
    private RoleRepository roleRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository, RoleRepository roleRepository) {
        this.memberRepository = memberRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<MemberDTO> getAllMembers() {
        List<MemberDTO> members = new ArrayList<MemberDTO>();
        Iterable<SporteeMember> all = memberRepository.findAll();
        all.forEach(m -> members.add(new MemberDTO(m)));
        return members;
    }

    @Override
    public void modifyMember(Integer id, Optional<String> firstName, Optional<String> lastName,
                             Optional<Date> birthDate, Optional<Integer> height) {
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
    public void insertMember(String firstName, String lastName, Date birthDate, int height, int roleId) {
        Optional<Role> role = roleRepository.findById(roleId);
        role.ifPresent(r -> {
            SporteeMember m = SporteeMember.builder().firstName(firstName).lastName(lastName)
                    .birthDate(birthDate).height(height).role(r).build();

            memberRepository.save(m);

        });
    }

    @Override
    public void deleteMember(Integer id) {
        memberRepository.deleteById(id);
    }


}
