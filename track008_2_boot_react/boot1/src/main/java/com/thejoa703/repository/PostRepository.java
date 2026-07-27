package com.thejoa703.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	List<Post> findByDeletedFalse(); //List<Post> - 결과가 여러개 일때: List
	
	// 비교 - 결과값이 1개이거나 없을때 (Optional)
	// Optional<AppUser> findByEmail(String email);
	
	//기존에 쓰던 쿼리 사용가능
	@Query(
			value="SELECT * FROM ( " +
	              "SELECT p.*, ROWNUM AS rnum " +
	              "FROM (SELECT * FROM POSTS WHERE DELETED = 0 ORDER BY CREATED_AT DESC) p " + 
	              ") " +
	              "WHERE rnum BETWEEN :start AND :end",
			nativeQuery=true
	)
	List<Post> findPostsWithPaging(@Param("start") int start, @Param("end") int end);
}

/* 
(1) 사용할 수 있는 기본 SQL
	1. CREATE : save - insert into posts(컬럼1, 컬럼2) values(?,?,,,)
	2. READ   : findAll - select * from posts
			    findById - select * from posts where id=?
	3. UPDATE : save - update posts set 컬럼1 =? where id=?
	4. DELETE : deleteById - delete from posts where id=?

(2) 삭제 안 된 게시글 찾기 findBy필드명
- List<Post> findByDeletedFalse();
(3) 복잡한 sql - @Query

*/