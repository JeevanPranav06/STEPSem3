import java.util.Arrays;

public class FantasyLeagueAutoDraftRankingEngine {

    static class Player implements Comparable<Player> {
        String name;
        int matchesPlayed;
        double battingAverage;
        boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    static String draftAndRank(Player[] players) {
        int count = 0;
        for (int i = 0; i < players.length; i++) {
            if (isDraftable(players[i].matchesPlayed) || isDraftable(players[i].matchesPlayed, players[i].injured)) {
                count++;
            }
        }
        Player[] draftable = new Player[count];
        int index = 0;
        for (int i = 0; i < players.length; i++) {
            if (isDraftable(players[i].matchesPlayed) || isDraftable(players[i].matchesPlayed, players[i].injured)) {
                draftable[index] = players[i];
                index++;
            }
        }
        Arrays.sort(draftable);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1).append(". ").append(draftable[i].name);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
    }
}
