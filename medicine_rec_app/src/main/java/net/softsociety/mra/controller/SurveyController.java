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
import net.softsociety.mra.service.SurveyService;
import net.softsociety.mra.vo.Survey;

@Slf4j
@Controller
@RequestMapping("survey")
public class SurveyController {

	@Autowired
	SurveyService service;
	
	@GetMapping()
	public List<Survey> selectAll(){
		
		List<Survey> result = service.selectAll();
		
		return result;
	}

	@GetMapping("/{seq}")
	@ResponseBody
	public Survey selectOne(@PathVariable("seq") int seq) {
		
		Survey result = service.selectOne(seq);
		
		return result;
		
	}

	@PostMapping()
	@ResponseBody()
	public boolean insert(@RequestBody Survey survey) {
		
		boolean result = service.insertSurvey(survey);
		
		return result;
	}
	
	@PutMapping("/{seq}")
	@ResponseBody()
	public boolean update(@PathVariable("seq") int seq, @RequestBody Survey survey) {
		
		survey.setSurveynum(seq);
		
		boolean result = service.updateSurvey(survey);
		
		return result;
	}
	
	@DeleteMapping("/{seq}")
	@ResponseBody()
	public boolean delete(@PathVariable("seq") int seq) {
		
		boolean result = service.deleteSurvey(seq);
		
		return result;
	}
}
