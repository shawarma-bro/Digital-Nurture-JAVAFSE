-- Scenario 1: CustomerManagement package

CREATE OR REPLACE PACKAGE CustomerManagement AS
  PROCEDURE AddCustomer (p_id IN NUMBER, p_name IN VARCHAR2, p_dob IN DATE, p_balance IN NUMBER);
  PROCEDURE UpdateCustomerDetails (p_id IN NUMBER, p_name IN VARCHAR2);
  FUNCTION GetCustomerBalance (p_id IN NUMBER) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

  PROCEDURE AddCustomer (p_id IN NUMBER, p_name IN VARCHAR2, p_dob IN DATE, p_balance IN NUMBER) AS
  BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
    COMMIT;
  END AddCustomer;

  PROCEDURE UpdateCustomerDetails (p_id IN NUMBER, p_name IN VARCHAR2) AS
  BEGIN
    UPDATE Customers
    SET Name = p_name
    WHERE CustomerID = p_id;
    COMMIT;
  END UpdateCustomerDetails;

  FUNCTION GetCustomerBalance (p_id IN NUMBER) RETURN NUMBER AS
    v_balance NUMBER;
  BEGIN
    SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_id;
    RETURN v_balance;
  END GetCustomerBalance;

END CustomerManagement;
/


-- Scenario 2: EmployeeManagement package

CREATE OR REPLACE PACKAGE EmployeeManagement AS
  PROCEDURE HireEmployee (p_id IN NUMBER, p_name IN VARCHAR2, p_position IN VARCHAR2, p_salary IN NUMBER, p_dept IN VARCHAR2);
  PROCEDURE UpdateEmployeeDetails (p_id IN NUMBER, p_position IN VARCHAR2);
  FUNCTION CalculateAnnualSalary (p_id IN NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

  PROCEDURE HireEmployee (p_id IN NUMBER, p_name IN VARCHAR2, p_position IN VARCHAR2, p_salary IN NUMBER, p_dept IN VARCHAR2) AS
  BEGIN
    INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
    VALUES (p_id, p_name, p_position, p_salary, p_dept, SYSDATE);
    COMMIT;
  END HireEmployee;

  PROCEDURE UpdateEmployeeDetails (p_id IN NUMBER, p_position IN VARCHAR2) AS
  BEGIN
    UPDATE Employees
    SET Position = p_position
    WHERE EmployeeID = p_id;
    COMMIT;
  END UpdateEmployeeDetails;

  FUNCTION CalculateAnnualSalary (p_id IN NUMBER) RETURN NUMBER AS
    v_monthly NUMBER;
  BEGIN
    SELECT Salary INTO v_monthly FROM Employees WHERE EmployeeID = p_id;
    RETURN v_monthly * 12;
  END CalculateAnnualSalary;

END EmployeeManagement;
/


-- Scenario 3: AccountOperations package

CREATE OR REPLACE PACKAGE AccountOperations AS
  PROCEDURE OpenAccount (p_account_id IN NUMBER, p_customer_id IN NUMBER, p_type IN VARCHAR2, p_balance IN NUMBER);
  PROCEDURE CloseAccount (p_account_id IN NUMBER);
  FUNCTION GetTotalBalance (p_customer_id IN NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

  PROCEDURE OpenAccount (p_account_id IN NUMBER, p_customer_id IN NUMBER, p_type IN VARCHAR2, p_balance IN NUMBER) AS
  BEGIN
    INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
    VALUES (p_account_id, p_customer_id, p_type, p_balance, SYSDATE);
    COMMIT;
  END OpenAccount;

  PROCEDURE CloseAccount (p_account_id IN NUMBER) AS
  BEGIN
    DELETE FROM Accounts WHERE AccountID = p_account_id;
    COMMIT;
  END CloseAccount;

  FUNCTION GetTotalBalance (p_customer_id IN NUMBER) RETURN NUMBER AS
    v_total NUMBER;
  BEGIN
    SELECT NVL(SUM(Balance), 0) INTO v_total
    FROM Accounts
    WHERE CustomerID = p_customer_id;

    RETURN v_total;
  END GetTotalBalance;

END AccountOperations;
/
