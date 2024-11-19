import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<Integer, String> answers = new HashMap<>();
    static String playerChoice;
    static String computerChoice;
    static boolean winner = false;

    public static void main(String[] args) {
        answers.put(1, "rock");
        answers.put(2, "paper");
        answers.put(3, "scissors");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose 'Rock', 'Paper' or 'Scissors': ");
        playerChoice = scanner.nextLine().toLowerCase();

        while (!winner) {
            computerChoice = randomChoice();
            System.out.println(checkWinner());
        }



        System.out.println(computerChoice);
        scanner.close();
    }

    public static String checkWinner() {
        if (playerChoice.equals(computerChoice)) {
            winner = true;
            return "It's a tie!";
        } else if (
            playerChoice.equals("rock") && computerChoice.equals("scissors") ||
            playerChoice.equals("paper") && computerChoice.equals("rock") ||
            playerChoice.equals("scissors") && computerChoice.equals("paper")) {
                winner = true;
                return "You win!";
        } else {
            winner = true;
            return "You lose!";
        }
    }

    public static String randomChoice() {
        int randomChoice = (int) (Math.random() * 3) + 1;
        return answers.get(randomChoice);
    }
}