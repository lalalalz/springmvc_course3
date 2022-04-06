package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Slf4j
@Controller
@RestController
public class RequestParamController {

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam String username,
            @RequestParam int age) {

        log.info("username={}", username);
        log.info("age={}", age);

        return "OK";
    }


    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age
    ) {
        log.info("username={}", username);
        log.info("age={}", age);

        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(
            String username,
            int age
    ) {
        log.info("username={}", username);
        log.info("age={}", age);

        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) int age
    ) {
        log.info("username={}", username);
        log.info("age={}", age);

        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(defaultValue = "lalalalz") String username,
            @RequestParam(defaultValue = "20") int age
    ) {
        log.info("username={}", username);
        log.info("age={}", age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(
            @RequestParam Map<String, String> paramMap
    ) {

        log.info("paramMap={}", paramMap);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("modelAttributeV1={}", helloData);
        return "OK";
    }


    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("modelAttributeV2={}", helloData);
        return "OK";
    }
}
