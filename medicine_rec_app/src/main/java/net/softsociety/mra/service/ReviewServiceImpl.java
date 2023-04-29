package net.softsociety.mra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.mra.dao.ReviewDAO;
import net.softsociety.mra.vo.Review;

@Service
public interface ReviewServiceImpl extends ReviewService {

	@Autowired
	ReviewDAO dao;

	@Override
	default List<Review> selectAll() {
		List<Review> list = dao.selectAll();
		return list;
	}

	@Override
	default Review selectOne(int seq) {
		Review review = dao.selctOne(seq);
		return review;
	}

	@Override
	default boolean insertReview(Review review) {
		boolean result = dao.insertReview(review);
		return result;
	}

	@Override
	default boolean updateReview(Review review) {
		boolean result = dao.updateReview(review);
		return result;
	}

	@Override
	default boolean deleteReview(int seq) {
		boolean result = dao.deleteReview(seq);
		return false;
	}
	
	
}
