package net.softsociety.mra.service;

import java.util.List;

import net.softsociety.mra.util.PageNavigator;
import net.softsociety.mra.vo.Review;

public interface ReviewService {

	List<Review> selectAll();

	Review selectOne(int seq);

	boolean insertReview(Review review);

	boolean updateReview(Review review);

	boolean deleteReview(int seq);

	PageNavigator getPageNavigator(int pagePerGroup, int countPerPage, int page, Review review);

	List<Review> selectAll(PageNavigator result, Review review);

}
