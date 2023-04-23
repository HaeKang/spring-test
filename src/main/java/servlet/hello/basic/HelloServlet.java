package servlet.hello.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// name : 서블릿 이름
// urlPatterns : URL 매핑
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    // 서블릿 호출 시 서비스 호출됨
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request); // 단축키 soutv
        System.out.println("response = " + response);

        // query 파라미터
        String username = request.getParameter("username"); // ctrl + alt + v
        System.out.println("username = " + username);

        response.setContentType("text/plain");  // header
        response.setCharacterEncoding("utf-8"); // header
        response.getWriter().write("hello " + username);

    }
}
