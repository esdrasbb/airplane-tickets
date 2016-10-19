package org.fa7.controller;

import org.fa7.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private ReservaService reservaService;

    @RequestMapping("/ping")
    public String ping() {
        reservaService.validate();
        return "pong";
    }
}

