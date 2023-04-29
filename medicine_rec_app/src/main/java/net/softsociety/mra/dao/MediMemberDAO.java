package net.softsociety.mra.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.mra.vo.MediMember;

@Mapper
public interface MediMemberDAO {

	List<MediMember> selectAll();

	MediMember selectOne(int seq);

	boolean insertMember(MediMember member);

	boolean updateMember(MediMember member);

	boolean delteMember(int seq);

}
