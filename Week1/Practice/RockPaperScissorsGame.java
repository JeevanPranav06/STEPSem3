import java.util.Random;

public class RockPaperScissorsGame {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        if (playerMove.equals("Rock") && computerMove.equals("Scissors")) {
            return "Player Wins";
        }
        if (playerMove.equals("Paper") && computerMove.equals("Rock")) {
            return "Player Wins";
        }
        if (playerMove.equals("Scissors") && computerMove.equals("Paper")) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        Random random = new Random();
        int rounds = 5;
        String[] roundResults = new String[rounds];
        String[] computerMoves = new String[rounds];
        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < rounds; i++) {
            String playerMove = playerMoves[i];
            String computerMove = moves[random.nextInt(3)];
            computerMoves[i] = computerMove;
            String result = playRound(playerMove, computerMove);
            roundResults[i] = result;
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
            System.out.println("Round " + (i + 1) + " — Player: " + playerMove + ", Computer: " + computerMove);
            System.out.println(result);
        }

        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 0; i < rounds; i++) {
            System.out.println((i + 1) + " | " + playerMoves[i] + " | " + computerMoves[i] + " | " + roundResults[i]);
        }
        double winPercentage = (wins * 100.0) / rounds;
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + winPercentage + "%");
    }
}
