package servlet.hello.web.frontcontroller.v5;

import servlet.hello.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {
    // 어댑터 존재 여부
    boolean supports(Object handler);

    // 핸들러 호출
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException, ServletException;
}
