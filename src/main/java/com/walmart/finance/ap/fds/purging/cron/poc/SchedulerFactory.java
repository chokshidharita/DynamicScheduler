package com.walmart.finance.ap.fds.purging.cron.poc;

import com.walmart.finance.ap.fds.purging.cron.poc.model.entity.Domain;
import com.walmart.finance.ap.fds.purging.cron.poc.service.DomainService;
import com.walmart.finance.ap.fds.purging.cron.poc.task.MessagePrinterTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.TimeZone;

@Component
public class SchedulerFactory {

    private static final Logger LOGGER = LogManager.getLogger(SchedulerFactory.class);

    @Autowired
    private DomainService domainService;

    @Autowired
    TaskScheduler taskScheduler;

    @PostConstruct
  //  @EventListener({ ContextRefreshedEvent.class })
    public void init() {
        LOGGER.info("Fetching domains from database");
        List<Domain> domains = domainService.getDomains();

        if (CollectionUtils.isEmpty(domains)) {
            LOGGER.info("No domains found in database");
        }
        LOGGER.info("{} domains found in database", domains.size());

        LOGGER.info("Creating scheduler for each domain");
        domains.forEach(domain -> taskScheduler.schedule(new MessagePrinterTask("Cron job trigger for domain " + domain.getDomainName()),
                    new CronTrigger(domain.getCron(), TimeZone.getTimeZone(TimeZone.getDefault().getID()))));
    }

}
