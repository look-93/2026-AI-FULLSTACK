package com.thejoa703.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Hashtag;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, Long>{
	@Query("SELECT h FROM Hashtag h JOIN FETCH h.posts WHERE h.name= :name")
	Optional<Hashtag> findByNameWithPosts(@Param("name") String name);
	
	// jpa 쿼리 메서드 사용 - findBy필드명
	Optional<Hashtag> findByName(String name);
}
