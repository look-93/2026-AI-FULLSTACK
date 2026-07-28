package com.thejoa703.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter // @Builder
@Table(name = "POSTS")
public class Post {
	
	@Id // 기본키 primary 키 붙히기
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq")
	@SequenceGenerator(name="post_seq", sequenceName = "POST_SEQ", allocationSize = 1)
	private Long id;
	
	@Lob //대용량데이터처리 - CLOB(문자열), BLOB(이미지, 파일, 오디오, 영상...) : 들디 처리(Lob)
	@Column(nullable = false)
	private String content;
	
	@Column
	private boolean deleted = false;	
	
	@Column(name="CREATED_AT", nullable = false)
	private LocalDateTime createdAt;
	
	@Column(name="UPDATED_AT", nullable = false)
	private LocalDateTime updatedAt;
	
	@PrePersist
	void onCreate() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}
	
	@PreUpdate
	void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
	
	//한사람이 ★여러글을 쓸 수 있다.	
	@ManyToOne // 1. 다대일
	@JoinColumn(name="APP_USER_ID", nullable = false)
	private AppUser appuser;
}
