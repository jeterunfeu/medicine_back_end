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
import net.softsociety.mra.service.MedicineService;

import net.softsociety.mra.vo.Medicine;

@Slf4j
@Controller
@RequestMapping("medicne")
public class MedicineController {

	@Autowired
	MedicineService service;
	
	@GetMapping()
public List<Medicine> selectAll(){
		
		List<Medicine> result = service.selectAll();
		
		return result;
	}

	@GetMapping("/{seq}")
	public Medicine selectOne(@PathVariable("seq") int seq) {
		
		Medicine result = service.selectOne(seq);
		
		return result;
		
	}

	@PostMapping()
	public boolean insert(@RequestBody Medicine medicine) {
		
		boolean result = service.insertMedicine(medicine);
		
		return result;
	}
	
	@PutMapping("/{seq}")
	public boolean update(@PathVariable("seq") int seq, @RequestBody Medicine medicine) {
		
		medicine.setMednum(seq);
		
		boolean result = service.updateMedicine(medicine);
		
		return result;
	}
	
	@DeleteMapping("/{seq}")
	public boolean delete(@PathVariable("seq") int seq) {
		
		boolean result = service.deleteMedicine(seq);
		
		return result;
	}
}
