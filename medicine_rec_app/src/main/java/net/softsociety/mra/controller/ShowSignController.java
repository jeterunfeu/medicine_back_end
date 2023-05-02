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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.mra.service.ShowSignService;
import net.softsociety.mra.vo.ShowSign;


@Slf4j
@Controller
@RequestMapping("showsign")
public class ShowSignController {

	@Autowired
	ShowSignService  service;
	
	@GetMapping()
	@ResponseBody()
	public List<ShowSign> selectAll(){
		
		List<ShowSign> result = service.selectAll();
		
		return result;
	}
	
	@GetMapping("/group")
	@ResponseBody
	public List<ShowSign> selectAllByGroup(ShowSign showSign){
		List<ShowSign> result = service.selectAllByGroup(showSign);
		
		return result;
	}

	@GetMapping("/{seq}")
	@ResponseBody()
	public ShowSign selectOne(@PathVariable("seq") int seq) {
		
		ShowSign result = service.selectOne(seq);
		
		return result;
		
	}

	@PostMapping()
	@ResponseBody()
	public boolean insert(@RequestBody ShowSign showsign) {
		
		boolean result = service.insertShowSign(showsign);
		
		return result;
	}
	
	@PutMapping("/{seq}")
	@ResponseBody()
	public boolean update(@PathVariable("seq") int seq, @RequestBody ShowSign showsign) {
		
		showsign.setSignnum(seq);
		
		boolean result = service.updateShowSign(showsign);
		
		return result;
	}
	
	@DeleteMapping("/{seq}")
	@ResponseBody()
	public boolean delete(@PathVariable("seq") int seq) {
		
		boolean result = service.deleteShowSign(seq);
		
		return result;
	}
}
