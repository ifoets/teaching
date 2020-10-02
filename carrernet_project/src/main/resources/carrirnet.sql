create table user_account(
   id INT NOT NULL AUTO_INCREMENT,
   user_name VARCHAR(100) NOT NULL,
   user_password VARCHAR(40) NOT NULL,
   login_time TIMESTAMP,
   login BOOLEAN,
   PRIMARY KEY (id)
);

create table user_wallet(
   id INT NOT NULL AUTO_INCREMENT,
   account_id INT UNIQUE,
   acno VARCHAR(12) NOT NULL,
   user_name VARCHAR(100) NOT NULL,
   amount double,
   PRIMARY KEY (id),
   CONSTRAINT FK_walletAccount FOREIGN KEY (account_id) REFERENCES user_account(id)
   ON DELETE SET NULL
);

create table user_transaction(
   id INT NOT NULL AUTO_INCREMENT,
   wallet_id INT ,
   ac_from VARCHAR(12) NOT NULL,
   ac_to VARCHAR(12) NOT NULL,
   transfer_amount double,
   charge double,
   commision double,
   total_amount DOUBLE,
   trans_type  ENUM ('DEBIT','CREADIT'),
   trans_time TIMESTAMP,
   PRIMARY KEY (id),
    CONSTRAINT FK_tranactionWallet FOREIGN KEY (wallet_id) REFERENCES user_wallet(id),
 	 CONSTRAINT FK_tranactionWalletAccount	FOREIGN KEY (wallet_id) REFERENCES user_wallet(id)
);