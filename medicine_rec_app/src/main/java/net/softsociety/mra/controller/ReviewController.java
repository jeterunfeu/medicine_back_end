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
import net.softsociety.mra.service.MediMemberService;
import net.softsociety.mra.service.MedicineService;
import net.softsociety.mra.service.ReviewService;
import net.softsociety.mra.util.PageNavigator;
import net.softsociety.mra.vo.MediMember;
import net.softsociety.mra.vo.Medicine;
import net.softsociety.mra.vo.Review;
import net.softsociety.mra.vo.ReviewList;

@Slf4j
@RestController
@RequestMapping("review")
public class ReviewController {

	@Autowired
	ReviewService service;
	@Autowired
	MedicineService mService;
	@Autowired
	MediMemberService uService;
	
	@Value("${user.board.page}")
	int countPerPage;
	
	@Value("${user.board.group}")
	int pagePerGroup;
	
	@GetMapping()
	public PageNavigator selectAllByCondition(@RequestParam(name="mednum", defaultValue="0") int mednum,
			@RequestParam(name="page", defaultValue="1") int page, Review review){
		PageNavigator result = service.getPageNavigator(pagePerGroup, countPerPage, page, review);
		Medicine med = mService.selectOne(mednum);
		List<Review> list = service.selectAll(result, review);
		ReviewList rList = new ReviewList(med.getMednum(), med.getPicture(), med.getMedname(),
				med.getMedco(), med.getPrice(), med.getTakemed(), med.getMedcycle(), med.getIngredient(),
				med.getStar(), med.getNote(), list);
		result.setData(rList);
		return result;
	}
	
	@GetMapping()
	public List<Review> selectAll() {
		List<Review> result = service.selectAll();
		
		return result;
	}

	@GetMapping("/{seq}")
	public Review selectOne(@PathVariable("seq") int seq) {
		
		Review result = service.selectOne(seq);
		
		return result;
		
	}

	@PostMapping()
	public boolean insert(@AuthenticationPrincipal UserDetails user, @RequestBody Review review) {
		MediMember member = uService.selectOneById(user.getUsername());
		review.setMembernum(member.getMembernum());
		boolean result = service.insertReview(review);
		
		return result;
	}
	
	@PutMapping("/{seq}")
	public boolean update(@AuthenticationPrincipal UserDetails user, @PathVariable("seq") int seq, @RequestBody Review review) {
		MediMember member = uService.selectOneById(user.getUsername());
		review.setMembernum(member.getMembernum());
		review.setReviewnum(seq);
		boolean result = service.updateReview(review);
		
		return result;
	}
	
	@DeleteMapping("/{seq}")
	public boolean delete(@PathVariable("seq") int seq) {
		
		boolean result = service.deleteReview(seq);
		
		return result;
	}
}
