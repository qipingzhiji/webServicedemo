package com.mq.activemqpool.controller;

import com.mq.activemqpool.service.ProcedureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
public class OrderController {

    @Autowired
    private ProcedureServiceImpl procedureService;

    @Autowired
    @Qualifier(value = "queue")
    private Queue queue;

    @GetMapping("order")
    public String getOrder(String msg) {
        procedureService.sendMessage(queue, msg);
        return "success";
    }

    @GetMapping("publish")
    public String pabSub(String msg) {
        procedureService.publish(msg);
        return "publish success";
    }


}
