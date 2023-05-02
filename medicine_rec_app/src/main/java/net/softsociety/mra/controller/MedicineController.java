package net.softsociety.mra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import net.softsociety.mra.service.MedicineService;
import net.softsociety.mra.util.PageNavigator;
import net.softsociety.mra.vo.Medicine;
import net.softsociety.mra.vo.ShowSign;

@Slf4j
@Controller
@RequestMapping("med")
public class MedicineController {

	@Autowired
	MedicineService service;
	
	@Value("${user.board.page}")
	int countPerPage;
	
	@Value("${user.board.group}")
	int pagePerGroup;
	
	@GetMapping()
	@ResponseBody()
	public List<Medicine> selectAll(){

		List<Medicine> result = service.selectAll();
		
		return result;
	}
	
	@GetMapping("/condition")
	@ResponseBody()
	public PageNavigator selectAllByCondition(@RequestParam(name="page", defaultValue="1") int page, Medicine medicine){
		PageNavigator result = service.getPageNavigator(pagePerGroup, countPerPage, page, medicine);
		List<Medicine> data = service.selectAll(result, medicine);
		result.setData(data);
		return result;
	}
	
	@GetMapping("/symptom")
	@ResponseBody()
	public PageNavigator selectAllByCondition(@RequestParam(name="page", defaultValue="1") int page, ShowSign showsign){
		PageNavigator result = service.getPageNavigator(pagePerGroup, countPerPage, page, showsign);
		List<Medicine> data = service.selectAll(result, showsign);
		result.setData(data);
		return result;
	}

	@GetMapping("/{seq}")
	public Medicine selectOne(@PathVariable("seq") int seq) {
		
		Medicine result = service.selectOne(seq);
		
		return result;
		
	}

	@PostMapping()
	@ResponseBody()
	public boolean insert(@RequestBody Medicine medicine) {
		
		boolean result = service.insertMedicine(medicine);
		
		return result;
	}
	
	@PutMapping("/{seq}")
	@ResponseBody()
	public boolean update(@PathVariable("seq") int seq, @RequestBody Medicine medicine) {
		
		medicine.setMednum(seq);
		
		boolean result = service.updateMedicine(medicine);
		
		return result;
	}
	
	@DeleteMapping("/{seq}")
	@ResponseBody()
	public boolean delete(@PathVariable("seq") int seq) {
		
		boolean result = service.deleteMedicine(seq);
		
		return result;
	}
}
