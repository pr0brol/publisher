package com.example;

import com.example.generator.Generator;
import com.example.sender.MessageSender;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PublisherApplication {
    private static final int MAX_COUNT_MESSAGE = 3;   //количество сообщений для каждого потока
    private static final long MAX_SLEEP_TIME = 2000L;   //время сна
    private static final int MAX_COUNT_THREAD = 3;      //количество потоков

    public static void main(String[] args) {


        MessageSender sender = new MessageSender();
        Generator generator = new Generator();

        sender.init();
        generator.init();

        ExecutorService service = Executors.newFixedThreadPool(MAX_COUNT_THREAD);

        for (int i = 0; i < MAX_COUNT_THREAD; i++) {
            service.submit(() -> sendMessageInThread(sender, generator));
        }
        service.shutdown();
    }

    private static void sendMessageInThread(MessageSender sender, Generator generator) {
        int count = MAX_COUNT_MESSAGE;
        try {
            while (count > 0) {
                sender.sendMessage(generator.generate());
                Thread.sleep(MAX_SLEEP_TIME);
                count--;
            }
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.out.println("при отправке сообщения произошла ошибка: " + e.getMessage());
        }
    }
}
