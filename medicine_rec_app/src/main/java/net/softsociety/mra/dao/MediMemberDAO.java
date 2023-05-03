package net.softsociety.mra.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.mra.vo.MediMember;

@Mapper
public interface MediMemberDAO {

	List<MediMember> selectAll();

	MediMember selectOne(int seq);

	int insertMember(MediMember member);

	int updateMember(MediMember member);

	int delteMember(int seq);

	MediMember selectOneById(String username);

	boolean selectOneDuplicated(String id);

}
