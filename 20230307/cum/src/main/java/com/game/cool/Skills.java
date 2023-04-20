package com.game.cool;

import java.util.ArrayList;
import java.util.Scanner;

public record Skills(String name, int element) {

    public static void addSkills(ArrayList<Skills> skillList, String name) {
        /*
            Element table:
            1: Fire
            2: Ice
            3: Electricity
            4: Earth
            5: Light
            6: Dark
        */
        switch (name) {
            case "Agi", "Agilao", "Agidyne" -> skillList.add(new Skills(name, 1));
            case "Bufu", "Bufula", "Bufudyne" -> skillList.add(new Skills(name, 2));
            case "Zio", "Zionga", "Ziodyne" -> skillList.add(new Skills(name, 3));
            case "Magna", "Magnara", "Magnadyne" -> skillList.add(new Skills(name, 4));
            case "Hama", "Hamaon", "Hamadyne" -> skillList.add(new Skills(name, 5));
            case "Mudo", "Mudoon", "Mudodyne" -> skillList.add(new Skills(name, 6));
        }
    }

    public static void rmSkill(ArrayList<Skills> skillList) {
        Scanner myObj = new Scanner(System.in);
        while (true) {
            printSkills(skillList);
            System.out.println("\nWhich skill would you like to remove?");
            int input = myObj.nextInt() - 1;
            System.out.println("Are you sure you wish to remove " + skillList.get(input).name + "? [y/n]");
            String ynInput = myObj.next();
            if (ynInput.equals("y") || ynInput.equals("Y")) {
                skillList.remove(input);
                System.out.println("Current Skills:");
                printSkills(skillList);
                System.out.println();
                return;
            } else if (!ynInput.equals("n") && !ynInput.equals("N")) {
                System.out.println("Invalid input");
            }
        }
    }

    public static void printSkills(ArrayList<Skills> skillList) {
        for (int i = 0; i < skillList.size(); i++) {
            switch (skillList.get(i).name()) {
                case "Agi", "Bufu", "Zio", "Magna", "Hama", "Mudo" -> {
                    System.out.print("\n[" + (i + 1) + "] " + skillList.get(i).name() + " (3 SP)\t");
                    if ((i + 1) % 4 == 0) {
                        System.out.println();
                    }
                }
                case "Agilao", "Bufula", "Zionga", "Magnara", "Hamaon", "Mudoon" -> {
                    System.out.print("\n[" + (i + 1) + "] " + skillList.get(i).name() + " (5 SP)\t");
                    if ((i + 1) % 4 == 0) {
                        System.out.println();
                    }
                }
                case "Agidyne", "Bufudyne", "Ziodyne", "Magnadyne", "Hamadyne", "Mudodyne" -> {
                    System.out.print("\n[" + (i + 1) + "] " + skillList.get(i).name() + " (8 SP)\t");
                    if ((i + 1) % 4 == 0) {
                        System.out.println();
                    }
                }
            }
        }
    }
}
