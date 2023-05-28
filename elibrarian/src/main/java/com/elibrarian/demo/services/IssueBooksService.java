package com.elibrarian.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.elibrarian.demo.model.IssueBooksEntity;

public interface IssueBooksService {
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	IssueBooksEntity issueBook(IssueBooksEntity issueBook);
	
	List<IssueBooksEntity> viewIssueBooks();
	
	Optional<IssueBooksEntity> viewIssueBookById(Integer issueid);
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	IssueBooksEntity returnBook(IssueBooksEntity issueBook);
}
