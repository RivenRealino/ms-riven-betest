package com.betest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.betest.entity.Betest;

public interface BetestRepository extends JpaRepository<Betest,String> {
	
	public Optional<Betest> findById(String id);
	
	@Transactional
	public void deleteById(String id);
}
