CREATE TABLE IF NOT EXISTS dateformula(
          dateId          varchar  (6)               NOT NULL  PRIMARY KEY  
         ,dateName        varchar  (32)                                     
         ,adjustmentYear  int      (2)    Default 0  NOT NULL               
         ,adjustmentMonth int      (3)    Default 0  NOT NULL               
         ,adjustmentDay   int      (4)    Default 0  NOT NULL               
);