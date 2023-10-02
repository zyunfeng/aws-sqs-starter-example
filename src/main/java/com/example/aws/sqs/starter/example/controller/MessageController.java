package com.example.aws.sqs.starter.example.controller;

import com.example.aws.sqs.starter.example.dto.MessageDto;
import com.example.starter.aws.sqs.client.AwsSqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("message")
public class MessageController {

    private final AwsSqsTemplate myQueueTestAwsSqsTemplate;

    @Autowired
    public MessageController(AwsSqsTemplate myQueueTestAwsSqsTemplate) {
        this.myQueueTestAwsSqsTemplate = myQueueTestAwsSqsTemplate;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void send(@RequestBody MessageDto messageDto) {
        myQueueTestAwsSqsTemplate.sendMessage(messageDto.getBody());
    }
}
