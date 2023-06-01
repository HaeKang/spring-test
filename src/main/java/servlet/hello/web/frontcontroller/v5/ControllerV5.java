package servlet.hello.web.frontcontroller.v5;

import java.util.Map;

public interface ControllerV5 {

    // /** + 엔터
    /**
     *
     * @param paramMap
     * @param model
     * @return
     */
    String process(Map<String, String> paramMap, Map<String, Object> model);

}
