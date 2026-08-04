package com.thejoa703.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Follow;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long>{
	// 팔로우 단건조회 - 팔로워/팔로위 findBy
	Optional<Follow> findByFollower_IdAndFollowee_Id (Long followerId, Long followeeId);
	
	// 팔로잉 목록조회 findBy
	// 1) 쿼리1개   : follower_Id(1L) 팔로잉 목록10명   1 
	// 2) 추가쿼리10 : 각각의 정보를 가져오려면 쿼리 10번더   M (11번의 쿼리) -> 11번의 쿼리 실행안하려고
	// @EntityGraph(attributePaths = {"followee"}) //진짜 속도 너무 느려요/ 쿼리실행할때 follwee 데이터까지 한꺼번에 조회해주세요
	@EntityGraph(attributePaths = {"followee"}) // 연관된 내용까지 가져와주세요
	List<Follow> findByFollower_Id(Long followerId);
	
	// 팔로워 목록 조회 findBy
	@EntityGraph(attributePaths = {"follower"})
	List<Follow> findByFollowee_Id(Long followeeId);
	
	// 팔로잉 수 집계 countBy
	long countByFollower_Id(Long followerId);

	// 팔로워 수 집계 countBy
	long countByFollowee_Id(Long followeeId);
}
