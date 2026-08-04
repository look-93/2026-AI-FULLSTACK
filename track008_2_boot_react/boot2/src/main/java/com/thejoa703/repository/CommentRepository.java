package com.thejoa703.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	// SELECT c FROM Comment WHERE c c.post.id = :postId AND c.deleted = false
	// @ManyToOnt - post가 1개여서 join 쿼리를 만들어줌
	List<Comment> findByPostIdAndDeletedFalse(Long postId);
	
	// 삭제되지 않은 댓글 수 집계
	long countByPostIdAndDeletedFalse(Long postId);
}
