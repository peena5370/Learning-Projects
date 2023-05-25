package com.elibrarian.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elibrarian.demo.model.IssueBooksEntity;
import com.elibrarian.demo.repos.IssueBooksRepository;
import com.elibrarian.demo.services.IssueBooksService;

@Service
public class IssueBooksServiceImpl implements IssueBooksService {
	
	@Autowired
	private IssueBooksRepository issueBooksRepository;

	@Override
	public IssueBooksEntity issueBook(IssueBooksEntity issueBook) {
		IssueBooksEntity savedEntity = issueBooksRepository.save(issueBook);
		issueBooksRepository.flush();
		
		return savedEntity;
	}

	@Override
	public List<IssueBooksEntity> viewIssueBooks() {
		return issueBooksRepository.findAll();
	}

	@Override
	public Optional<IssueBooksEntity> viewIssueBookById(Integer issueid) {
		return issueBooksRepository.findById(issueid);
	}

	@Override
	public IssueBooksEntity  returnBook(IssueBooksEntity issueBook) {
		IssueBooksEntity updatedEntity = issueBooksRepository.save(issueBook);
		issueBooksRepository.flush();
		
		return updatedEntity;
	}
}
