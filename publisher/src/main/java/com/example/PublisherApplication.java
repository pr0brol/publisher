package com.example;

import com.example.generator.Generator;
import com.example.sender.MessageSender;

public class PublisherApplication {
    public static void main(String[] args) {
        MessageSender sender = new MessageSender();
        Generator generator = new Generator();

        sender.init();
        generator.init();

        for (int i = 0; i < 10; i++) {
            sender.sendMessage(generator.generate());
        }

    }
}
