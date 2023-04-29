package net.softsociety.mra.dao;

import java.util.List;

import net.softsociety.mra.vo.Review;

public interface ReviewDAO {

	List<Review> selectAll();

	Review selctOne(int seq);

	boolean insertReview(Review review);

	boolean updateReview(Review review);

	boolean deleteReview(int seq);

}
