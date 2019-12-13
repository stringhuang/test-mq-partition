package com.zg.testmqpartition.controller;


import com.zg.testmqpartition.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenderController {

    @Autowired
    private SenderService senderService;

    @GetMapping("/send")
    public Boolean sendMsg(String msg) {
        return this.senderService.sendMsg(msg);
    }
}
