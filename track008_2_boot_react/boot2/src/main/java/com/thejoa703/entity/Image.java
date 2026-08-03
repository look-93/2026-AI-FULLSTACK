package com.thejoa703.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="Images")
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_seq")
	@SequenceGenerator(name="image_seq", sequenceName = "IMAGE_SEQ", allocationSize = 1)
	private Long id;
	
	@Column(length = 200, nullable = false)
	private String src;
	
	//한 글은 여러 이미지를 갖는다.
	@ManyToOne
	@JoinColumn(name="POST_ID", nullable = false) // POST_ID 외래키(FK) POST 엔터티의 id값 참조
	private Post post;
}
