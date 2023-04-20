package com.game.cool;

import javafx.util.converter.IntegerStringConverter;

import java.util.Random;

public class Enemy {
    private final String name;
    private final int weakness;
    private final int resistance;
    private final int dmg;
    private final int xpGiven;
    public int hp;

    public Enemy(String name, int weakness, int resistance, int dmg, int hp, int xpGiven) {
        this.name = name;
        this.weakness = weakness;
        this.resistance = resistance;
        this.dmg = dmg;
        this.hp = hp;
        this.xpGiven = xpGiven;
    }

    public int checkAffinities(int affinity) {
        if (affinity == weakness) {
            hp--;
            return 1;
        }
        if (affinity == resistance) {
            hp++;
            return 2;
        }
        return 0;
    }

    public void printStats() {
        System.out.println("Name: " + name);
        System.out.println("Attack: " + dmg);
        System.out.print("Weakness: ");
        switch (weakness) {
            case 1 -> System.out.println("Fire (Agi)");
            case 2 -> System.out.println("Ice (Bufu)");
            case 3 -> System.out.println("Electricity (Zio)");
            case 4 -> System.out.println("Earth (Magna)");
            case 5 -> System.out.println("Light (Hama)");
            case 6 -> System.out.println("Dark (Mudo)");
            default -> System.out.println("None");
        }

        System.out.print("Resistance: ");
        switch (resistance) {
            case 1 -> System.out.println("Fire (Agi)");
            case 2 -> System.out.println("Ice (Bufu)");
            case 3 -> System.out.println("Electricity (Zio)");
            case 4 -> System.out.println("Earth (Magna)");
            case 5 -> System.out.println("Light (Hama)");
            case 6 -> System.out.println("Dark (Mudo)");
            default -> System.out.println("None");
        }
    }
    public void bossTurn(){
        Random rand = new Random();
        int random = rand.nextInt(6);
        switch (random) {
            case 0 -> System.out.println(name + " used Maragidyne!");
            case 1 -> System.out.println(name + " used Mabufudyne!");
            case 2 -> System.out.println(name + " used Maziodyne!");
            case 3 -> System.out.println(name + " used Mamagnadyne!");
            case 4 -> System.out.println(name + " used Mahamadyne!");
            case 5 -> System.out.println(name + " used Mamudodyne!");
        }
        System.out.println(name + " hit for " + dmg + " dmg!");
    }

    public String getName() {
        return name;
    }

    public int getDmg() {
        return dmg;
    }

    public int getXp() {
        return xpGiven;
    }
}
