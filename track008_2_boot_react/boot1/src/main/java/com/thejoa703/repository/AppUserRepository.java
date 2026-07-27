package com.thejoa703.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.AppUser;

@Repository												//Entity, PK-자료형
public interface AppUserRepository extends JpaRepository<AppUser, Long>{ //한줄만 적으면 알아서 생성,조회,삭제,업데이트 해줄게
	Optional<AppUser> findByEmail(String email);
}

//아래 코드 자동으로 들어가있음
// create - save: insert into app_user (컬럼) values(?,?,?)
// read	  - findByAll/findById : select * from app_user / select * from app_user where id=?
// update - save: update 테이블명 set 컬럼1=? where id=?
// delete - deleteById: delete from 테이블명 where id=?

/*
 1. 검색 : findBy필드명 
 
 */