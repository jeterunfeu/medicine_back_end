package net.softsociety.mra.service;

import java.util.List;

import net.softsociety.mra.vo.Survey;

public interface SurveyService {

	List<Survey> selectAll();

	Survey selectOne(int seq);

	boolean insertSurvey(Survey survey);

	boolean updateSurvey(Survey survey);

	boolean deleteSurvey(int seq);

}
