package recursion;

public class Main {
    public static void main(String[] args) {
        double initialValue = 1000.00;
        double growthRate = 0.10;

        System.out.println("--- Financial Forecasting ---");
        System.out.println("Initial Investment: $" + initialValue);
        System.out.println("Annual Growth Rate: " + (growthRate * 100) + "%");
        System.out.println();

        for (int year = 1; year <= 5; year++) {
            double futureValue = ForecastCalculator.calculateFutureValue(initialValue, growthRate, year);
            System.out.printf("Year %d: $%.2f%n", year, futureValue);
        }

        System.out.println();
        double bigInvestment = 5000.00;
        double rate = 0.08;
        int years = 10;
        double result = ForecastCalculator.calculateFutureValue(bigInvestment, rate, years);
        System.out.printf("$%.2f invested at %.0f%% for %d years = $%.2f%n", bigInvestment, rate * 100, years, result);
    }
}
