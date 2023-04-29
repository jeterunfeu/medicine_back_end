package net.softsociety.mra.dao;

import java.util.List;

import net.softsociety.mra.vo.Survey;

public interface SurveyDAO {

	List<Survey> selectAll();

	Survey selectOne(int seq);

	boolean insertSurvey(Survey survey);

	boolean updateSurvey(Survey survey);

	boolean deleteSurvey(int seq);

}
