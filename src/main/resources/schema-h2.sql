CREATE TABLE IF NOT EXISTS WEBSITE(ID BIGINT PRIMARY KEY AUTO_INCREMENT,
                  NAME VARCHAR(30),
                  URL VARCHAR(200),
                  TIME_MARGIN INT,
                  LAST_SEEN DATETIME
                  );