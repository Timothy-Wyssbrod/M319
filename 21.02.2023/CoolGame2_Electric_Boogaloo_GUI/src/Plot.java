import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Plot {
    private static final Scanner input = new Scanner(System.in);
    private static String stringInput;
    private static int assholeLevel = 0;

    public static void part1(ArrayList<Characters> party) {
        System.out.println("""
                \nYou are a "lone" wanderer. You are accompanied by your trusty companion Diamond Dog(DD).
                Together you two live a relatively happy life. You both live for each other.
                You two decide that, since you are low on food, that you must make you way to the Grocery store.
                On your way you are ambushed by a Thug. What will you do?
                [1] Fight [2] Run
                """);
        stringInput = input.next();
        if (stringInput.equals("1")) {
            if (Battle.battleTime(party, new Enemy("Thug", 1, 4, 3, 15, 45)) == 0) {
                exit(0);
            }
        } else if (stringInput.equals("2")) {
            System.out.println("You hurried off and managed to escape the thug. You continued on your way.");
        } else {
            System.out.println("You decided not to answer correctly, so I'll take over. You slit his throat before he even approached you\n"
                    + "Don't try me. I'll do it again");
            assholeLevel++;
        }
    }

    public static void part2(ArrayList<Characters> party) {
        System.out.println("""
                \nYou had continued after your encounter with the Thug. You made your way to the grocers.
                You managed to scrape enough money together to get yourself and your dog companion a snack.
                It's moments like these that remind you, that life isn't all that bad.
                                
                On the sidewalk you see a lone rat. Feeling sorry for it you decide to give it a tiny bit of the food you had.
                Suddenly an entire swarm emerged. Will you feed them? [y/n]
                """);
        stringInput = input.next();
        if (stringInput.equals("y")) {
            ArrayList<Skills> ratSkills = new ArrayList<>();
            Skills.addSkills(ratSkills, "Magna");
            Skills.addSkills(ratSkills, "Magnara");
            System.out.println("The rats appreciated your kindness. They wished to repay the kindness. They decided to follow you\n" + "Hoard of Rats(Rats) has joined you party!");
            Characters.addNewPartyMember(party, 30, 5, 3, ratSkills, "Rats", 2);
        } else if (stringInput.equals("n")) {
            System.out.println("You decided you did not have enough food to share it with them. And with that thought you continued on.");
        } else if (assholeLevel > 0) {
            System.out.println("As you decided not to answer correctly you decided to stomp the fuckers to death.\n" + "I warned you didn't I?");
        } else {
            System.out.println("As you decided not to answer correctly you decided to stomp the fuckers to death.\n" + "Don't try me, I'll fucking do it again");
        }
        System.out.println("""
                You ventured into the woods, where, upon a forest path, you find someone you didn't expect to see...
                It was your aunt. She notices you, and while her demeanor seems cheery, you sense a certain coldness behind her eyes.
                She tells you that she has a gift for you, all the while she grabs something from her basket... it's a knife!
                She slashes at you while you do your best to dodge her attacks. It seems you don't have a choice, you must fight her.""");
        if (Battle.battleTime(party, new Enemy("Aunt", 4, 1, 6, 25, 100)) == 0) {
            exit(0);
        } else {
            System.out.println("Your aunt is helplessly pinned to the floor by DD, what will you do?\n" + "[1] Finish her [2] Spare her");
        }
        stringInput = input.next();
        if (stringInput.equals("1")) {
            System.out.print("""
                    You felt as though you had no choice, fearing that she might try to kill you instead, you end her then and there.
                    You watch her bleed out on the forest floor as you catch your breath. Though suddenly a small duck emerges from behind a tree.
                    This duck seems to be quite fond of you, you can't understand why though. It wishes to follow you.
                    You felt as though you should give it a name, so you decide to name it Goose.
                                        
                    Duck(Goose) has joined your party!
                    """);
            ArrayList<Skills> duckSkills = new ArrayList<>();
            Skills.addSkills(duckSkills, "Hama");
            Skills.addSkills(duckSkills, "Hamaon");
            party.add(new Characters(10, 30, 8, duckSkills, "Goose", 4));
        } else if (stringInput.equals("2")) {
            System.out.println("""
                    You decided that, despite everything, she's still your aunt and that she doesn't deserve to die.
                    After which she realised the errors of her ways. She decided to follow you.
                    Aunt(Aunt) has joined your party!
                    """);
            ArrayList<Skills> auntSkills = new ArrayList<>();
            Skills.addSkills(auntSkills, "Mudo");
            Skills.addSkills(auntSkills, "Mudoon");
            party.add(new Characters(25, 10, 2, auntSkills, "Aunt", 4));
        } else {
            System.out.println("You decided not to answer properly, so you left her there, leaving her to fend for herself in these dangerous woods.");
        }
    }

    public static void part3(ArrayList<Characters> party) {
        if (party.size() == 4) {
            System.out.println("You and your new ally continued on your journey, before you stumble upon a wizards tower.");
        } else {
            System.out.println("You continued your journey before you stumble upon a wizards tower.");
        }
        System.out.println("""
                While approaching it you are greeted by a wizard. He pulls out a tome and begins to speak.
                "Dear child, I have no pupil upon whom I can imbue my knowledge, please let me teach you".
                You grab his tome and flip through the pages. You seem to only be able to memorize one spell.
                Which would you like to learn?
                """);
        do {
            System.out.println("""
                    [1] Bufu (Ice)
                    [2] Zio (Electricity)
                    [3] Magna (Earth)
                    [4] Hama (Light)
                    [5] Mudo (Dark)
                    """);
            stringInput = input.next();
            switch (stringInput) {
                case "1" -> party.get(0).addSkill("Bufu");
                case "2" -> party.get(0).addSkill("Zio");
                case "3" -> party.get(0).addSkill("Magna");
                case "4" -> party.get(0).addSkill("Hama");
                case "5" -> party.get(0).addSkill("Mudo");
                default -> System.out.println("Invalid input!");
            }
        } while (!stringInput.equals("1") && !stringInput.equals("2") && !stringInput.equals("3") && !stringInput.equals("4") && !stringInput.equals("5"));
        System.out.println("""
                You left the wizard and continued onward. You found yourself on the precipice of a cliff. You couldn't see the bottom.
                After a while of contemplating on how to continue, you found yourself facing something indescribable. It was a creature consisting of pure light.
                                
                It spoke to you "You wish to usurp me and my rule over this universe, so, one as foolish as you has finally appeared."
                Your obvious confusion was clearly visible on your face.
                It picked up on this and stated: "Do you not wish to sit upon the eternal throne and gain power unlimited?"
                You still don't answer, as an answer to this situation is beyond you.
                The being began to explain: "This before you is the eternal throne. The Empyrean. I am the almighty creator, and you wish to steal that title from me."
                                
                You didn't know that that's what you wanted, but it sounded like a good time, so you went along with it. You and your friends readied for battle.
                "Woah woah, not so fast", it said, "first you must find the three keys to the Empyreal, the pillar upon which the throne rests.
                For that you must defeat three gods of old, all of which used to rest upon this very throne, never giving up the key which they possessed."
                                
                This is starting to sound less fun, but you don't really have much else to do, so you still play along with it.
                                
                "First you must defeat Zeus, god of thunder and ruler of olympus. Next you must battle Odin, all father of the norse and seeker of knowledge.
                And finally you must defeat Khonsu, son of Ra and god of the moon. Each possess a key to the Empyreal. You shall meet me at the peak."
                                
                The light disappeared and you were left dumbfounded. You didn't know where any of these gods were, so you just, decided to leave.
                What else is there to do. Though, just as you wanted to go home and make yourself a sandwich, A bolt of lightning landed before you.
                                
                "You wish to sit upon the Empyrean, do you?", shouted a loud and deep voice from behind you,
                "If that is truly what you wish, you will have to take my key. The key of benevolence!"
                You tried to explain to the guy, that you just didn't care, but he wouldn't have it.
                                
                "You dare disgrace me, Zeus! King of Olympus, ruler of the skies!"
                You look him in the eyes and nod your head. He is absolutely furious at this point.
                                
                "I don't even care anymore, now you're dead!" Zeus leaps at you and immediately begins to fight you.
                """);
        if (Battle.battleTime(party, new Enemy("Zeus", 6, 3, 5, 35, 150)) == 1) {
            System.out.println("Zeus has been slain, all that's left of him is the key he promised.\n" + party.get(0).getName() + " obtained key of benevolence!");
        } else {
            exit(1);
        }
        System.out.println("""
                You picked up the key, because why shouldn't you and as you made your way out you were halted by another god.
                A deep and stoic voice called out to you: "If you seek the keys to the Empyrean, you shall have to face me!"
                You calmly explain to him that you don't really care about the keys or the throne anymore, but he wasn't having it.
                                
                "You already possess a key, do you not?", the god asked. You held up the key of benevolence.
                "So, if I ever wish to sit upon the throne again I must take it."
                You try to offer it to him but before you get the chance to he leaps at you, exclaiming: "I Odin, all father of the norse take your key and your life!"
                """);
        if (Battle.battleTime(party, new Enemy("Odin", 3, 2, 10, 40, 150)) == 1) {
            System.out.println("""
                    "Well done!", exclaimed Odin, barely breathing, "You have bested me, here take my key, the key of harmony."
                    He collapses at this point, you can only assume he's dead.
                    """);
            System.out.println(party.get(0).getName() + " got key of harmony!");
            System.out.println("""
                    You once again try to make your leave, keys in hand, before you are interrupted again.
                    "You have already obtained two keys, have you?", said the god standing before you.
                    "Well that makes my life a lot easier, now I don't have to go up against Zeus or Odin.
                    Either way, I'll be taking those keys, and for that I shall use the power which I inherited from my father.
                    I shall don the Mask of Ra and obtain rule over the sun and moon. Prepare yourself!"
                    And just like the others, he refuses to listen and attacks you.
                    """);
        } else {
            exit(1);
        }
        if (Battle.battleTime(party, new Enemy("Khonsu Ra", 5, 1, 10, 50, 200)) == 1) {
            System.out.println("""
                    "It seems that even with the power of Ra I am still no match for you. Here take the final key, the key of austerity"
                    Khonsu died then and there.
                    """ + party.get(0).getName() + " got key of austerity!");
        } else {
            exit(1);
        }
        System.out.println("""
                With all three keys in hand you made your way towards the cliff again wishing to finally end all this stupidity.
                You held them up, expecting this "God" character to accept them and finally let you kill him and get it over with.
                To your surprise, nothing happened. So annoyed by everything that has happened, you threw the keys off the cliff.
                After which this "God" made his appearance. You didn't let him speak. You just wanted this over with.
                """);
        if (Battle.battleTime(party, new Enemy("God", 0, 5, 10, 50, 0)) == 1) {
            System.out.println("""
                    
                    
                    "Did you really think that would be enough to beat me? Think again! Now I'll show you my true power! Prepare to fight against the true god of this world!"
                    """);
            if (Battle.bossBattleTime(party, new Enemy("True God", 0, 6, 20, 150, 0)) == 1) {
                System.out.println("""
                        
                        You didn't give him the chance to talk to you, you ended him then and there, after which you were met with a winding stair case.
                        You followed it, your friends right behind you, all the way to the peak. At the peak you found the throne.
                        You sat on it, gaining all the power and knowledge of the world.
                                            
                        Your first course of action was to blow the fucking thing up.
                        
                        Before you knew it, you found yourself in the middle of a familiar street, one that leads to the grocers, all alone.
                        On the side of the road you find a stray pup. It seems interested in you. You decide to give it some of your food.
                        
                        
                        
                        
                        
                        That's it by the way, that's the end.
                        """);
            }else{
                exit(1);
            }
        } else {
            exit(1);
        }
    }
}
