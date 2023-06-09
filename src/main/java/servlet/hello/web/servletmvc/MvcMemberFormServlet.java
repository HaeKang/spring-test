package servlet.hello.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";

        // 다른 서블릿이나 jsp로 이동 -> 서버 내부에서 다시 호출이 발생
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(viewPath);
        requestDispatcher.forward(req, resp);

    }
}
