
// import java.lang.Math;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
// import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean correct = false;
        ArrayList<Integer> code = random_code();
        System.out.println(code);
        ArrayList<Integer> answer = get_input();
        System.out.println(answer);
        correct = compare(answer, code);
    }

    public static ArrayList<Integer> random_code() {
        Random rand = new Random();
        int rand_int1 = 10;
        // int[] mastermind;
        ArrayList<Integer> mastermind = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            rand_int1 = rand.nextInt(8);
            // NB remove duplicates
            mastermind.add(rand_int1);
        }
        // System.out.println(mastermind);
        return mastermind;
    }

    public static ArrayList<Integer> get_input() {
        // ArrayList<Integer> input_code = new ArrayList<>();
        int answer = 9;
        Scanner in = new Scanner(System.in);

        while (!(answer < 9999 & answer > 1000)) {
            System.out.print("Enter a 4 digit code: ");
            answer = in.nextInt();
        }
        in.close();

        // convert input to an array
        ArrayList<Integer> answer_list = new ArrayList<Integer>();
        do {
            answer_list.add(0, answer % 10);
            answer /= 10;
        } while (answer > 0);

        return answer_list;
    }

    public static boolean compare(ArrayList<Integer> answer, ArrayList<Integer> code) {
        if (Arrays.equals(answer, code) == true) {
            System.out.println("Congratulations you guessed the code");
            return true;
        } else {
            System.out.println("Try again");
            return false;
        }
    }
}
