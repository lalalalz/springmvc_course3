package hello.springmvc.basic.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStringController {

    @RequestMapping("/request-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream, Writer writer) throws IOException {

        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("requestBodyStringV2={}", messageBody);

        writer.write("OK");
    }


    @RequestMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) {
        String messageBody = httpEntity.getBody();
        log.info("requestBodyStringV3={}", messageBody);
        return new HttpEntity<>("OK");
    }

    @ResponseBody
    @RequestMapping("/request-body-string-v4")
    public String requestBodyStringV4(@RequestBody String messageBody) {
        log.info("requestBodyStringV4={}", messageBody);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-body-json-v2")
    public String requestBodyJsonV2(@RequestBody String messageBody) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);

        log.info("requestBodyJsonV2={}", helloData);

        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-body-json-v3")
    public String requestBodyJsonV3(@RequestBody HelloData helloData) {

        log.info("requestBodyJsonV3={}", helloData);
        return "OK";
    }

    @RequestMapping("/request-body-json-v4")
    public HttpEntity<String> requestBodyJsonV4(HttpEntity<HelloData> httpEntity) {
        HelloData helloData = httpEntity.getBody();
        log.info("requestBodyJsonV4={}", helloData);
        return new HttpEntity<>("OK");
    }


    @ResponseBody
    @RequestMapping("/request-body-json-v5")
    public HelloData requestBodyJsonV5(@RequestBody HelloData helloData) {
        log.info("requestBodyJsonV5={}", helloData);
        return helloData;
    }
}
