package com.sportee.sportee.services;

import com.sportee.sportee.data.DAO.SporteeMember;
import com.sportee.sportee.data.DTO.MemberDTO;
import com.sportee.sportee.data.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService implements IMemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<MemberDTO> getAllMembers() {
        List<MemberDTO> members = new ArrayList<MemberDTO>();
        Iterable<SporteeMember> all = memberRepository.findAll();
        all.forEach(m -> members.add(new MemberDTO(m)));
        return members;
    }
}
