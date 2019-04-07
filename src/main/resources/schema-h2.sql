CREATE TABLE IF NOT EXISTS WEBSITE (
                  ID BIGINT PRIMARY KEY AUTO_INCREMENT,
                  NAME VARCHAR(30),
                  URL VARCHAR(200),
                  TIME_MARGIN INT,
                  LAST_SEEN DATETIME
                  );

CREATE TABLE IF NOT EXISTS HEARTBEAT (
                  ID BIGINT PRIMARY KEY AUTO_INCREMENT,
                  HOST_NAME VARCHAR(100),
                  IP VARCHAR(40),
                  RECV_TIME DATETIME
                  );