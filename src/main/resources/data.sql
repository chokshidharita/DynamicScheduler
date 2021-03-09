DROP TABLE IF EXISTS domain;
DROP TABLE IF EXISTS domain_detail;

CREATE TABLE domain (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  domain_name VARCHAR(250) NOT NULL,
  cron VARCHAR(250) NOT NULL,
  is_active BOOLEAN NOT NULL
);

INSERT INTO domain (domain_name, cron, is_active) VALUES
  ('Invoice', '0/5 * * * * ?', true),
  ('PO', '0/10 * * * * ?', true),
  ('Receivings', '0/15 * * * * ?', true);

  
CREATE TABLE domain_detail (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  domain_id BIGINT,
  extract VARCHAR(250) NOT NULL,
  source VARCHAR(250) NOT NULL,
  load_type VARCHAR(250) NOT NULL,
  transform_type VARCHAR(250) NOT NULL,
  action VARCHAR(250) NOT NULL,
  action_type VARCHAR(250) NOT NULL,
  allow_delete BOOLEAN NOT NULL,
  FOREIGN KEY(domain_id) REFERENCES domain
);
 

INSERT INTO domain_detail (domain_id, extract, source, load_type, transform_type, action, action_type, allow_delete) VALUES
  (1, 
  'SELECT * FROM INVC_SUMMARY_MATCH_LOG WHERE log_ts < :timestamp FETCH FIRST 100000 ROWS ONLY', 
  'DB2', 'COSMOS_BLOB', 'CSV_JSON', 
  'DELETE FROM INVC_SUMMARY_MATCH_LOG T1 WHERE EXISTS ( SELECT * FROM ( SELECT log_ts,invoice_id, match_id , inv_match_seq_nbr FROM INVC_SUMMARY_MATCH_LOG WHERE log_ts  <  :timestamp FETCH FIRST 100000 ROWS ONLY ) AS T2 WHERE (T1.log_ts = T2.log_ts AND T1.invoice_id = T2. invoice_id AND T1.match_id = T2. match_id AND T1.inv_match_seq_nbr = T2. inv_match_seq_nbr) )', 
  ,'DELETE', false);