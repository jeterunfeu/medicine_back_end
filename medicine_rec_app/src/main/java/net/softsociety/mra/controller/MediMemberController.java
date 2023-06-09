package net.softsociety.mra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.mra.service.MediMemberService;
import net.softsociety.mra.vo.MediMember;
import net.softsociety.mra.vo.Member;

@Slf4j
@RestController
@RequestMapping("member")
public class MediMemberController {

	@Autowired
	MediMemberService service;
	
	@GetMapping()
	public List<MediMember> selectAll(){
		
		List<MediMember> result = service.listMediMember();
		
		return result;
	}
	
	@GetMapping("/info/id")
	public Member selectOneByLogin(@AuthenticationPrincipal UserDetails user){
		
//		Member result = service.selectOneByLogin(user.getUsername()); 프론트용
		Member result = service.selectOneByLogin("aaa");
		
		return result;
	}
	
	@GetMapping("/info/seq")
	public String selectSeqByLogin(@AuthenticationPrincipal UserDetails user){
		
//		Member result = service.selectOneByLogin(user.getUsername());
		
		return "aaa"; //프론트용
	}

	@GetMapping("/{seq}")
	public MediMember selectOne(@PathVariable("seq") int seq) {
		
		MediMember result = service.SelectOne(seq);
		
		return result;
		
	}
	
	@GetMapping("/idcheck/{id}")
	public boolean selectOneDuplicted(@PathVariable("id") String id) {
		
		MediMember result = service.selectOneById(id);
		
		return result != null ? false : true;
		
	}

	@PostMapping()
	public boolean insert(@RequestBody MediMember member) {
		
		log.info("member : {} ", member);
		
		boolean result = service.insertMember(member);
		
		return result;
	}
	
	@PutMapping("/{seq}")
	public boolean update(@PathVariable("seq") int seq, @RequestBody MediMember member) {
		
		member.setMembernum(seq);
		
		boolean result = service.updateMember(member);
		
		return result;
	}
	
	@PutMapping("/info/id")
	public boolean updateLogin(@AuthenticationPrincipal UserDetails user, @RequestBody MediMember member) {
//		String id = user.getUsername();
//		if(!id.equals(member.getMemberid())) {
//			return false;
//		} 프론트용
		
		boolean result = service.updateMemberLogin(member);
		
		return result;
	}
	
	@DeleteMapping("/{seq}")
	public boolean delete(@PathVariable("seq") int seq) {
		
		boolean result = service.deleteMember(seq);
		
		return result;
	}
}
