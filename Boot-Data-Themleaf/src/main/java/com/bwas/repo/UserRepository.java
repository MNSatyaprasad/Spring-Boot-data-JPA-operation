package com.bwas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bwas.entity.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Long> {

}
