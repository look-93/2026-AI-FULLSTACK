package com.thejoa703.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="DEPTUSER")
public class DeptUser {
	
	@Id
	private Long deptno;
	private String dname;
	private String loc;
}
