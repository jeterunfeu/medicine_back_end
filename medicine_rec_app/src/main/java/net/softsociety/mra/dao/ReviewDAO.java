package net.softsociety.mra.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.mra.vo.Review;

@Mapper
public interface ReviewDAO {

	List<Review> selectAll();

	Review selctOne(int seq);

	boolean insertReview(Review review);

	boolean updateReview(Review review);

	boolean deleteReview(int seq);

}
