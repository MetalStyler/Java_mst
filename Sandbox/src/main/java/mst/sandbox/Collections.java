package mst.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args) {
        String[] langs = {"Java", "C#", "Python", "PHP"};

        List<String> languages = new ArrayList<String>();
        languages.add("java");
        languages.add("python");
        languages.add("php");

        List<String> lang = Arrays.asList("Java", "C#", "Python", "PHP");

        for (String l : languages) {
            System.out.println("I want to learn " + l);
        }

        for (String l : langs) {
            System.out.println("I want to learn " + l);
        }

        for (int i = 0; i < lang.size(); i++) {
            System.out.println("I wanna learn " + lang.get(i));
        }
    }
}