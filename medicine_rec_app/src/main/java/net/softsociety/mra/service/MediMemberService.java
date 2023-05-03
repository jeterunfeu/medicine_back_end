package net.softsociety.mra.service;

import java.util.List;

import net.softsociety.mra.vo.MediMember;

public interface MediMemberService {

	List<MediMember> listMediMember();

	MediMember SelectOne(int seq);

	boolean insertMember(MediMember member);

	boolean updateMember(MediMember member);

	boolean deleteMember(int seq);

	MediMember selectOneById(String username);


}
