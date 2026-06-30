-- Scenario 1: monthly statements using explicit cursor

DECLARE
  CURSOR GenerateMonthlyStatements IS
    SELECT t.TransactionID, t.AccountID, t.Amount, t.TransactionType, c.Name
    FROM Transactions t
    JOIN Accounts a ON a.AccountID = t.AccountID
    JOIN Customers c ON c.CustomerID = a.CustomerID
    WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
    AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);

  v_rec GenerateMonthlyStatements%ROWTYPE;
BEGIN
  OPEN GenerateMonthlyStatements;
  LOOP
    FETCH GenerateMonthlyStatements INTO v_rec;
    EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

    DBMS_OUTPUT.PUT_LINE(v_rec.Name || ' - ' || v_rec.TransactionType || ' of ' || v_rec.Amount);
  END LOOP;
  CLOSE GenerateMonthlyStatements;
END;
/


-- Scenario 2: apply annual fee using explicit cursor

DECLARE
  CURSOR ApplyAnnualFee IS
    SELECT AccountID FROM Accounts;

  v_account_id Accounts.AccountID%TYPE;
  v_fee NUMBER := 25;
BEGIN
  OPEN ApplyAnnualFee;
  LOOP
    FETCH ApplyAnnualFee INTO v_account_id;
    EXIT WHEN ApplyAnnualFee%NOTFOUND;

    UPDATE Accounts
    SET Balance = Balance - v_fee
    WHERE AccountID = v_account_id;
  END LOOP;
  CLOSE ApplyAnnualFee;

  COMMIT;
END;
/


-- Scenario 3: update loan interest rates using explicit cursor

DECLARE
  CURSOR UpdateLoanInterestRates IS
    SELECT LoanID, InterestRate FROM Loans;

  v_loan_id Loans.LoanID%TYPE;
  v_old_rate Loans.InterestRate%TYPE;
  v_new_rate Loans.InterestRate%TYPE;
BEGIN
  OPEN UpdateLoanInterestRates;
  LOOP
    FETCH UpdateLoanInterestRates INTO v_loan_id, v_old_rate;
    EXIT WHEN UpdateLoanInterestRates%NOTFOUND;

    v_new_rate := v_old_rate + 0.5;

    UPDATE Loans
    SET InterestRate = v_new_rate
    WHERE LoanID = v_loan_id;
  END LOOP;
  CLOSE UpdateLoanInterestRates;

  COMMIT;
END;
/
