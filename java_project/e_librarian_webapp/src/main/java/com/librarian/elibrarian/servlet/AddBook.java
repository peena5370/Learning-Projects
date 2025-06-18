package com.librarian.elibrarian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.librarian.elibrarian.dao.BooksDao;
import com.librarian.elibrarian.model.Books;

@WebServlet("/AddBook")
public class AddBook extends HttpServlet {

    private static String getHeaderString() {
        String title = "Add Book Form";

        return "<!DOCTYPE html>"
                + "<head>\r\n"
                + "  <meta charset='utf-8'>\r\n"
                + "  <meta name='viewport' content='width=device-width, initial-scale=1'>\r\n"
                + "  <title>" + title + "</title>\r\n"
                + "  <link rel='stylesheet' type='text/css' href='resources/css/bootstrap.min.css'/>\r\n"
                + "  <link rel='stylesheet' type='text/css' href='resources/css/main.css'/>\r\n"
                + "</head>\r\n\n"
                + "<body>";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println(getHeaderString());

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

        out.println(getHeaderString());

        request.getRequestDispatcher("/WEB-INF/views/navigation/librarian-nav.html").include(request, response);
        out.println("<div class='container'>");

        String callNo = request.getParameter("book_callno");
        String bookName = request.getParameter("book_name");
        String bookAuthor = request.getParameter("book_author");
        String bookPublisher = request.getParameter("book_publisher");
        String bookQuantity = request.getParameter("book_quantity");
        int quantity = Integer.parseInt(bookQuantity);

        Books book = new Books(callNo, bookName, bookAuthor, bookPublisher, quantity);
        int saveStatus = BooksDao.save(book);

        if (saveStatus > 0) {
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
