import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("Welcome to Man vs. Dragons!");
        System.out.println("");

        // Splash page
        System.out.println("");
        String splashScreen = """
                                               _
                                            ==(W{==========-      /===-
                                              ||  (.--.)         /===-_---~~~~~~~~~------____
                                              | \\\\_,|**|,__      |===-~___                _,-' `
                                 -==\\\\        `\\\\ ' `--'   ),    `//~\\\\   ~~~~`---.___.-~~
                             ______-==|        /`\\\\_. .__/\\\\ \\\\    | |  \\\\           _-~`
                       __--~~~  ,-/-==\\\\      (   | .  |~~~~|   | |   `\\\\        ,'
                    _-~       /'    |  \\\\     )__/==0==-\\\\<>/   / /      \\\\      /
                  .'        /       |   \\\\      /~\\\\___/~~\\\\/  /' /        \\\\   /'
                 /  ____  /         |    \\\\`\\\\.__/-~~   \\\\  |_/'  /          \\\\/'
                /-'~    ~~~~~---__  |     ~-/~         ( )   /'        _--~`
                                  \\\\_|      /        _) | ;  ),   __--~~
                                    '~~--_/      _-~/- |/ \\\\   '-~ \\\\
                                   {\\\\__--_/}    / \\\\_>-|)<__\\\\      \\\\
                                   /'   (_/  _-~  | |__>--<__|      |
                                  |   _/) )-~     | |__>--<__|      |
                                  / /~ ,_/       / /__>---<__/      |
                                 o-o _//        /-~_>---<__-~      /
                                 (^(~          /~_>---<__-      _-~
                                ,/|           /__>--<__/     _-~
                             ,//('(          |__>--<__|     /                  .----_
                            ( ( '))          |__>--<__|    |                 /' _---_~\\\\
                         `-)) )) (           |__>--<__|    |                /'  /     ~\\\\`\\\\
                        ,/,'//( (             \\\\__>--<__\\\\    \\\\            /'  //        ||
                      ,( ( ((, ))              ~-__>--<_~-_  ~--____---~' _/'/        /'
                    `~/  )` ) ,/|                 ~-_~>--<_/-__       __-~ _/
                  ._-~//( )/ )) `                    ~~-'_/_/ /~~~~~~~__--~
                   ;'( ')/ ,)(                              ~~~~~~~~~~
                  ' ') '( (/
                """;

        System.out.println(splashScreen);
        System.out.println();

        // Grab User Configuration data points
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Hero HP: ");
        int heroHP = scanner.nextInt();
        System.out.print("Enter Hero's Damage: ");
        int heroDamage = scanner.nextInt();


        // Dragon HP and Damage
        int dragon1hp = 100;
        int dragon1Damage = 20;
        int dragon2hp = 100;
        int dragon2Damage = 20;
        int dragon3hp = 100;
        int dragon3Damage = 20;



        while(true) {
            System.out.println("Hero has " + heroHP + " HP and " + heroDamage + " points of damage!");
            System.out.println("Dragon Status");
            System.out.println("***************");
            System.out.println("Dragon 1 has " + dragon1hp + " HP and deals " + dragon1Damage + " points of damage!");
            System.out.println("Dragon 2 has " + dragon2hp + " HP and deals " + dragon2Damage + " points of damage!");
            System.out.println("Dragon 3 has " + dragon3hp + " HP and deals " + dragon3Damage + " points of damage!");

            // Starts the battle until all dragons are dead or hero is dead
            if ((heroHP < 1) || (dragon1hp < 1 && dragon2hp < 1 && dragon3hp < 1)) {
                break;
            }

            //Logic behind the hero attacking
            int dragonChoice = 0;
            while (dragonChoice < 1 || dragonChoice > 3) {
                System.out.println("""
██╗   ██╗ ██████╗ ██╗   ██╗██████╗     ████████╗██╗   ██╗██████╗ ███╗   ██╗
╚██╗ ██╔╝██╔═══██╗██║   ██║██╔══██╗    ╚══██╔══╝██║   ██║██╔══██╗████╗  ██║
 ╚████╔╝ ██║   ██║██║   ██║██████╔╝       ██║   ██║   ██║██████╔╝██╔██╗ ██║
  ╚██╔╝  ██║   ██║██║   ██║██╔══██╗       ██║   ██║   ██║██╔══██╗██║╚██╗██║
   ██║   ╚██████╔╝╚██████╔╝██║  ██║       ██║   ╚██████╔╝██║  ██║██║ ╚████║
   ╚═╝    ╚═════╝  ╚═════╝ ╚═╝  ╚═╝       ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝
""");
                System.out.println("It's your turn to attack! Which Dragon would you like to attack(1, 2, 3)?");
                dragonChoice = scanner.nextInt();
            }
            System.out.println("Attacking dragon " + dragonChoice + "!");

            if (dragonChoice == 1) {
                if (dragon1hp < 1) {
                    System.out.println("Dragon 1 has already been slain. You wasted your turn!");

                } else {
                    int heroHitsForDmg = random.nextInt(heroDamage);
                    dragon1hp = dragon1hp - heroDamage;
                    System.out.println("You did " + heroHitsForDmg + " damage to dragon 1!");
                }

            } else if (dragonChoice == 2) {
                if (dragon2hp < 1) {
                    System.out.println("Dragon 2 has already been defeated! You lose your turn!");
                } else {
                    int heroHitsForDmg = random.nextInt(heroDamage);
                    dragon2hp = dragon2hp - heroHitsForDmg;
                    System.out.println("You did " + heroHitsForDmg + " damage to dragon 2!");
                }

            } else if (dragonChoice == 3) {
                if (dragon3hp < 1) {
                    System.out.println("Dragon 1 has already been defeated! You lose your turn!");
                } else {
                    int heroHitsForDmg = random.nextInt(heroDamage);
                    dragon3hp = dragon3hp - heroHitsForDmg;
                    System.out.println("You did " + heroHitsForDmg + " damage to dragon 3!");
                }
            }

            //Dragons attacking  phase
            System.out.println("""
██╗   ██╗███╗   ██╗██████╗ ███████╗██████╗      █████╗ ████████╗████████╗ █████╗  ██████╗██╗  ██╗
██║   ██║████╗  ██║██╔══██╗██╔════╝██╔══██╗    ██╔══██╗╚══██╔══╝╚══██╔══╝██╔══██╗██╔════╝██║ ██╔╝
██║   ██║██╔██╗ ██║██║  ██║█████╗  ██████╔╝    ███████║   ██║      ██║   ███████║██║     █████╔╝ 
██║   ██║██║╚██╗██║██║  ██║██╔══╝  ██╔══██╗    ██╔══██║   ██║      ██║   ██╔══██║██║     ██╔═██╗ 
╚██████╔╝██║ ╚████║██████╔╝███████╗██║  ██║    ██║  ██║   ██║      ██║   ██║  ██║╚██████╗██║  ██╗
 ╚═════╝ ╚═╝  ╚═══╝╚═════╝ ╚══════╝╚═╝  ╚═╝    ╚═╝  ╚═╝   ╚═╝      ╚═╝   ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝
""");
            System.out.println("The dragons are attacking now!");
            if (dragon1hp > 0) ; {
                int dragonHitsForDmg = random.nextInt(dragon1Damage);
                heroHP = heroHP - dragonHitsForDmg;
                System.out.println("Dragon 1 hit you for" + dragonHitsForDmg + "damage!");
            }
            if(dragon2hp  > 0); {
                int dragonHitsForDmg = random.nextInt(dragon2Damage);
                heroHP = heroHP - dragonHitsForDmg;
                System.out.println("Dragon 2 hit you for" + dragonHitsForDmg + "damage!");
            }
            if (dragon3hp  > 0);{
                int dragonHitsForDmg = random.nextInt(dragon3Damage);
                heroHP = heroHP - dragonHitsForDmg;
                System.out.println("Dragon 3 hit you for" + dragonHitsForDmg + "damage!");
            }

        }
        System.out.println("Battle Outcome");
        System.out.println("*************");
        System.out.println("Hero has " + heroHP + " HP and " + heroDamage + " points of damage!");
        System.out.println("Dragon 1 has " + dragon1hp + " HP and deals " + dragon1Damage + " points of damage!");
        System.out.println("Dragon 2 has " + dragon2hp + " HP and deals " + dragon2Damage+ " points of damage!");
        System.out.println("Dragon 3 has " + dragon3hp +  " HP and deals " + dragon3Damage+ " points of damage!");
        if(heroHP < 1) {
            System.out.println("You have fallen in battle...");
        } else {
            System.out.println("""
██╗   ██╗██╗ ██████╗████████╗ ██████╗ ██████╗ ██╗ ██████╗ ██╗   ██╗███████╗
██║   ██║██║██╔════╝╚══██╔══╝██╔═══██╗██╔══██╗██║██╔═══██╗██║   ██║██╔════╝
██║   ██║██║██║        ██║   ██║   ██║██████╔╝██║██║   ██║██║   ██║███████╗
╚██╗ ██╔╝██║██║        ██║   ██║   ██║██╔══██╗██║██║   ██║██║   ██║╚════██║
 ╚████╔╝ ██║╚██████╗   ██║   ╚██████╔╝██║  ██║██║╚██████╔╝╚██████╔╝███████║
  ╚═══╝  ╚═╝ ╚═════╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝
""");
            System.out.println(
                    """
                               . ,
                             <( .)>
                              //'
                             //                |||
                          __//_   _,,,,,    \\_///|
                         /___\\\\  (.  __\\_   \\_,_/
                        / Q--\\'  |_o \\:::)  / |
                       /.(|_______)\\___/___/-.|
                       |  / /' \\ _  ~ \\_  /  /
                       .---/__  ""\"\\_/""_/--'
                             /\\......./
                            (_/_ _,,_/
                             ;;;;[X];__
                            /# . ._) . )-----.
                           /. . . .\\. /   , __>
                    ((     | . . . .|__-( __/
                             . . . .   |__/
                             ) .--., )  >Xxx
                             //  _>)/    / X\\
                            (/  __/     O  X\\
                             / __/       \\ X\\
                             |__/         `._\\  ))
                             Xxx<
                             / X\\
                            O  X\\
                             \\ X\\
                            ,,`._\\,,,,, ,,
                    """);
            System.out.println("You Bested the dragons!");
        }


    }
}