package com.training.helloworld;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/hello")
public class HelloController {

    public HelloController()
    {
        log.debug("HelloController Instantiated");
    }
    @GetMapping(produces = "application/json")
    public Map<String , Object> handleGetHelloMessage(
            @RequestParam(required = false, defaultValue = "friend" ) String name
    )
    {
        log.debug("Got Request Paramater name as " + name);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("timestamp", new Date());
        map.put("success", true);
        map.put("message", String.format("Hello, %s", name));

        log.debug("Returning the map as {}", map);
        return map;

    }
}
