package TalkingClock;

import java.util.Scanner;

public class TalkingClock {
    public static void main(String[] args) {
        readTime();
    }

    public static String readTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter time:");
        return scanner.nextLine();
    }
}
