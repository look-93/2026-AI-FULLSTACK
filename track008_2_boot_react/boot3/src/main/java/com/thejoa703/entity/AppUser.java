package com.thejoa703.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
//@Table(name = "APP_USER")
public class AppUser {
	
	@Id // jakarta.persistence.Id;
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appuser_seq")
	@SequenceGenerator(name = "appuser_seq", sequenceName = "APPUSER_SEQ", allocationSize = 1) // allocationSize 하나씩 증가
	@Column(name="APP_USER_ID") // id명 바꾸려면
	private Long id;
	
	@Column(length = 120, nullable = false)
	private String email;
	
	@Column(length = 200, nullable = false)
	private String password;
	
	@Builder.Default
	@Column(length = 50, nullable = false)
	private String role="ROLE_USER"; // 기본 권한
	
	@Column(length = 150, nullable = false)
	private String provider="local";
	
	@Column(name="PROVIDER_ID", length = 150)
	private String providerId="local"; // kakao_id, naver_id
	
	@Column(length = 255)
	private String ufile;
	
	@Column(length = 50, nullable = false)
	private String nickname;
	
	@Column(length = 30)
	private String mobile;
	
	@Column(name="MBTI_TYPE_ID")
	private Integer mbtitype;
	
	@Column
	private Boolean deleted=false;
	
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
	
	//@Builder 사용하면 순서상관없이 호출 가능?
	public AppUser(String email, String password, String provider, String nickname) {
		super();
		this.email = email;
		this.password = password;
		this.provider = provider;
		this.nickname = nickname;
		this.role     = "ROLE_USER";
	}
	
	// ★한사람이 여러글을 쓸 수 있다.
	// 1. mappedBy = "appuser"  Post 엔티티에 있는 user 필드와 연결 - 읽기만 가능 / 수정x
	// 2. CascadeType.ALL : AppUser 변화(생성, 수정, 삭제 등)와 연결된 Post 에 반영 , 
	//    orphanRemoval=true : 유저탈퇴 시 글들이 깔끔하게 삭제  
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Post> posts = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PostLike> likes = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comments = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Retweet> retweets = new ArrayList<>();	
	
	@OneToMany(mappedBy = "follower", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Follow> following = new ArrayList<>();//내가 팔로우한 사람들	
	
	@OneToMany(mappedBy = "followee", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Follow> followers = new ArrayList<>(); 
}

//@ManyToOne 쪽 → @JoinColumn 사용
//@OneToMany 쪽 → mappedBy 사용
