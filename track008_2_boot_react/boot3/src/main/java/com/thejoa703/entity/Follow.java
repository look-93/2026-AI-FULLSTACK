package com.thejoa703.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="FOLLOWS", 
	   uniqueConstraints = @UniqueConstraint(columnNames = {"FOLLOWER_ID", "FOLLOWEE_ID"}))
public class Follow {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "follow_seq")
	@SequenceGenerator(name = "follow_seq", sequenceName = "FOLLOW_SEQ" ,allocationSize = 1)
	private Long id;
	
	@Column(name="CREATED_ID", nullable = false)
	private LocalDateTime createdAt;
	
	@ManyToOne(fetch = FetchType.LAZY) // 연관된 엔티티 당장가져오는게 아니고
	@JoinColumn(name="FOLLOWER_ID", nullable = false)
	private AppUser follower;
	
	@ManyToOne(fetch = FetchType.LAZY)// 실제 객체 사용하는 시점에서 쿼리 실행 , 불필요한 join 줄이기
	@JoinColumn(name="FOLLOWEE_ID", nullable = false)
	private AppUser followee;
}
