package com.elibrarian.demo.services;

import java.util.List;
import java.util.Optional;

import com.elibrarian.demo.model.IssueBooksEntity;

public interface IssueBooksService {
	IssueBooksEntity issueBook(IssueBooksEntity issueBook);
	
	List<IssueBooksEntity> viewIssueBooks();
	
	Optional<IssueBooksEntity> viewIssueBookById(Integer issueid);
	
	IssueBooksEntity returnBook(IssueBooksEntity issueBook);
}
