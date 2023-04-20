package com.game.cool;

import java.util.ArrayList;
import java.util.Scanner;

public class Characters {
    private final ArrayList<Skills> skills;
    private final String name;
    private int maxHp;
    private int maxSP;
    private int xp;
    private int lvl;
    private int hp;
    private int sp;
    private int dmg;
    private int hurt;

    public Characters(int hp, int sp, int dmg, ArrayList<Skills> skills, String name, int lvl) {
        this.hp = hp;
        this.sp = sp;
        this.dmg = dmg;
        this.skills = skills;
        this.name = name;
        this.lvl = lvl;
        maxHp = hp;
        maxSP = sp;
    }

    public static void addNewPartyMember(ArrayList<Characters> party, int hp, int sp, int dmg, ArrayList<Skills> skills, String name, int lvl) {
        party.add(new Characters(hp, sp, dmg, skills, name, lvl));
    }

    public static void lvlUp(Characters characters, Enemy enemy) {
        characters.xp = characters.xp + enemy.getXp();
        while (characters.xp - 100 > 0) {
            System.out.println("\n-------------------------------------------------------------\n" + characters.name + " got " + enemy.getXp() + " experience points!");
            System.out.println(100 - characters.xp + " until next level");
            if (characters.xp >= 100) {
                characters.lvl++;
                System.out.println(characters.name + " is now level " + characters.lvl + "!\n");
                characters.dmg++;
                characters.maxSP = characters.maxSP + characters.lvl;
                characters.maxHp = characters.maxHp + characters.lvl;
                characters.xp = characters.xp - 100;
                characters.sp = characters.maxSP;
                characters.hp = characters.maxHp;
                for (Skills skills : characters.skills) {
                    String name = skills.name().substring(0, 2);
                    switch (name) {
                        case "Ag":
                            if (characters.lvl == 2) {
                                Skills.addSkills(characters.skills, "Agilao");
                                System.out.println(characters.name + " has learnt a new skill! \nAgilao");
                                return;
                            } else if (characters.lvl == 5) {
                                Skills.addSkills(characters.skills, "Agidyne");
                                System.out.println(characters.name + " has learnt a new skill! \nAgidyne");
                                return;
                            }
                            break;
                        case "Bu":
                            if (characters.lvl == 2) {
                                Skills.addSkills(characters.skills, "Bufula");
                                System.out.println(characters.name + " has learnt a new skill! \nBufula");
                                return;
                            } else if (characters.lvl == 5) {
                                Skills.addSkills(characters.skills, "Bufudyne");
                                System.out.println(characters.name + " has learnt a new skill! \nBufudyne");
                                return;
                            }
                            break;
                        case "Zi":
                            if (characters.lvl == 2) {
                                Skills.addSkills(characters.skills, "Zionga");
                                System.out.println(characters.name + " has learnt a new skill! \nZionga");
                                return;
                            } else if (characters.lvl == 5) {
                                Skills.addSkills(characters.skills, "Ziodyne");
                                System.out.println(characters.name + " has learnt a new skill! \nZiodyne");
                                return;
                            }
                            break;
                        case "Ma":
                            if (characters.lvl == 2) {
                                Skills.addSkills(characters.skills, "Magnara");
                                System.out.println(characters.name + " has learnt a new skill! \nMagnara");
                                return;
                            } else if (characters.lvl == 5) {
                                Skills.addSkills(characters.skills, "Magnadyne");
                                System.out.println(characters.name + " has learnt a new skill! \nMagnadyne");
                                return;
                            }
                            break;
                        case "Ha":
                            if (characters.lvl == 2) {
                                Skills.addSkills(characters.skills, "Hamaon");
                                System.out.println(characters.name + " has learnt a new skill! \nHamaon");
                                return;
                            } else if (characters.lvl == 5) {
                                Skills.addSkills(characters.skills, "Hamadyne");
                                System.out.println(characters.name + " has learnt a new skill! \nHamadyne");
                                return;
                            }
                            break;
                        case "Mu":
                            if (characters.lvl == 2) {
                                Skills.addSkills(characters.skills, "Mudoon");
                                System.out.println(characters.name + " has learnt a new skill! \nMudoon");
                                return;
                            } else if (characters.lvl == 5) {
                                Skills.addSkills(characters.skills, "Mudodyne");
                                System.out.println(characters.name + " has learnt a new skill! \nMudodyne");
                                return;
                            }
                            break;
                        default:
                            System.out.println("You messed up the skills");
                    }
                }
            }
        }
    }

