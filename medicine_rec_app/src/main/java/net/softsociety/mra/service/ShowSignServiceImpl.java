package net.softsociety.mra.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.mra.dao.ShowSignDAO;
import net.softsociety.mra.util.PageNavigator;
import net.softsociety.mra.vo.ShowSign;

@Service
public class ShowSignServiceImpl implements ShowSignService {

	@Autowired
	ShowSignDAO dao;

	@Override
	public List<ShowSign> selectAll() {
		List<ShowSign> list = dao.selectAll();
		return list;
	}

	@Override
	public ShowSign selectOne(int seq) {
		ShowSign showsign = dao.selctOne(seq);
		return showsign;
	}

	@Override
	public boolean insertShowSign(ShowSign showsign) {
		boolean result = dao.insertShowSign(showsign);
		return result;
	}

	@Override
	public boolean updateShowSign(ShowSign showsign) {
		boolean result = dao.updateShowSign(showsign);
		return result;
	}

	@Override
	public boolean deleteShowSign(int seq) {
		boolean result = dao.deleteShowSign(seq);
		return result;
	}

	@Override
	public List<ShowSign> selectAllByGroup(PageNavigator page, ShowSign showsign) {
		RowBounds rb = new RowBounds(page.getStartRecord(), page.getCountPerPage());
		List<ShowSign> list = dao.selectAllByGroup(showsign, rb);
		return list;
	}

	@Override
	public PageNavigator getPageNavigator(int pagePerGroup, int countPerPage, int page, ShowSign showSign) {
		int total = dao.countAllByGroup(showSign);
		PageNavigator result = new PageNavigator(pagePerGroup, countPerPage, page, total);
		return result;
	}
	
	
}
