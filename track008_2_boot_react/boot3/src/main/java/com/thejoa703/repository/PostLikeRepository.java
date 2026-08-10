package com.thejoa703.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.PostLike;

import jakarta.transaction.Transactional;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike, Long>{
	// 특정 게시글의 좋아요 수 집계(countBy)
	long countByPostId(Long postId);
	
	// 특정 유저가 특정게시글에 좋아요 했는지 AppUser user 필드와 Post post 각각의 id가 있는지 확인
	long countByUser_IdAndPost_Id(Long userId, Long postId);
	
	// 특정유저가 특정게시글에 좋아요 했는지 조회
//	boolean existsByUser_IdAndPost_Id(Long userId, Long postId);
	Optional<PostLike> findByUser_IdAndPost_Id(Long userId, Long postId);
	
	// 좋아요취소
	// 방법1: long deleteByUser_idPost_Id(Long userId, Long postId); -> select (데이터베이스 조회) delete(개별삭제)
	// 방법2: @Query(select 조회용도) -> db 가서 바로 delete
	// Insert/Update/Delete @Modifying @Transactional
	// DELETE FROM PostLike pl WHERE pl.user.id = :userId AND pl.post.id = :postId;
	
	@Modifying // 조회가 아니라 update, delete 용도에요
	@Transactional
	@Query("DELETE FROM PostLike pl WHERE pl.user.id = :userId AND pl.post.id = :postId")
	void deleteByUser_IdAndPost_id(@Param("userId") Long userId, @Param("postId") Long postId);
}
