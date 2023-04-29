package net.softsociety.mra.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.mra.vo.Survey;

@Mapper
public interface SurveyDAO {

	List<Survey> selectAll();

	Survey selectOne(int seq);

	boolean insertSurvey(Survey survey);

	boolean updateSurvey(Survey survey);

	boolean deleteSurvey(int seq);

}
