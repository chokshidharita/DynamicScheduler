package com.walmart.finance.ap.fds.purging.cron.poc.service;

import com.walmart.finance.ap.fds.purging.cron.poc.model.entity.Domain;
import com.walmart.finance.ap.fds.purging.cron.poc.repository.DomainRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class DomainService {

    private static final Logger LOGGER = LogManager.getLogger(DomainService.class);

    @Autowired
    private DomainRepository domainRepository;

    public List<Domain> getDomains() {
        return domainRepository.findAll();
    }
}
