-- Scenario 1: senior citizen loan discount

DECLARE
  v_age NUMBER;
BEGIN
  FOR cust IN (SELECT CustomerID, DOB FROM Customers) LOOP
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, cust.DOB) / 12);

    IF v_age > 60 THEN
      UPDATE Loans
      SET InterestRate = InterestRate - (InterestRate * 0.01)
      WHERE CustomerID = cust.CustomerID;
    END IF;
  END LOOP;

  COMMIT;
END;
/


-- Scenario 2: mark VIP customers

BEGIN
  FOR cust IN (SELECT CustomerID, Balance FROM Customers) LOOP
    IF cust.Balance > 10000 THEN
      UPDATE Customers
      SET IsVIP = 'TRUE'
      WHERE CustomerID = cust.CustomerID;
    END IF;
  END LOOP;

  COMMIT;
END;
/


-- Scenario 3: loan due reminders

BEGIN
  FOR ln IN (
    SELECT l.LoanID, l.CustomerID, l.EndDate, c.Name
    FROM Loans l
    JOIN Customers c ON c.CustomerID = l.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || ln.LoanID || ' for ' || ln.Name || ' is due on ' || TO_CHAR(ln.EndDate, 'DD-MON-YYYY'));
  END LOOP;
END;
/
