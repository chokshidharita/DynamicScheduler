package com.walmart.finance.ap.fds.purging.cron.poc.repository;

import com.walmart.finance.ap.fds.purging.cron.poc.model.entity.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainRepository extends JpaRepository<Domain, Long>  {
}
