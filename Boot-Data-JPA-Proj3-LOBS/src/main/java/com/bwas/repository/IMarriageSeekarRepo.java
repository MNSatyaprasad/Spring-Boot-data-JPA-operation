package com.bwas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bwas.entity.MarriageSeeker;

public interface IMarriageSeekarRepo extends JpaRepository<MarriageSeeker, Integer>{

	Optional<MarriageSeeker> findByName(String name);
}