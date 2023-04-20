package com.game.cool;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    protected static void game() {
        //Element table:    1: Fire 2: Ice  3: Electricity  4: Earth    5: Light    6: Dark
        Scanner input = new Scanner(System.in);
        ArrayList<Characters> party = new ArrayList<>();
        ArrayList<Skills> skillsPlayer = new ArrayList<>();
        Skills.addSkills(skillsPlayer, "Agi");
        ArrayList<Skills> skillsDD = new ArrayList<>();
        Skills.addSkills(skillsDD, "Zio");

        System.out.println(
                """
                ----------------
                ~COOL GAME 2!!!~
                ----------------""");
        System.out.print("""
                Welcome! This is a 'remaster' of my old game I made in C.
                Remaster in quotes, cause it's more or less it's own thing now. Same characters just different story.
                First please enter your name:\040""");

        String stringInput = input.next();
        Characters.addNewPartyMember(party, 12, 15, 3, skillsPlayer, stringInput, 1);
        Characters.addNewPartyMember(party, 15, 6, 4, skillsDD, "DD", 1);
        if(stringInput.equals("Timotheus")){
            ArrayList<Skills> duckSkills = new ArrayList<>();
            ArrayList<Skills> ratSkills = new ArrayList<>();
            Skills.addSkills(ratSkills, "Magna");
            Skills.addSkills(ratSkills, "Magnara");
            Characters.addNewPartyMember(party, 30, 5, 3, ratSkills, "Rats", 2);
            Skills.addSkills(duckSkills, "Hama");
            Skills.addSkills(duckSkills, "Hamaon");
            party.add(new Characters(10, 30, 8, duckSkills, "Goose", 4));
            for(Characters characters : party){
                Characters.lvlUp(characters, new Enemy("", 0, 0 , 0, 0, 650));
            }
            Plot.part3(party);
        }
        Plot.part1(party);
        Plot.part2(party);
        Plot.part3(party);
    }
    public static void main(String[] args) {
        Main.game();
    }
}

class Battle {
    public static int bossBattleTime(ArrayList<Characters> party, Enemy enemy){
        int i = party.size();
        while (enemy.hp > 0) {
            for (Characters characters : party) {
                Battle.bossCombat(characters, enemy);
                if (characters.getHp() <= 0) {
                    i--;
                    if (i < 0) {
                        System.out.println("Good job dumbass, you and your friends died.");
                        return 0;
                    }
                }
            }
        }
        for (Characters characters : party) {
            Characters.lvlUp(characters, enemy);
        }
        return 1;
    }
    public static int battleTime(ArrayList<Characters> party, Enemy enemy) {
        int i = party.size();
        while (enemy.hp > 0) {
            for (Characters characters : party) {
                Battle.combat(characters, enemy);
                if (characters.getHp() <= 0) {
                    i--;
                    if (i < 0) {
                        System.out.println("Good job dumbass, you and your friends died.");
                        return 0;
                    }
                }
            }
        }
        for (Characters characters : party) {
            Characters.lvlUp(characters, enemy);
            characters.setHp(characters.getMaxHp());
            characters.setSp(characters.getMaxSP());
        }
        return 1;
    }

    public static void bossCombat(Characters character, Enemy enemy){
        if (character.getHp() < 1) {
            System.out.println(character.getName() + " is knocked out!");
            return;
        }
        character.setHurt(enemy.getDmg());
        int temp = character.getDmg();
        Battle.characterTurn(enemy, character);
        enemy.bossTurn();
        character.setHp(character.getHp() - character.getHurt());
        enemy.hp = enemy.hp - character.getDmg();
        character.setDmg(temp);
        if (enemy.hp <= 0) {
            System.out.println(enemy.getName() + " HP: 0");
            character.setHp(character.getMaxHp());
            character.setSp(character.getMaxSP());
        } else {
            System.out.println(enemy.getName() + " HP: " + enemy.hp);
        }
    }
    public static void combat(Characters character, Enemy enemy) {
        if (character.getHp() < 1) {
            System.out.println(character.getName() + " is knocked out!");
            return;
        }
        character.setHurt(enemy.getDmg());
        int temp = character.getDmg();

        Battle.characterTurn(enemy, character);

        character.setHp(character.getHp() - character.getHurt());
        enemy.hp = enemy.hp - character.getDmg();
        character.setDmg(temp);
        if (enemy.hp <= 0) {
            System.out.println(enemy.getName() + " HP: 0");
            character.setHp(character.getMaxHp());
            character.setSp(character.getMaxSP());
        } else {
            System.out.println(enemy.getName() + " HP: " + enemy.hp);
        }
    }
    public static void oneMore(Enemy enemy, Characters character){
        String input;
        Scanner myObj = new Scanner(System.in);
        do {
            System.out.println("One More!");
            System.out.println("\nWhat will " + character.getName() + " do?");
            System.out.println("HP: " + character.getHp());
            System.out.println("SP: " + character.getSp());
            if (character.getHp() < 0) {
                return;
            }
            System.out.println("-----------------------------------------------");
            System.out.println("[1] Attack [2] Skills [3] Guard [4] Check Enemy");
            System.out.println("-----------------------------------------------");
            input = myObj.nextLine();
            switch (input) {
                case "1" ->
                        System.out.println(character.getName() + " hit the enemy for " + character.getDmg() + " damage!");

                case "2" -> input = String.valueOf(character.useSkills(character, enemy));

                case "3" -> {
                    character.setHurt(0);
                    character.setDmg(0);
                    System.out.println(character.getName() + " blocked the incoming attack!");
                }
                case "4" -> {
                    character.setDmg(0);
                    enemy.printStats();
                }
                default -> System.out.println("Invalid input!");
            }
        } while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4"));
    }
    public static void characterTurn(Enemy enemy, Characters character){
        String input;
        Scanner myObj = new Scanner(System.in);
        do {
            System.out.println("\nWhat will " + character.getName() + " do?");
            System.out.println("HP: " + character.getHp());
            System.out.println("SP: " + character.getSp());
            if (character.getHp() < 0) {
                return;
            }
            System.out.println("-----------------------------------------------");
            System.out.println("[1] Attack [2] Skills [3] Guard [4] Check Enemy");
            System.out.println("-----------------------------------------------");
            input = myObj.nextLine();
            switch (input) {
                case "1" ->
                        System.out.println(character.getName() + " hit the enemy for " + character.getDmg() + " damage!");

                case "2" -> {
                    if (character.useSkills(character, enemy) == 1) {
                        Battle.oneMore(enemy, character);
                    }
                }

                case "3" -> {
                    character.setHurt(0);
                    character.setDmg(0);
                    System.out.println(character.getName() + " blocked the incoming attack!");
                }
                case "4" -> {
                    character.setDmg(0);
                    enemy.printStats();
                }
                default -> System.out.println("Invalid input!");
            }
        } while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4"));
    }
}

//hi timothy u are big gay >:[
//gay gay homosexual gay