package de.exxcellent.challenge.data;


/**
 * data holder class for football data
 *
 * @author Aleksander Kus(akus@stud.hs-heilbronn.de)
 */
public class PCFootballTeamData implements PCData {
    private String teamName;
    private int gameCount;
    private int totalWins;
    private int totalLosses;
    private int draws;
    private int totalGoals;
    private int goalsAllowed;
    private int points;

    public PCFootballTeamData(String teamName, int totalGoals, int goalsAllowed) {
        this.teamName = teamName;
        this.totalGoals = totalGoals;
        this.goalsAllowed = goalsAllowed;
    }

    public PCFootballTeamData(String teamName, int gameCount, int totalWins, int totalLosses, int draws, int totalGoals, int goalsAllowed, int points) {
        this.teamName = teamName;
        this.gameCount = gameCount;
        this.totalWins = totalWins;
        this.totalLosses = totalLosses;
        this.draws = draws;
        this.totalGoals = totalGoals;
        this.goalsAllowed = goalsAllowed;
        this.points = points;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getGameCount() {
        return gameCount;
    }

    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public int getTotalLosses() {
        return totalLosses;
    }

    public void setTotalLosses(int totalLosses) {
        this.totalLosses = totalLosses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getTotalGoals() {
        return totalGoals;
    }

    public void setTotalGoals(int totalGoals) {
        this.totalGoals = totalGoals;
    }

    public int getGoalsAllowed() {
        return goalsAllowed;
    }

    public void setGoalsAllowed(int goalsAllowed) {
        this.goalsAllowed = goalsAllowed;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
