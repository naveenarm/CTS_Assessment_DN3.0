public class FinancialForecasting {
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        } else {
            double nextValue = presentValue * (1 + growthRate);
            return calculateFutureValue(nextValue, growthRate, periods - 1);
        }
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; 
        double growthRate = 0.05; 
        int periods = 10; 
        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        System.out.println("Future value after " + periods + " years: " + futureValue);
    }
}