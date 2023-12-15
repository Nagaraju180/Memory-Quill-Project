package com.ynr.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynr.springboot.entities.Entry;
import com.ynr.springboot.repository.EntryRepository;

@Service
public class EntryServiceImpl implements EntryService {

	@Autowired
	private EntryRepository entryRepository;
	
	
	public EntryRepository getEntryRepository() {
		return entryRepository;
	}

	public void setEntryRepository(EntryRepository entryRepository) {
		this.entryRepository = entryRepository;
	}

	@Override
	public Entry saveEntry(Entry entry) {
		return entryRepository.save(entry);
	}

	@Override
	public Entry updateEntry(Entry entry) {
		return entryRepository.save(entry);
	}

	@Override
	public void deleteEntry(Entry entry) {
		entryRepository.delete(entry);
	}

	@Override
	public Entry findById(int id) {
		return entryRepository.findById(id).get();
	}

	@Override
	public List<Entry> findAllEntrys() {
		return entryRepository.findAll();
	}

	@Override
	public List<Entry> findByUserid(int id) {
		
		return entryRepository.findByUserid(id);
	}

}
