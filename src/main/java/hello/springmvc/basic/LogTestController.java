package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

//    @Slf4j 이걸 쓰면 아래에 있는 코드를 생략해도 된다.
//    로깅 프레임워크인 SLF4J (Simple Logging Facade for Java)에서 로거 객체를 생성
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name);

        //로그의 레벨을 지정할 수 있다.
        //application.properties 에서 어디까지 볼지 설정
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info(" info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
