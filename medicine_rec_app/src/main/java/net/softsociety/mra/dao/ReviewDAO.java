package net.softsociety.mra.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import net.softsociety.mra.vo.Review;

@Mapper
public interface ReviewDAO {

	List<Review> selectAll();

	Review selectOne(int seq);

	boolean insertReview(Review review);

	boolean updateReview(Review review);

	boolean deleteReview(int seq);

	int countAll(Review review);

	List<Review> selectAllByCondition(Review review, RowBounds rb);

}
