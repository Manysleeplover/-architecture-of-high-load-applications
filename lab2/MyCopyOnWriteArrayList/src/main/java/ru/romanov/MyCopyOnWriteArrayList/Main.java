package ru.romanov.MyCopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(points(new String[]{"3:1", "2:2", "0:1"}));
    }

    public static int points(String[] games) {
        int ourTeamPoints = 0;

        for (String game : games) {
            String[] points = game.split(":");
            if(Integer.parseInt(points[0]) > Integer.parseInt(points[1])){
                ourTeamPoints+=3;
            } else if (Integer.parseInt(points[0]) == Integer.parseInt(points[1])) {
                ourTeamPoints++;
            }
        }
        return ourTeamPoints;
    }
}
