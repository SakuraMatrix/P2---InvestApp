CREATE KEYSPACE IF NOT EXISTS investapp WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : '1' };

-- Create Stocks Table
CREATE TABLE IF NOT EXISTS investapp.stocks (
	id int PRIMARY KEY,
	account_id int,
	owned int, 
	symbol text, 
	name text, 
	price double,  
	changes_percentage double, 
	change double, 
	day_low double, 
	day_high double, 
	year_high double, 
	year_low double,  
	market_cap double, 
	price_avg50 double, 
	price_avg200 double, 
	volume double, 
	avg_volume double, 
	exchange text, 
	open double, 
	previousClose double, 
	eps double, 
	pe double, 
	earnings_announcement text, 
	shares_outstanding double, 
	timestamp double,
	
);


INSERT INTO investapp.stocks
(id, account_id, owned, symbol, name, price, changes_percentage, change, day_low, day_high, year_high, year_low, market_cap, price_avg50, price_avg200, volume, avg_volume, exchange, open, previousClose, eps, pe, earnings_announcement, shares_outstanding, timestamp)
VALUES (1, 1, 1, 'MSFT', 'Microsoft', 250, 20, 5, 245, 255, 265, 243, 1000, 260, 269, 20000, 2000, 'NASDAQ', 250, 249.5, 1000, 25, 'January 6, 2022', 4000, 12);

-- Create Accounts Table
CREATE TABLE IF NOT EXISTS
investapp.accounts (
id int PRIMARY KEY,
first_name text,
last_name text,
funds double,
credit double
);

-- Create Credit Cards Table
CREATE TABLE IF NOT EXISTS investapp.creditcards (
	account_id int,
    card_num text,
	first_name text,
	last_name text,
    type text,
    ccv text,
    exp_date text,
    PRIMARY KEY (card_num)
);

-- Create Loans Table
CREATE TABLE IF NOT EXISTS investapp.loans (
	account_id int PRIMARY KEY,
	timestamp Timestamp,
	loan_amount double,
	purpose text,
	gross_earning double,
	total_expenses double,
	loan_term int,
	loan_status text,
	approved boolean
);