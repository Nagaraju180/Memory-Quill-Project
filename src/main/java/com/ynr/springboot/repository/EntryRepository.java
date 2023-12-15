package com.ynr.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ynr.springboot.entities.Entry;

public interface EntryRepository extends JpaRepository<Entry, Integer> {

	@Query(value = "select * from entries where userid=:id",nativeQuery = true)
	public List<Entry> findByUserid(int id);
}
