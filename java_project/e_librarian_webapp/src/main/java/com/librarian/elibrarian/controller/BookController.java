package com.librarian.elibrarian.controller;

import com.librarian.elibrarian.dao.BooksDao;
import com.librarian.elibrarian.model.Books;
import com.librarian.elibrarian.model.IssueBooks;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/Books")
public class BookController {

    @GetMapping("AddBook")
    public String addBookPage() {
        return "add-book";
    }

    @PostMapping("AddBook")
    public String addBook(@RequestParam("book_callno") String callNo,
                          @RequestParam("book_name") String bookName,
                          @RequestParam("book_author") String author,
                          @RequestParam("book_publisher") String publisher,
                          @RequestParam("book_quantity") int bookQuantity,
                          RedirectAttributes redirectAttributes) {

        Books book = new Books(callNo, bookName, author, publisher, bookQuantity);
        int saveStatus = BooksDao.save(book);

        if (saveStatus > 0) {
            redirectAttributes.addAttribute("status", "createSuccess");
        } else {
            redirectAttributes.addAttribute("status", "createFailed");
        }

        return "redirect:/Books/ViewBook";
    }

    @GetMapping("IssueBook")
    public String issueBookPage(@RequestParam(value = "status", required = false) String status, Model model) {

        if(status != null) {
            if(status.equals("issueSuccess")) {
                model.addAttribute("successStatus", "Book issue success.");
            } else {
                model.addAttribute("failStatus", "Book issue failed.");
            }
        }

        return "issue-book";
    }

    @PostMapping("IssueBook")
    public String issueBook(@RequestParam("book_callno") String callNo,
                            @RequestParam("student_id") String studentId,
                            @RequestParam("student_name") String studentName,
                            @RequestParam("student_phone") String studentPhone,
                            RedirectAttributes redirectAttributes) {

        IssueBooks bookIssue = new IssueBooks(callNo, studentId, studentName, studentPhone);
        int issueStatus = BooksDao.issueBook(bookIssue);

        if (issueStatus > 0) {
            redirectAttributes.addAttribute("status", "issueSuccess");
        } else {
            redirectAttributes.addAttribute("status", "issueFailed");
        }
        return "redirect:/Books/IssueBook";
    }

    @GetMapping("ReturnBook")
    public String returnBookPage(@RequestParam(value = "status", required = false) String status, Model model) {
        if(status != null) {
            if(status.equals("returnSuccess")) {
                model.addAttribute("successStatus", "Book return success.");
            } else {
                model.addAttribute("failStatus", "Book return failed.");
            }
        }

        return "return-book";
    }

    @PostMapping("ReturnBook")
    public String returnBook(@RequestParam("book_callno") String callNo,
                             @RequestParam("student_id") String studentId,
                             RedirectAttributes redirectAttributes) {

        int returnStatus = BooksDao.returnBook(callNo, studentId);
        if (returnStatus > 0) {
            redirectAttributes.addAttribute("status", "returnSuccess");
        } else {
            redirectAttributes.addAttribute("status", "returnFailed");
        }

        return "redirect:/Books/ReturnBook";
    }

    @GetMapping("ViewBook")
    public String viewBookPage(@RequestParam(value = "status", required = false) String status, Model model) {

        if (status != null) {
            switch (status) {
                case "createSuccess" -> {
                    model.addAttribute("successStatus", "Create book success.");
                }
                case "createFailed" -> {
                    model.addAttribute("failStatus", "Create book failed.");
                }
                case "deleteSuccess" -> {
                    model.addAttribute("successStatus", "Delete book success.");
                }
                case "deleteFailed" -> {
                    model.addAttribute("failStatus", "Delete book failed.");
                }
                default -> {
                }
            }
        }

        List<Books> bookList = BooksDao.view();
        if (bookList != null && !bookList.isEmpty()) {
            model.addAttribute("books", bookList);
        } else {
            model.addAttribute("books", null);
        }

        return "view-book";
    }

    @GetMapping("ViewIssuedBook")
    public String viewIssueBookPage(Model model) {
        List<IssueBooks> bookList = BooksDao.viewIssueBooks();

        if(bookList != null & !bookList.isEmpty()) {
            model.addAttribute("issueBooks", bookList);
        } else {
            model.addAttribute("issueBooks", bookList);
        }

        return "view-issue-book";
    }

    @GetMapping("DeleteBook")
    public String deleteBook(@RequestParam("callno") String callNo, RedirectAttributes redirectAttributes) {
        int status = BooksDao.delete(callNo);

        if (status > 0) {
            redirectAttributes.addAttribute("status", "deleteSuccess");
        } else {
            redirectAttributes.addAttribute("status", "deleteFailed");
        }

        return "redirect:/Books/ViewBook";
    }
}
