package com.semi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.semi.domain.Member;

public interface JpaMemberRepository extends JpaRepository<Member, Long>{
	
	@Query(value = "SELECT * FROM MEMBER WHERE ID = 1", nativeQuery = true)
	List<Member> findNames();

}
