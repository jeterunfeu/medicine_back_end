package net.softsociety.mra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.mra.service.PersonalHistoryService;
import net.softsociety.mra.util.PageNavigator;
import net.softsociety.mra.vo.History;
import net.softsociety.mra.vo.MediMember;
import net.softsociety.mra.vo.PersonalHistory;

@Slf4j
@RestController
@RequestMapping("personalHistory")
public class PersonalHistoryController {

	@Autowired
	PersonalHistoryService service;
	
	@Value("${user.board.page}")
	int countPerPage;
	
	@Value("${user.board.group}")
	int pagePerGroup;
	
	@GetMapping()
	public PageNavigator selectAll(@AuthenticationPrincipal UserDetails user, @RequestParam(name="page", defaultValue="1") int page, History history){
		MediMember person = service.selectOneById(user.getUsername());
		if(history.getMembernum() != person.getMembernum()) {
			return null;
		}
		history.setMembernum(person.getMembernum());
		PageNavigator result = service.getPageNavigator(pagePerGroup, countPerPage, page, history);
		List<History> data = service.selectAll(result, history);
		result.setData(data);
		return result;
	}

	@GetMapping("/{seq}")
	public PersonalHistory selectOne(@PathVariable("seq") int seq) {
		
		PersonalHistory result = service.selectOne(seq);
		
		return result;
		
	}

	@PostMapping()
	public boolean insert(@RequestBody PersonalHistory personalhistory) {
		
		boolean result = service.insertPersonalHistroy(personalhistory);
		
		return result;
	}
	
	@PutMapping("/{seq}")
	public boolean update(@PathVariable("seq") int seq, @RequestBody PersonalHistory personalhistory) {
		
		personalhistory.setHistorynum(seq);
		
		boolean result = service.updatePersonalHistroy(personalhistory);
		
		return result;
	}
	
	@DeleteMapping("/{seq}")
	public boolean delete(@PathVariable("seq") int seq) {
		
		boolean result = service.deletePersonalHistory(seq);
		
		return result;
	}
}
