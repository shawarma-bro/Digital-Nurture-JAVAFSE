-- Scenario 1: safe fund transfer between accounts

CREATE OR REPLACE PROCEDURE SafeTransferFunds (
  p_from_account IN NUMBER,
  p_to_account   IN NUMBER,
  p_amount       IN NUMBER
) AS
  v_from_balance NUMBER;
BEGIN
  SELECT Balance INTO v_from_balance
  FROM Accounts
  WHERE AccountID = p_from_account;

  IF v_from_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account');
  END IF;

  UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account;
  UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account;

  COMMIT;

EXCEPTION
  WHEN NO_DATA_FOUND THEN
    ROLLBACK;
    INSERT INTO ErrorLog (ErrorMessage) VALUES ('Account not found during transfer');
    COMMIT;

  WHEN OTHERS THEN
    ROLLBACK;
    INSERT INTO ErrorLog (ErrorMessage) VALUES (SQLERRM);
    COMMIT;
END;
/


-- Scenario 2: update salary with error handling

CREATE OR REPLACE PROCEDURE UpdateSalary (
  p_employee_id IN NUMBER,
  p_percent     IN NUMBER
) AS
  v_exists NUMBER;
BEGIN
  SELECT COUNT(*) INTO v_exists FROM Employees WHERE EmployeeID = p_employee_id;

  IF v_exists = 0 THEN
    RAISE_APPLICATION_ERROR(-20002, 'Employee does not exist');
  END IF;

  UPDATE Employees
  SET Salary = Salary + (Salary * p_percent / 100)
  WHERE EmployeeID = p_employee_id;

  COMMIT;

EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    INSERT INTO ErrorLog (ErrorMessage) VALUES (SQLERRM);
    COMMIT;
END;
/


-- Scenario 3: add new customer with duplicate check

CREATE OR REPLACE PROCEDURE AddNewCustomer (
  p_customer_id IN NUMBER,
  p_name        IN VARCHAR2,
  p_dob         IN DATE,
  p_balance     IN NUMBER
) AS
BEGIN
  INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
  VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

  COMMIT;

EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    INSERT INTO ErrorLog (ErrorMessage) VALUES ('Customer ID ' || p_customer_id || ' already exists');
    COMMIT;

  WHEN OTHERS THEN
    INSERT INTO ErrorLog (ErrorMessage) VALUES (SQLERRM);
    COMMIT;
END;
/
