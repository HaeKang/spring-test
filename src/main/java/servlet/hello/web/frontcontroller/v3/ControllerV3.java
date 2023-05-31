package servlet.hello.web.frontcontroller.v3;

import servlet.hello.web.frontcontroller.ModelView;
import servlet.hello.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);

}
