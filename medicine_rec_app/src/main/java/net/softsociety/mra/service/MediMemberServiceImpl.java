package net.softsociety.mra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.mra.dao.MediMemberDAO;
import net.softsociety.mra.vo.MediMember;

@Slf4j
@Service
public class MediMemberServiceImpl implements MediMemberService {

	@Autowired
	MediMemberDAO dao;
	
	@Autowired
	PasswordEncoder pwEncoder;
	
	@Override
	public List<MediMember> listMediMember() {
		List<MediMember> result = dao.selectAll();
		
		return result;
	}

	@Override
	public MediMember SelectOne(int seq) {
		MediMember member = dao.selectOne(seq);
		return member;
	}

	@Override
	public boolean insertMember(MediMember member) {
		String encoderedPw = pwEncoder.encode(member.getMemberpw());
		member.setMemberpw(encoderedPw);
				
			
		int result = dao.insertMember(member);
		return result == 0 ? false : true;
	}

	@Override
	public boolean updateMember(MediMember member) {
		int result = dao.updateMember(member);
		return result == 0 ? false : true;
	}

	@Override
	public boolean deleteMember(int seq) {
		int result = dao.delteMember(seq);
		return result == 0 ? false : true;
	}

	@Override
	public MediMember selectOneById(String username) {
		MediMember result = dao.selectOneById(username);
		return result;
	}	
	
}
