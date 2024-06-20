package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String userName,
            @RequestParam("age") int memberAge
    ){
        log.info("username={}, age={}", userName, memberAge);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age
    ){
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("request-param-v4")
    public String requestParamV4(String username, int age){
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age){

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    //defaultValue 가 들어가면 required 값을 설정해줄 필요가 없다.
    //빈문자에 대해서도 default 값을 처리해준다.
    @ResponseBody
    @RequestMapping("request-param-default")
    public String requestParamDefault(
            @RequestParam(defaultValue = "guest") String username,
            @RequestParam(defaultValue = "-1") int age){

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

//    @ResponseBody
//    @RequestMapping("model-attribute-v1")
//    public String modelAttribute(@RequestParam String username, @RequestParam int age){
//
//        HelloData helloData = new HelloData();
//        helloData.setUsername(username);
//        helloData.setAge(age);
//
//        log.info("username={}, age={}",helloData.getUsername(), helloData.getAge());
//
//        //@Date 에 포함된 ToString 이 자동으로 만들어준다.
//        log.info("helloData={}", helloData);
//        return "ok";
//    }

    @ResponseBody
    @RequestMapping("model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
        log.info("username={}, age={}",helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    @ResponseBody
    @RequestMapping("model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){
        log.info("username={}, age={}",helloData.getUsername(), helloData.getAge());
        return "ok";
    }
}
