package com.thejoa703.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thejoa703.domain.DeptUser;

public interface DeptUserRepository extends JpaRepository<DeptUser, Long> { 
}
