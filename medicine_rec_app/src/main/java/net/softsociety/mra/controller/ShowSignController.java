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

import lombok.extern.slf4j.Slf4j;
import net.softsociety.mra.service.ShowSignService;
import net.softsociety.mra.vo.Medicine;
import net.softsociety.mra.vo.ShowSign;


@Slf4j
@Controller
@RequestMapping("showsign")
public class ShowSignController {

	@Autowired
	ShowSignService  service;
	
	@GetMapping()
	public List<ShowSign> selectAll(){
		
		List<ShowSign> result = service.selectAll();
		
		return result;
	}

	@GetMapping("/{seq}")
	public ShowSign selectOne(@PathVariable("seq") int seq) {
		
		ShowSign result = service.selectOne(seq);
		
		return result;
		
	}

	@PostMapping()
	public boolean insert(@RequestBody ShowSign showsign) {
		
		boolean result = service.insertShowSign(showsign);
		
		return result;
	}
	
	@PutMapping("/{seq}")
	public boolean update(@PathVariable("seq") int seq, @RequestBody ShowSign showsign) {
		
		showsign.setMednum(seq);
		
		boolean result = service.updateShowSign(showsign);
		
		return result;
	}
	
	@DeleteMapping("/{seq}")
	public boolean delete(@PathVariable("seq") int seq) {
		
		boolean result = service.deleteShowSign(seq);
		
		return result;
	}
}
