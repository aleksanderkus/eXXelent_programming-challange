package de.exxcellent.challenge.util;


import de.exxcellent.challenge.data.PCFootballTeamData;

import java.util.List;

/**
 * utils class for working with {@link PCFootballTeamData}
 *
 * @author Aleksander Kus(akus@stud.hs-heilbronn.de)
 */
public class FootballDataUtils {


    /**
     * @param footballDataList the list with all days that should be tested
     * @return the team name as {@link String}
     * @throws AssertionError if the input list is empty
     */
    public static String getTeamWithSmallestGoalSpread(List<PCFootballTeamData> footballDataList) {
        if (footballDataList == null || footballDataList.isEmpty()) {
            throw new IllegalArgumentException("illegal football data list " + (footballDataList == null ? "(NULL)" : "(EMPTY)"));
        }
        PCFootballTeamData teamWithSmallestGoalsAllowed = null;
        for (PCFootballTeamData data : footballDataList) {
            if (teamWithSmallestGoalsAllowed != null) {
                int goals1 = teamWithSmallestGoalsAllowed.getTotalGoals();
                int goalsAllowed1 = teamWithSmallestGoalsAllowed.getGoalsAllowed();
                int difference1 = Math.abs(goals1 - goalsAllowed1);

                int goals2 = data.getTotalGoals();
                int goalsAllowed2 = data.getGoalsAllowed();
                int difference2 = Math.abs(goals2 - goalsAllowed2);
                if (difference2 < difference1) {
                    teamWithSmallestGoalsAllowed = data;
                } else if (difference1 == difference2) {
                    // for the first time if there are two days with the same spread only notify via console
                    System.out.println("Team " + teamWithSmallestGoalsAllowed.getTeamName() + " and team " + data.getTeamName() + " have the same goal / goals allowed difference!");
                }
            } else {
                teamWithSmallestGoalsAllowed = data;
            }
        }
        assert teamWithSmallestGoalsAllowed != null;
        return teamWithSmallestGoalsAllowed.getTeamName();
    }


    /**
     * @param contentAsString the football data as array
     * @return a new instance of {@link PCFootballTeamData}
     * @throws NumberFormatException    if the file is wrong formatted
     * @throws IllegalArgumentException if the input array is wrong
     */
    public static PCFootballTeamData createFootballDataFromStringArray(String[] contentAsString) {
        if (contentAsString.length < 7) {
            throw new IllegalArgumentException("input string array has wrong size!");
        }
        PCFootballTeamData footballData = null;
        try {
            String teamName = contentAsString[0];
            int totalGoals = Integer.parseInt(contentAsString[5]);
            int totalGoalsAllowed = Integer.parseInt(contentAsString[6]);
            footballData = new PCFootballTeamData(teamName, totalGoals, totalGoalsAllowed);
        } catch (NumberFormatException e) {
            System.err.println("wrong format of file for weather data");
        }
        return footballData;
    }
}
