package net.softsociety.mra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.mra.dao.SurveyDAO;
import net.softsociety.mra.vo.Survey;

@Service
public class SurveyServiceImpl implements SurveyService {

	@Autowired
	SurveyDAO dao;

	@Override
	public List<Survey> selectAll() {
		List<Survey> list = dao.selectAll();
		return list;
	}

	@Override
	public Survey selectOne(int seq) {
		Survey survey = dao.selectOne(seq);
		return survey;
	}

	@Override
	public boolean insertSurvey(Survey survey) {
		boolean result = dao.insertSurvey(survey);
		return result;
	}

	@Override
	public boolean updateSurvey(Survey survey) {
		boolean result = dao.updateSurvey(survey);
		return result;
	}

	@Override
	public boolean deleteSurvey(int seq) {
		boolean result = dao.deleteSurvey(seq);
		return result;
	}
	
	
}
