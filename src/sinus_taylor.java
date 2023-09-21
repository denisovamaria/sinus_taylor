import java.io.*;
import java.text.*;

public class sinus_taylor {
    public static void main(String[] args) {
        InputStreamReader rea = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(rea);
        double x = 0;
        int k = 0;
        System.out.println("Enter x");
        try {
            String line = buf.readLine();
            x = Double.parseDouble(line);
        } catch (IOException e) {
            System.out.println("Keyboard reading error");
        }
        System.out.println("Enter k");
        try {
            String line = buf.readLine();
            k = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("k is not an integer");
        } catch (IOException e) {
            System.out.println("Keyboard reading error");
        }
        double eps = 1 / Math.pow(10, k);
        double newx = x;
        int n = 0;
        double sum = 0;
        while (x > 2 * Math.PI) {
            x = x - 2 * Math.PI;
        }
        while (x < 0) {
            x = x + 2 * Math.PI;
        }
        double sinus = x;
        while (Math.abs(sinus) > eps) {
            sum = sum + sinus;
            n++;
            sinus = sinus * (-1 * x * x) / (2 * n) / (2 * n + 1);
        }
        sum = sum + sinus;
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(k);
        System.out.println("Taylor's sinus:");
        System.out.println(formatter.format(sum / newx));
        System.out.println("Sinus with library 'Math':");
        System.out.println(formatter.format(Math.sin(newx) / newx));
    }
}