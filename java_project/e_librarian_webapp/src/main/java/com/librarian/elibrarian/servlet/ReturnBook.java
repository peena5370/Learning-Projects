package com.librarian.elibrarian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.librarian.elibrarian.dao.BooksDao;

@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {

    private static String getHeaderString() {
        String title = "Return Book Form Page";

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

        request.getRequestDispatcher("/WEB-INF/views/form/returnBook.html").include(request, response);

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
        String studId = request.getParameter("student_id");

        int returnStatus = BooksDao.returnBook(callNo, studId);
        if (returnStatus > 0) {
            out.println("<script type='text/javascript'>");
            out.println("alert('Book returned.');");
            out.println("location='ViewBook'");
            out.println("</script>");
        } else {
            out.println("<script type='text/javascript'>");
            out.println("alert('Unable to return the book.\nKindly check with administrator for further assistance.');");
            out.println("location='ReturnBook'");
            out.println("</script>");
        }

        out.println("</div>");
        request.getRequestDispatcher("/WEB-INF/views/navigation/footer.html").include(request, response);
        out.close();
    }

}
