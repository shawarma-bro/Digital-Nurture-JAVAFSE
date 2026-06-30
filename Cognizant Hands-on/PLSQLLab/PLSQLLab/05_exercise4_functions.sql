-- Scenario 1: calculate age

CREATE OR REPLACE FUNCTION CalculateAge (
  p_dob IN DATE
) RETURN NUMBER AS
  v_age NUMBER;
BEGIN
  v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
  RETURN v_age;
END;
/


-- Scenario 2: monthly loan installment

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
  p_loan_amount IN NUMBER,
  p_rate        IN NUMBER,
  p_years       IN NUMBER
) RETURN NUMBER AS
  v_monthly_rate NUMBER;
  v_months       NUMBER;
  v_installment  NUMBER;
BEGIN
  v_monthly_rate := (p_rate / 100) / 12;
  v_months := p_years * 12;

  v_installment := (p_loan_amount * v_monthly_rate) /
                    (1 - POWER(1 + v_monthly_rate, -v_months));

  RETURN ROUND(v_installment, 2);
END;
/


-- Scenario 3: check sufficient balance

CREATE OR REPLACE FUNCTION HasSufficientBalance (
  p_account_id IN NUMBER,
  p_amount     IN NUMBER
) RETURN BOOLEAN AS
  v_balance NUMBER;
BEGIN
  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_account_id;

  IF v_balance >= p_amount THEN
    RETURN TRUE;
  ELSE
    RETURN FALSE;
  END IF;
END;
/
