package model;

import java.util.ArrayList;

public class Path {
    private String name;
    private ArrayList<Space> spaces;
    private Path path1, path2;

    // if current path is connected to 2 paths
    public Path(String name, Path path1, Path path2) {
        spaces = new ArrayList<>();
        this.name = name;
        this.path1 = path1;
        this.path2 = path2;
    }

    // if current path is connected to only 1 path
    public Path(String name, Path path1) {
        spaces = new ArrayList<>();
        this.name = name;
        this.path1 = path1;
    }

    public Path(String name) {
        spaces = new ArrayList<>();
        this.name = name;
    }

    public ArrayList<Space> getSpaces() {
        return spaces;
    }

    public String getName() {
        return name;
    }

    public Path getPath1() {
        return path1;
    }

    public Path getPath2() {
        return path2;
    }

    public int getNSpaces() {
        return spaces.size();
    }
}