    public int useSkills(Characters characters, Enemy enemy) {
        /*
        Element table:
        1: Fire
        2: Ice
        3: Electricity
        4: Earth
        5: Light
        6: Dark
        */
        Scanner myObj = new Scanner(System.in);
        int input;
        while (true) {
            Skills.printSkills(skills);
            System.out.print("\n\n[0] Return");
            System.out.println();
            input = myObj.nextInt() - 1;
            if (input == -1) {
                return 0;
            }
            for (int i = 0; i < skills.size(); i++) {
                if (input == i) {
                    dmg = 3;
                    switch (skills.get(i).name()) {
                        case "Agi", "Bufu", "Zio", "Magna", "Hama", "Mudo" -> {
                            if (sp - 3 < 0) {
                                System.out.println("Not enough SP!");
                            } else {
                                if (enemy.checkAffinities(skills.get(i).element()) == 1) {
                                    System.out.println("You hit the enemy's weakness!");
                                    dmg++;
                                    sp = sp - 3;
                                    dmg = dmg + 2;
                                    System.out.println(characters.name + " used " + skills.get(i).name() + " and hit for " + dmg + " damage!");
                                    return 1;
                                } else if (enemy.checkAffinities(skills.get(i).element()) == 2) {
                                    System.out.println("The enemy is resistant to that attack...");
                                    dmg--;
                                    sp = sp - 3;
                                    dmg = dmg + 2;
                                    System.out.println(characters.name + " used " + skills.get(i).name() + " and hit for " + dmg + " damage!");
                                    return 2;
                                } else{
                                    sp = sp - 3;
                                    dmg = dmg + 2;
                                    System.out.println(characters.name + " used " + skills.get(i).name() + " and hit for " + dmg + " damage!");
                                    return 0;
                                }
                            }
                        }
                        case "Agilao", "Bufula", "Zionga", "Magnara", "Hamaon", "Mudoon" -> {
                            if (sp - 5 < 0) {
                                System.out.println("Not enough SP!");
                            } else {
                                if (enemy.checkAffinities(skills.get(i).element()) == 1) {
                                    System.out.println("You hit the enemy's weakness!");
                                    dmg++;
                                    sp = sp - 5;
                                    dmg = dmg + 7;
                                    System.out.println(characters.name + " used " + skills.get(i).name() + " and hit for " + dmg + " damage!");
                                    return 1;
                                } else if (enemy.checkAffinities(skills.get(i).element()) == 2) {
                                    System.out.println("The enemy is resistant to that attack...");
                                    dmg--;
                                    sp = sp - 5;
                                    dmg = dmg + 7;
                                    System.out.println(characters.name + " used " + skills.get(i).name() + " and hit for " + dmg + " damage!");
                                    return 2;
                                } else {
                                    sp = sp - 5;
                                    dmg = dmg + 7;
                                    System.out.println(characters.name + " used " + skills.get(i).name() + " and hit for " + dmg + " damage!");
                                    return 0;
                                }
                            }
                        }
                        case "Agidyne", "Bufudyne", "Ziodyne", "Magnadyne", "Hamadyne", "Mudodyne" -> {
                            if (sp - 8 < 0) {
                                System.out.println("Not enough SP!");
                            } else {
                                if (enemy.checkAffinities(skills.get(i).element()) == 1) {
                                    System.out.println("You hit the enemy's weakness!");
                                    dmg++;
                                    sp = sp - 8;
                                    dmg = dmg + 12;
                                    System.out.println(characters.name + " used " + skills.get(i).name() + " and hit for " + dmg + " damage!");
                                    return 1;
                                } else if (enemy.checkAffinities(skills.get(i).element()) == 2) {
                                    System.out.println("The enemy is resistant to that attack...");
                                    dmg--;
                                    sp = sp - 8;
                                    dmg = dmg + 12;
                                    System.out.println(characters.name + " used " + skills.get(i).name() + " and hit for " + dmg + " damage!");
                                    return 2;
                                } else {
                                    sp = sp - 8;
                                    dmg = dmg + 12;
                                    System.out.println(characters.name + " used " + skills.get(i).name() + " and hit for " + dmg + " damage!");
                                    return 0;
                                }
                            }
                        }
                        default -> System.out.println("Dumbass, you fucked it");
                    }
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getHurt() {
        return hurt;
    }

    public void setHurt(int hurt) {
        this.hurt = hurt;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMaxSP() {
        return maxSP;
    }

    public void addSkill(String name) {
        Skills.addSkills(skills, name);
        System.out.println(this.name + " has learned " + name + "!");
    }
}
