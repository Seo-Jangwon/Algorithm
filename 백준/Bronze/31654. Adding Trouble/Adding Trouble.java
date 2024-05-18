import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 세 개의 정수 A, B, C를 입력 받음
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        long C = scanner.nextLong();

        // A + B가 C와 같은지 확인
        if (A + B == C) {
            System.out.println("correct!");
        } else {
            System.out.println("wrong!");
        }

        scanner.close();
    }
}
