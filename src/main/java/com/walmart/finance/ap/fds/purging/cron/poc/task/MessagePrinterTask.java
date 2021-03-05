package com.walmart.finance.ap.fds.purging.cron.poc.task;

import com.walmart.finance.ap.fds.purging.cron.poc.SchedulerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;

public class MessagePrinterTask implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger(MessagePrinterTask.class);

    private String message;

    public MessagePrinterTask(String message) {
        this.message = message;
    }

    public void run() {
        SchedulerFactory schedulerFactory = new SchedulerFactory();
        LOGGER.info(message.concat(" At time: {}"), LocalDateTime.now());
    }

}