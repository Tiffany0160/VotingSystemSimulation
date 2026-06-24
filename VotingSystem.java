package VotingSystem;

import java.util.Scanner;

public class VotingSystem {

    static String[] candidates = {"Alice", "Bob", "Charlie"};
    static int[] votes = new int[candidates.length];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- VOTING SYSTEM ---");
            System.out.println("1. Vote");
            System.out.println("2. View Results");
            System.out.println("3. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> vote();
                case 2 -> results();
                case 3 -> System.out.println("Voting closed.");
                default -> System.out.println("Invalid option");
            }
        } while (choice != 3);
    }

    static void vote() {
        System.out.println("Candidates:");
        for (int i = 0; i < candidates.length; i++) {
            System.out.println((i + 1) + ". " + candidates[i]);
        }

        System.out.print("Choose candidate number: ");
        int choice = sc.nextInt();

        if (choice >= 1 && choice <= candidates.length) {
            votes[choice - 1]++;
            System.out.println("Vote recorded.");
        } else {
            System.out.println("Invalid vote.");
        }
    }

    static void results() {
        int maxVotes = 0;
        String winner = "";

        for (int i = 0; i < candidates.length; i++) {
            System.out.println(candidates[i] + ": " + votes[i] + " votes");
            if (votes[i] > maxVotes) {
                maxVotes = votes[i];
                winner = candidates[i];
            }
        }

        System.out.println("Winner: " + winner);
    }
}
