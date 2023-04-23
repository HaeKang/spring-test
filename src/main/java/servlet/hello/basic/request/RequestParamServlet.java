package servlet.hello.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 1. 파라미터 전송 기능
* request-param?username=hello&age=20
* */
@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RequestParamServlet.service");

        System.out.println("[전체 파라미터 조회] - start");
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println("request = " + request.getParameter("name")));
        System.out.println("[전체 파라미터 조회] - end");

        System.out.println();

        System.out.println("[단일 파라미터 조회] - start");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("[단일 파라미터 조회] - end");

        // getParameter()는 하나의 값만 있을 때만 사용 ~ 첫번째 값만 가져옴
        // 중복이 있을때는 getParameterValues() 사용
        System.out.println("[이름이 같은 복수 파라미터 조회] - start ");
        System.out.println("[request-param?username=hello&age=20?username=hello2]");
        String[] usernames = request.getParameterValues("username");
        for(String name : usernames){
            System.out.println("name = " + name);
        }
        System.out.println("[이름이 같은 복수 파라미터 조회] - end");

        System.out.println("");

        request.getParameterNames();
    }
}
