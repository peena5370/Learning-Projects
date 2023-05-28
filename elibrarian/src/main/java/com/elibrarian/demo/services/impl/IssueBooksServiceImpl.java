package com.elibrarian.demo.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elibrarian.demo.model.BooksEntity;
import com.elibrarian.demo.model.IssueBooksEntity;
import com.elibrarian.demo.repos.BooksRepository;
import com.elibrarian.demo.repos.IssueBooksRepository;
import com.elibrarian.demo.services.IssueBooksService;

@Service
public class IssueBooksServiceImpl implements IssueBooksService {
	
	@Autowired
	private BooksRepository booksRepository;
	
	@Autowired
	private IssueBooksRepository issueBooksRepository;
	
	@Override
	public IssueBooksEntity issueBook(IssueBooksEntity issueBook) {
		Optional<BooksEntity> book = booksRepository.findById(issueBook.getBooks().getBook_id());
		IssueBooksEntity savedEntity = null;
		if(book.isPresent()) {
			BooksEntity bookEntity = book.get();
			if(bookEntity.getBookissued() >= bookEntity.getBookquantity()) {
				throw new RuntimeException();
			} else {
				bookEntity.setBookissued(bookEntity.getBookissued() + 1);
				booksRepository.save(bookEntity);
				
				savedEntity = issueBooksRepository.save(issueBook);
			}
		}

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
		Optional<BooksEntity> book = booksRepository.findById(issueBook.getBooks().getBook_id());
		IssueBooksEntity updatedEntity = null;
		
		if(book.isPresent()) {
			BooksEntity bookEntity = book.get();
			if(bookEntity.getBookissued()==0) {
				throw new RuntimeException();
			} else {
				bookEntity.setBookissued(bookEntity.getBookissued() - 1);
				booksRepository.save(bookEntity);

				updatedEntity = issueBooksRepository.save(issueBook);
			}
		}
		
		return updatedEntity;
	}
}
