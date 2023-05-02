package net.softsociety.mra.service;

import java.util.List;

import net.softsociety.mra.util.PageNavigator;
import net.softsociety.mra.vo.ShowSign;

public interface ShowSignService {

	List<ShowSign> selectAll();

	ShowSign selectOne(int seq);

	boolean insertShowSign(ShowSign showsign);

	boolean updateShowSign(ShowSign showsign);

	boolean deleteShowSign(int seq);

	List<ShowSign> selectAllByGroup(PageNavigator result, ShowSign showsign);

	PageNavigator getPageNavigator(int pagePerGroup, int countPerPage, int page, ShowSign showSign);

}
