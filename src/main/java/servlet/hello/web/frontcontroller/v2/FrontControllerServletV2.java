package servlet.hello.web.frontcontroller.v2;

import servlet.hello.web.frontcontroller.MyView;
import servlet.hello.web.frontcontroller.v1.ControllerV1;
import servlet.hello.web.frontcontroller.v1.controller.MemberFormControllerV1;
import servlet.hello.web.frontcontroller.v1.controller.MemberListControllerV1;
import servlet.hello.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import servlet.hello.web.frontcontroller.v2.controller.MemberFormControllerV2;
import servlet.hello.web.frontcontroller.v2.controller.MemberListControllerV2;
import servlet.hello.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// /front-controller/v2/* *파트에 어떤 url이 들어와도 이 컨트롤러 먼저 실행한다
@WebServlet(name="frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    // key : url
    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ControllerV2 controller = controllerMap.get(requestURI);

        if(controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView myView = controller.process(request, response);
        myView.render(request, response);
    }
}
