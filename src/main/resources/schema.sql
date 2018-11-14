CREATE TABLE IF NOT EXISTS datemaster(
          dateId          varchar  (6)               NOT NULL  PRIMARY KEY  COMMENT '日付ID'
         ,dateName        varchar  (32)                                     COMMENT '日付名'
         ,adjustmentYear  int      (2)    Default 0  NOT NULL               COMMENT '加減値(年)'
         ,adjustmentMonth int      (3)    Default 0  NOT NULL               COMMENT '加減値(月)'
         ,adjustmentDay   int      (4)    Default 0  NOT NULL               COMMENT '加減値(日)'
);