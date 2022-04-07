package hello.springmvc.basic.httpMessagConverter;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@Controller
public class HttpMessageConverterController {

    @ResponseBody
    @RequestMapping("/hmc-v1")
    public String jsonToStringConverting(@RequestBody String data) {
        log.info("jsonToStringConverting={}", data);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/hmc-v2")
    public String htmlToJsonConverting(@RequestBody HelloData data) {
        log.info("htmlToJsonConverting={}", data);
        return "OK";
    }
}
