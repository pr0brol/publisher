CREATE TABLE IF NOT EXISTS subscription (
  id                      BIGSERIAL PRIMARY KEY NOT NULL UNIQUE,
  msisdn                  BIGSERIAL NOT NULL,
  action_type             VARCHAR(80) NOT NULL,
  send_time               TIMESTAMP NOT NULL
);


CREATE TABLE IF NOT EXISTS  purchase (
  id                      BIGSERIAL PRIMARY KEY NOT NULL UNIQUE,
  msisdn                  BIGSERIAL NOT NULL,
  action_type             VARCHAR(80) NOT NULL,
  send_time               TIMESTAMP NOT NULL
);


