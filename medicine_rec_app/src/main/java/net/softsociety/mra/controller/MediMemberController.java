package net.softsociety.mra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.mra.service.MediMemberService;
import net.softsociety.mra.vo.MediMember;

@Slf4j
@Controller
@RequestMapping("member")
public class MediMemberController {

	@Autowired
	MediMemberService service;
	
	@GetMapping()
	@ResponseBody()
	public List<MediMember> selectAll(){
		
		List<MediMember> result = service.listMediMember();
		
		return result;
	}

	@GetMapping("/{seq}")
	@ResponseBody()
	public MediMember selectOne(@PathVariable("seq") int seq) {
		
		MediMember result = service.SelectOne(seq);
		
		return result;
		
	}

	@PostMapping()
	@ResponseBody()
	public boolean insert(@RequestBody MediMember member) {
		
		log.info("member : {} ", member);
		
		boolean result = service.insertMember(member);
		
		return result;
	}
	
	@PutMapping("/{seq}")
	@ResponseBody()
	public boolean update(@PathVariable("seq") int seq, @RequestBody MediMember member) {
		
		member.setMembernum(seq);
		
		boolean result = service.updateMember(member);
		
		return result;
	}
	
	@DeleteMapping("/{seq}")
	@ResponseBody()
	public boolean delete(@PathVariable("seq") int seq) {
		
		boolean result = service.deleteMember(seq);
		
		return result;
	}
}
