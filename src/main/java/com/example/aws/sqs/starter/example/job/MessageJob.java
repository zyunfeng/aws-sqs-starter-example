package com.example.aws.sqs.starter.example.job;

import com.example.starter.aws.sqs.client.AwsSqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.model.Message;

import java.util.List;

@Component
public class MessageJob {

    private final AwsSqsTemplate myQueueTestAwsSqsTemplate;

    @Autowired
    public MessageJob(AwsSqsTemplate myQueueTestAwsSqsTemplate) {
        this.myQueueTestAwsSqsTemplate = myQueueTestAwsSqsTemplate;
    }

    @Scheduled(cron = "0/10 * *  * * ?")
    public void handleMessage() {
        List<Message> messageList = myQueueTestAwsSqsTemplate.receiveMessages();
        for (Message message: messageList) {
            System.out.println(message.body());
            myQueueTestAwsSqsTemplate.deleteMessage(message);
        }
    }
}
