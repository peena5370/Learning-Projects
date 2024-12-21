package com.librarian.elibrarian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.librarian.elibrarian.dao.BooksDao;
import com.librarian.elibrarian.model.Books;

@SuppressWarnings("serial")
public class AddBook extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String title = "Add Book Form";
		String header = "<!DOCTYPE html>"
					  + "<head>\r\n"
					  + "  <meta charset='utf-8'>\r\n"
					  + "  <meta name='viewport' content='width=device-width, initial-scale=1'>\r\n"
					  + "  <title>" + title + "</title>\r\n"
					  + "  <link rel='stylesheet' type='text/css' href='resources/css/bootstrap.min.css'/>\r\n"
					  + "  <link rel='stylesheet' type='text/css' href='resources/css/main.css'/>\r\n"
					  + "</head>\r\n\n"
					  + "<body>";
		out.println(header);
		request.getRequestDispatcher("/WEB-INF/views/navigation/librarian-nav.html").include(request, response);
		out.println("<div class='container'>");
		
		request.getRequestDispatcher("/WEB-INF/views/form/addBook.html").include(request, response);
		
		out.println("</div>");
		request.getRequestDispatcher("/WEB-INF/views/navigation/footer.html").include(request, response);
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String title = "Add Book Form";
		String header = "<!DOCTYPE html>"
					  + "<head>\r\n"
					  + "  <meta charset='utf-8'>\r\n"
					  + "  <meta name='viewport' content='width=device-width, initial-scale=1'>\r\n"
					  + "  <title>" + title + "</title>\r\n"
					  + "  <link rel='stylesheet' type='text/css' href='resources/css/bootstrap.min.css'/>\r\n"
					  + "  <link rel='stylesheet' type='text/css' href='resources/css/main.css'/>\r\n"
					  + "</head>\r\n\n"
					  + "<body>";
		out.println(header);
		request.getRequestDispatcher("/WEB-INF/views/navigation/librarian-nav.html").include(request, response);
		out.println("<div class='container'>");
		
		String callno = request.getParameter("book_callno");
		String bookname = request.getParameter("book_name");
		String author = request.getParameter("book_author");
		String publisher = request.getParameter("book_publisher");
		String str_quantity = request.getParameter("book_quantity");
		int quantity = Integer.parseInt(str_quantity);
		
		Books book = new Books(callno, bookname, author, publisher, quantity);
		int save_status = BooksDao.save(book);
		if(save_status > 0) {
			out.println("<script type='text/javascript'>");
		    out.println("alert('Successful added new book.');");
		    out.println("</script>");
		} else {
			out.println("<script type='text/javascript'>");
		    out.println("alert('Failed to add the book.');");
		    out.println("</script>");
		}
		request.getRequestDispatcher("/WEB-INF/views/form/addBook.html").include(request, response);
		
		out.println("</div>");
		request.getRequestDispatcher("/WEB-INF/views/navigation/footer.html").include(request, response);
		out.close();
	}
}
