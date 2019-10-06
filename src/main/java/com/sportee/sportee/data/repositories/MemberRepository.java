package com.sportee.sportee.data.repositories;

import com.sportee.sportee.data.DAO.SporteeMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<SporteeMember, Integer> {
}
