import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteCount = new HashMap<>();
    private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();

    public void castVote(String candidate) {
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteCount.get(candidate));
    }

    public void displayResults() {
        TreeMap<String, Integer> sortedVotes = new TreeMap<>(voteCount);
        System.out.println("Votes in sorted order: " + sortedVotes);
        System.out.println("Votes in order received: " + voteOrder);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VotingSystem voting = new VotingSystem();

        System.out.print("Enter number of votes: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter candidate name: ");
            String candidate = sc.nextLine();
            voting.castVote(candidate);
        }

        voting.displayResults();
        sc.close();
    }
}
