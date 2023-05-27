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
				return null;
			} else {
				BooksEntity updateBookIssue = new BooksEntity();
				updateBookIssue.setBook_id(bookEntity.getBook_id());
				updateBookIssue.setCallno(bookEntity.getCallno());
				updateBookIssue.setBookname(bookEntity.getBookname());
				updateBookIssue.setAuthor(bookEntity.getAuthor());
				updateBookIssue.setBookquantity(bookEntity.getBookquantity());
				updateBookIssue.setBookissued(bookEntity.getBookissued() + 1);
				booksRepository.saveAndFlush(updateBookIssue);

				savedEntity = issueBooksRepository.save(issueBook);
				issueBooksRepository.flush();
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
				return null;
			} else {
				BooksEntity updateBookIssue = new BooksEntity();
				updateBookIssue.setBook_id(bookEntity.getBook_id());
				updateBookIssue.setCallno(bookEntity.getCallno());
				updateBookIssue.setBookname(bookEntity.getBookname());
				updateBookIssue.setAuthor(bookEntity.getAuthor());
				updateBookIssue.setBookquantity(bookEntity.getBookquantity());
				updateBookIssue.setBookissued(bookEntity.getBookissued() - 1);
				booksRepository.saveAndFlush(updateBookIssue);

				updatedEntity = issueBooksRepository.save(issueBook);
				issueBooksRepository.flush();
			}
		}
		
		return updatedEntity;
	}
}
