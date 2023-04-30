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
import net.softsociety.mra.service.ReviewService;
import net.softsociety.mra.vo.Review;

@Slf4j
@Controller
@RequestMapping("review")
public class ReviewController {

	@Autowired
	ReviewService service;
	
	@GetMapping()
	@ResponseBody()
	public List<Review> selectAll(){
		
		List<Review> result = service.selectAll();
		
		return result;
	}

	@GetMapping("/{seq}")
	@ResponseBody()
	public Review selectOne(@PathVariable("seq") int seq) {
		
		Review result = service.selectOne(seq);
		
		return result;
		
	}

	@PostMapping()
	@ResponseBody()
	public boolean insert(@RequestBody Review review) {
		
		boolean result = service.insertReview(review);
		
		return result;
	}
	
	@PutMapping("/{seq}")
	@ResponseBody()
	public boolean update(@PathVariable("seq") int seq, @RequestBody Review review) {
		
		review.setReviewnum(seq);
		
		boolean result = service.updateReview(review);
		
		return result;
	}
	
	@DeleteMapping("/{seq}")
	@ResponseBody()
	public boolean delete(@PathVariable("seq") int seq) {
		
		boolean result = service.deleteReview(seq);
		
		return result;
	}
}
