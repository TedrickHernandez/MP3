package model;

import java.util.ArrayList;

public class Space {
    private String name;
    private ArrayList<Player> players; // for GUI outputting purposes ONLY

    public Space(String insertName) {
        players = new ArrayList<>();
        name = insertName;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
