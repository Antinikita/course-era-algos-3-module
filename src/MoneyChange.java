import java.util.*;

public class MoneyChange {
    public static int change(int money) {
        int numberOfCoins = 0;
        while (money > 0) {
            if (money >= 10) {
                money -= 10;
                numberOfCoins++;
            } else if (money >= 5) {
                money -= 5;
                numberOfCoins++;
            } else {
                money -= 1;
                numberOfCoins++;
            }
        }
        return numberOfCoins;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        System.out.println(change(money));
    }
}
