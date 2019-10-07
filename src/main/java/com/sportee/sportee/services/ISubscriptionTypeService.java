package com.sportee.sportee.services;

import com.sportee.sportee.data.DAO.SubscriptionType;
import com.sportee.sportee.data.DTO.MemberDTO;
import com.sportee.sportee.data.DTO.SubscriptionTypeDTO;

import java.util.List;

public interface ISubscriptionTypeService {
    List<SubscriptionTypeDTO> getAllSubscriptionType();
}
