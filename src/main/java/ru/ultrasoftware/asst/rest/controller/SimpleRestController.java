package ru.ultrasoftware.asst.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ultrasoftware.asst.rest.domain.PingPong;

@RestController
@RequestMapping("/simple")
public class SimpleRestController {
    @GetMapping("/pingPong")
    public String pingPong(@RequestParam String ping) {
        return ping;
    }

    @PostMapping("/pingPong")
    public PingPong pingPong(@RequestBody PingPong ping) {
        return ping;
    }
}
