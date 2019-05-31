package com.mq.activemqpool.controller;

import com.mq.activemqpool.config.ActiveMqProperties;
import com.mq.activemqpool.service.ProcedureService;
import com.mq.activemqpool.service.impl.ProcedureServiceImpl;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
public class OrderController {

    @Autowired
    private ProcedureService procedureService;

    @Autowired
    private ActiveMqProperties activeMqProperties;

    @Autowired
    @Qualifier(value = "queue")
    private Queue queue;

    @GetMapping("order")
    public String getOrder(String msg) {
        System.out.println(activeMqProperties.toString());
        procedureService.sendMessage(queue, msg);
        return "success";
    }

    @GetMapping("publish")
    public String pabSub(String msg) {
        procedureService.publish(msg);
        return "publish success";
    }


}
