package com.mq.activemqpool.service;

import javax.jms.Destination;

public interface ProcedureService {

    void sendMessage(Destination destination, String message);


    void publish(String msg);

}

