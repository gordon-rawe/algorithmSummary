package fibonacci;

/**
 * Created by gordon on 9/28/16.
 */
public class Fibonacci {

    public static int fibonacci(int now) {
        if (now < 2) return now;
        return fibonacci(now - 1) + fibonacci(now - 2);
    }

    public static int fibonacciFor(int now) {
        if (now < 2) return now;
        int lastOne = 0, lastTwo = 1, current = 0;
        for (int i = 0; i < now - 1; i++) {
            current = lastOne + lastTwo;
            lastOne = lastTwo;
            lastTwo = current;
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(fibonacciFor(1000));
    }
}
