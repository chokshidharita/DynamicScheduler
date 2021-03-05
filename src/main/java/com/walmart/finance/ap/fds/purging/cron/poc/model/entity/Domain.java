package com.walmart.finance.ap.fds.purging.cron.poc.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "domain")
@Data
public class Domain {

    @Id
    @Column
    private Long id;

    @Column(name= "domain_name")
    private String domainName;

    @Column(name= "cron")
    private String cron;
}
