import java.util.Arrays;

public class PlacementDriveShortlistingRankingEngine {

    static class Candidate implements Comparable<Candidate> {
        String name;
        double cgpa;
        int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        double compositeScore() {
            return cgpa * 10 + codingScore / 2.0;
        }

        public int compareTo(Candidate other) {
            return Double.compare(other.compositeScore(), this.compositeScore());
        }
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    static String shortlistAndRank(Candidate[] candidates) {
        int count = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (isEligible(candidates[i].cgpa) || isEligible(candidates[i].cgpa, candidates[i].codingScore)) {
                count++;
            }
        }
        Candidate[] shortlisted = new Candidate[count];
        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (isEligible(candidates[i].cgpa) || isEligible(candidates[i].cgpa, candidates[i].codingScore)) {
                shortlisted[index] = candidates[i];
                index++;
            }
        }
        Arrays.sort(shortlisted);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1).append(". ").append(shortlisted[i].name)
                    .append(" (").append(shortlisted[i].compositeScore()).append(")");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}
