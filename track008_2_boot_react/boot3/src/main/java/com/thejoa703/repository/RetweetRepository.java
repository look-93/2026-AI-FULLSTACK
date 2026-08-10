package com.thejoa703.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Post;
import com.thejoa703.entity.Retweet;

@Repository
public interface RetweetRepository extends JpaRepository<Retweet, Long>{
	// 특정유저(AppUser user)가 특정게시글(Post originalPost) 리트윗 단건조회  findBy
	Optional<Retweet> findByUser_IdAndOriginalPost_Id(Long userId, Long postId);
	
	// 중복방지옹: 집계 - 특정유저(AppUser user) 특정게시글(Post originalPost) 리트윗 countBy
	long countByUser_IdAndOriginalPost_id(Long userId, Long postId);
	
	// 리트윗취소 : 특정유저(AppUser user) 특정게시글(Post originalPost) 취소 deleteBy
	//@Modifying
	//@Transactional
	//@Query("DELETE FROM Retweet r WHERE r.user.id = :userId AND r.originalPost.id = :postId")
	//void deleteByUser_IdAndOriginalPost_Id(@Param("userId") Long userId, @Param("postId") Long postId);
	void deleteByUser_IdAndOriginalPost_Id(Long userId, Long postId);
	
	// 특정게시글 : (Post originalPost) 리트윗 수 집계 : countBy , long
	long countByOriginalPost_Id(Long postId);
	
	//find 찾을필드 By가 오면 조건(where )
	// 특정유저 리트윗한글 id 목록 조회 @Query
	//"SELECT r.originalPost.id FROM Retweet r WHERE r.user.id = :userId"
	@Query("SELECT r.originalPost.id FROM Retweet r WHERE r.user.id = :userId")
	List<Long> findOriginalPostIdByUserId(@Param("userId") Long userId);
	
	//내가 리트윗 한 글 페이징조회
	/* @Query
		"SELECT po.* FROM POSTS po " +
              "WHERE po.ID IN ( " +
              "    SELECT DISTINCT r.ORIGINAL_POST_ID " +
              "    FROM RETWEETS r " +
              "    WHERE r.APP_USER_ID = :userId " +
              ") AND po.DELETED = 0 " +
              "ORDER BY po.CREATED_AT DESC " +
              "OFFSET :offset ROWS FETCH FIRST :size ROWS ONLY"  
	 */
	@Query(
	value = "SELECT po.* FROM POSTS po " +
            "WHERE po.ID IN ( " +
            "    SELECT DISTINCT r.ORIGINAL_POST_ID " +
            "    FROM RETWEETS r " +
            "    WHERE r.APP_USER_ID = :userId " +
            ") AND po.DELETED = 0 " +
            "ORDER BY po.CREATED_AT DESC " +
            "OFFSET :offset ROWS FETCH FIRST :size ROWS ONLY",
            nativeQuery = true
			) List<Post> findRetweetPostsWithPaging(@Param("userId") Long userId,
													@Param("offset") int offset,@Param("size") 	 int size);
}
