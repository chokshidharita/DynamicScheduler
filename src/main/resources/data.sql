DROP TABLE IF EXISTS domain;

CREATE TABLE domain (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  domain_name VARCHAR(250) NOT NULL,
  cron VARCHAR(250) NOT NULL
);

INSERT INTO domain (domain_name, cron) VALUES
  ('Invoice', '0/5 * * * * ?'),
  ('PO', '0/10 * * * * ?'),
  ('Receivings', '0/15 * * * * ?');
