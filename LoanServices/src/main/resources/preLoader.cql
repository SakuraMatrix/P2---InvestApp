INSERT INTO investapp.loans (account_id, loan_id, timestamp, loan_amount, purpose, gross_earning, total_expenses, loan_term, loan_status, approved)
 VALUES (1, UUID(), toTIMESTAMP(now()), 10000, 'Auto Loan' ,65000, 3400, 12, 'submitted', FALSE);
INSERT INTO investapp.loans (account_id, loan_id, timestamp, loan_amount, purpose, gross_earning, total_expenses, loan_term, loan_status, approved)
VALUES (2, UUID(), toTIMESTAMP(now()), 150000, 'Home Equity' ,55000, 3400, 360, 'Complete', TRUE);
INSERT INTO investapp.loans (account_id, loan_id, timestamp, loan_amount, purpose, gross_earning, total_expenses, loan_term, loan_status, approved)
VALUES (1, UUID(), toTIMESTAMP(now()), 265000, 'Home Equity' ,65000, 3400, 400, 'Complete', TRUE);
INSERT INTO investapp.loans (account_id, loan_id, timestamp, loan_amount, purpose, gross_earning, total_expenses, loan_term, loan_status, approved)
VALUES (3, UUID(), toTIMESTAMP(now()), 2500, 'Credit Card' ,55000, 3400, 12, 'Received', FALSE);
INSERT INTO investapp.loans (account_id, loan_id, timestamp, loan_amount, purpose, gross_earning, total_expenses, loan_term, loan_status, approved)
VALUES (2, UUID(), toTIMESTAMP(now()), 5000, 'Credit Card' ,55000, 3400, 24, 'Received', FALSE);
INSERT INTO investapp.loans (account_id, loan_id, timestamp, loan_amount, purpose, gross_earning, total_expenses, loan_term, loan_status, approved)
VALUES (08, UUID(), toTIMESTAMP(now()), 35000, 'Auto Loan' ,35000, 1600, 36, 'Review', FALSE);
INSERT INTO investapp.loans (account_id, loan_id, timestamp, loan_amount, purpose, gross_earning, total_expenses, loan_term, loan_status, approved)
VALUES (10, UUID(), toTIMESTAMP(now()), 1000, 'Credit Card' ,25000, 1200, 12, 'Complete', FALSE);
INSERT INTO investapp.loans (account_id, loan_id, timestamp, loan_amount, purpose, gross_earning, total_expenses, loan_term, loan_status, approved)
VALUES (2, UUID(), toTIMESTAMP(now()), 8500, 'Personal Loan' ,42000, 3400, 12, 'Review', FALSE);
INSERT INTO investapp.loans (account_id, loan_id, timestamp, loan_amount, purpose, gross_earning, total_expenses, loan_term, loan_status, approved)
VALUES (08, UUID(), toTIMESTAMP(now()), 1200, 'Credit Card' ,30000, 1800, 12, 'Submitted', FALSE);
INSERT INTO investapp.loans (account_id, loan_id, timestamp, loan_amount, purpose, gross_earning, total_expenses, loan_term, loan_status, approved)
VALUES (22, UUID(), toTIMESTAMP(now()), 22000, 'Auto Loan' ,28500, 1800, 24, 'Review', FALSE);
INSERT INTO investapp.loans (account_id, loan_id, timestamp, loan_amount, purpose, gross_earning, total_expenses, loan_term, loan_status, approved)
VALUES (56, UUID(), toTIMESTAMP(now()), 45000, 'Auto Loan' ,85000, 4500, 36, 'Complete', FALSE);
INSERT INTO investapp.loans (account_id, loan_id, timestamp, loan_amount, purpose, gross_earning, total_expenses, loan_term, loan_status, approved)
VALUES (10, UUID(), toTIMESTAMP(now()), 1000, 'Credit Card' ,25000, 1200, 12, 'Complete', FALSE);
INSERT INTO investapp.loans (account_id, loan_id, timestamp, loan_amount, purpose, gross_earning, total_expenses, loan_term, loan_status, approved)
VALUES (22, UUID(), toTIMESTAMP(now()), 8500, 'Personal Loan' ,42000, 3400, 12, 'Review', FALSE);
INSERT INTO investapp.loans (account_id, loan_id, timestamp, loan_amount, purpose, gross_earning, total_expenses, loan_term, loan_status, approved)
VALUES (01, UUID(), toTIMESTAMP(now()), 1200, 'Credit Card' ,30000, 1800, 12, 'Submitted', FALSE);
INSERT INTO investapp.loans (account_id, loan_id, timestamp, loan_amount, purpose, gross_earning, total_expenses, loan_term, loan_status, approved)
VALUES (22, UUID(), toTIMESTAMP(now()), 22000, 'Auto Loan' ,28500, 1800, 24, 'Review', FALSE);
INSERT INTO investapp.loans (account_id, loan_id, timestamp, loan_amount, purpose, gross_earning, total_expenses, loan_term, loan_status, approved)
VALUES (18, UUID(), toTIMESTAMP(now()), 45000, 'Auto Loan' ,85000, 4500, 36, 'Complete', FALSE);




INSERT INTO investapp.stocks
(account_id, owned, symbol, name, price, changes_percentage, change, day_low, day_high, year_high, year_low, market_cap, price_avg50, price_avg200, volume, avg_volume, exchange, open, previousClose, eps, pe, earnings_announcement, shares_outstanding, timestamp)
VALUES (1, 1, 'MSFT', 'Microsoft', 250, 20, 5, 245, 255, 265, 243, 1000, 260, 269, 20000, 2000, 'NASDAQ', 250, 249.5, 1000, 25, 'January 6, 2022', 4000, 12);
