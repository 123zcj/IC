CREATE DATABASE ISIC
    DEFAULT CHARACTER SET = 'utf8mb4';
/* 2025-06-05 07:12:39 [3 ms] */
use isic;
/* 2025-06-05 07:19:38 [50 ms] */
CREATE TABLE Test_menta_data (
                                 id    BIGINT          PRIMARY KEY AUTO_INCREMENT,
                                 image  VARCHAR(25)     UNIQUE,
                                 age_approx int          ,
                                 anatom_site_general VARCHAR(25),
                                 sex VARCHAR(25)
);
/* 2025-06-05 07:21:48 [32 ms] */
CREATE TABLE Train_menta_data (
                                  id    BIGINT          PRIMARY KEY AUTO_INCREMENT,
                                  image  VARCHAR(25)     UNIQUE,
                                  age_approx int          ,
                                  anatom_site_general VARCHAR(25),
                                  lesion_id VARCHAR(25),
                                  sex VARCHAR(25)
);
CREATE TABLE Train_ground_truth (
                                    id    BIGINT          PRIMARY KEY AUTO_INCREMENT,
                                    image  VARCHAR(25)     UNIQUE,
                                    type int
);

CREATE TABLE Test_ground_truth (
                                   id    BIGINT          PRIMARY KEY AUTO_INCREMENT,
                                   image  VARCHAR(25)     UNIQUE,
                                   type int
);
