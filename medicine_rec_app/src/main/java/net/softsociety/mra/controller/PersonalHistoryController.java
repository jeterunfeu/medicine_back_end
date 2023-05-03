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
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.mra.service.PersonalHistoryService;
import net.softsociety.mra.vo.PersonalHistory;
import net.softsociety.mra.vo.Survey;

@Slf4j
@RestController
@RequestMapping("personalHistory")
public class PersonalHistoryController {

	@Autowired
	PersonalHistoryService service;
	
	@GetMapping()
	public List<PersonalHistory> selectAll(){
		
		List<PersonalHistory> result = service.selectAll();
		
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
