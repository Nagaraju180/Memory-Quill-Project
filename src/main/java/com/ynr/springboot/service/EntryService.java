package com.ynr.springboot.service;

import java.util.List;

import com.ynr.springboot.entities.Entry;

public interface EntryService {
  
	public Entry saveEntry(Entry entry);
	public Entry updateEntry(Entry entry);
	public void deleteEntry(Entry entry);
	public Entry findById(int id);
	public List<Entry> findAllEntrys();
	
	public List<Entry> findByUserid(int id);
}
