import java.util.*;
class Team {

    final String name;
    final int points;
    final int goalDiff;

    Team(String name, int points, int goalDiff) {
        this.name = name;
        this.points = points;
        this.goalDiff = goalDiff;
    }

    @Override
    public String toString() {
        return name + "(" + points + "," + goalDiff + ")";
    }
}

class Leaderboard<T> {

    private final List<T> items = new ArrayList<>();
    private final Comparator<? super T> order;

    Leaderboard(Comparator<? super T> order) {
        this.order = order;
    }

    void add(T item) {
        items.add(item);
    }

    List<T> ranking() {
        List<T> result = new ArrayList<>(items);
        result.sort(order);
        return result;
    }
}

public class Main {

    public static void main(String[] args) {

        // Ranking: Points, Goal Difference, Team Name
        Comparator<Team> byRank = (a, b) -> {

            if (a.points != b.points) {
                return Integer.compare(b.points, a.points);
            }

            if (a.goalDiff != b.goalDiff) {
                return Integer.compare(b.goalDiff, a.goalDiff);
            }

            return a.name.compareTo(b.name);
        };

        Leaderboard<Team> board =
            new Leaderboard<>(byRank);

        board.add(new Team("Panthers", 9, 4));
        board.add(new Team("Eagles", 9, 6));
        board.add(new Team("Cobras", 6, 1));
        board.add(new Team("Bisons", 9, 4));

        System.out.println("Team Rankings:");
        System.out.println(board.ranking());
    }
}
