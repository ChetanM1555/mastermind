
// import java.lang.Math;
import java.util.Random;
import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean correct = false;
        ArrayList<Integer> code = random_code();
        System.out.println(code);
        int count = 8;
        do {
            count--;
            ArrayList<Integer> answer = get_input();
            // System.out.println(answer);
            try {
                correct = compare(answer, code, count);
            } catch (Exception e) {
                System.out.println("Enter only 4 digits!");
            }
        } while (correct == false);
    }

    public static ArrayList<Integer> random_code() {
        Random rand = new Random();
        int rand_int1 = 10;

        ArrayList<Integer> mastermind = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            rand_int1 = rand.nextInt(8) + 1;
            // NB remove duplicates
            if (mastermind.contains(rand_int1)) {
                i--;
            } else {
                mastermind.add(rand_int1);
            }
        }

        return mastermind;
    }

    public static ArrayList<Integer> get_input() {
        // NB only 4 digits
        int answer = 9;
        Scanner in = new Scanner(System.in);

        do {
            try {
                System.out.print("Enter a 4 digit code: ");
                answer = in.nextInt();

            } catch (Exception e) {
                // System.out.print("Enter a 4 digit code: ");
                answer = 9;
            }
        } while (answer < 999 && answer > 9999);

        // convert input to an array
        ArrayList<Integer> answer_list = new ArrayList<Integer>();
        do {
            answer_list.add(0, answer % 10);
            answer /= 10;
        } while (answer > 0);

        return answer_list;
    }

    public static boolean compare(ArrayList<Integer> answer, ArrayList<Integer> code, int count) {
        /*
         * checks if answer is correct
         */
        if (answer.equals(code) == true) {
            System.out.println("Congratulations you guessed the code!!");
            return true;
        } else if (count == 0) {
            System.out.println("Out of turns.");
            return true;
        } else {
            check_count_correct(answer, code);
            System.out.println("Try again");
            System.out.println("Turns left: " + count);
            return false;
        }
    }

    public static void check_count_correct(ArrayList<Integer> answer, ArrayList<Integer> code) {
        int correct_num = 0;
        int correct_pos = 0;
        // System.out.println(answer);
        // System.out.println(code);
        for (int i = 0; i < 4; i++) {
            int a = answer.get(i);
            int b = code.get(i);
            if (a == b) {
                correct_pos += 1;
            } else if (code.contains(a)) {
                correct_num += 1;
            }
        }
        System.out.println("Numbers guessed correctly but not in the correct position are " + correct_num);
        System.out.println("Numbers guessed in correct posittion are " + correct_pos);

    }
}
