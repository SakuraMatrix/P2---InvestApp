CREATE KEYSPACE IF NOT EXISTS investapp WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : '1' };

-- Create Stocks Table
CREATE TABLE IF NOT EXISTS investapp.stocks (
	id int PRIMARY KEY,
	account_id int,
	owned int,
	symbol text,
	name text,
	price double,
	changesPercentage double,
	change double,
	dayLow double,
	dayHigh double,
	yearHigh double,
	yearLow double,
	marketCap double,
	priceAvg50 double,
	priceAvg200 double,
	volume double,
	avgVolume double,
	exchange text,
	open double,
	previousClose double,
	eps double,
	pe double,
	earningsAnnouncement text,
	sharesOutstanding double,
	timestamp double,
);



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
	card_id int,
	account_id int,
    card_num text,
	first_name text,
	last_name text,
    type text,
    ccv text,
    exp_date text,
    PRIMARY KEY (card_id,card_num)
);

-- Create Loans Table
CREATE TABLE IF NOT EXISTS investapp.loans (
	account_id int,
	loan_id UUID,
	timestamp Timestamp,
	loan_amount double,
	purpose text,
	gross_earning double,
	total_expenses double,
	loan_term int,
	loan_status text,
	approved boolean,
	PRIMARY KEY((account_id),loan_id)
);
	
	