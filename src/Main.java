import java.util.Random;
import java.util.Scanner;
// removed unused import

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
                             ,//('(          |__>--<__|     /
                            ( ( '))          |__>--<__|    |
                         `-)) )) (           |__>--<__|    |
                        ,/,'//( (             \\\\__>--<__\\\\    \\\\
                      ,( ( ((, ))              ~-__>--<_~-_  ~--____---~'_/'//'
                    `~/  )` ) ,/|                 ~-_~>--<_/-__       __-~ _/
                  ._-~//( )/ )) `                    ~~-'_/_/ /~~~~~~~__--~
                   ;'( ')/ ,)(                              ~~~~~~~~~~
                  ' ') '( (/
                """;

        System.out.println(splashScreen);
        System.out.println();

        // Grab User Configuration data points
        Scanner scanner = new Scanner(System.in);


        Hero hero = new Hero();
        System.out.print("Enter Hero HP: ");

        int userInput = scanner.nextInt();
        hero.setHitPoints(userInput);
        System.out.print("Enter Hero's Damage: ");
        userInput = scanner.nextInt();
        hero.setDamage(userInput);


        // Dragon HP and Damage
        Dragon[] dragons = new Dragon[3];
        dragons[0] = new Dragon(1000, 200);
        dragons[1] = new Dragon(1000, 200);
        dragons[2] = new Dragon(1000, 200);

        while (true) {
            System.out.println("Hero has " + hero.getHitPoints() + " HP and " + hero.getDamage() + " points of damage!");
            printDragonStatus(dragons);

            if ((hero.getHitPoints() < 1) || (dragons[0].getHitPoints() < 1 && dragons[1].getHitPoints() < 1 && dragons[2].getHitPoints() < 1)) {
                break;
            }

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


                System.out.println("Its your turn to attack! Which Dragon will you hit?");
                dragonChoice = scanner.nextInt();
                System.out.println();

                heroAttackDragon(dragons, dragonChoice, hero.getDamage(), random);

            }

            System.out.println("""
                    ██╗   ██╗███╗   ██╗██████╗ ███████╗██████╗      █████╗ ████████╗████████╗ █████╗  ██████╗██╗  ██╗
                    ██║   ██║████╗  ██║██╔══██╗██╔════╝██╔══██╗    ██╔══██╗╚══██╔══╝╚══██╔══╝██╔══██╗██╔════╝██║ ██╔╝
                    ██║   ██║██╔██╗ ██║██║  ██║█████╗  ██████╔╝    ███████║   ██║      ██║   ███████║██║     █████╔╝ 
                    ██║   ██║██║╚██╗██║██║  ██║██╔══╝  ██╔══██╗    ██╔══██║   ██║      ██║   ██╔══██║██║     ██╔═██╗ 
                    ╚██████╔╝██║ ╚████║██████╔╝███████╗██║  ██║    ██║  ██║   ██║      ██║   ██║  ██║╚██████╗██║  ██╗
                     ╚═════╝ ╚═╝  ╚═══╝╚═════╝ ╚══════╝╚═╝  ╚═╝    ╚═╝  ╚═╝   ╚═╝      ╚═╝   ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝
                    """);

            dragonsAttackHero(dragons, hero);

        }

        System.out.println("Battle Outcome");
        System.out.println("*************");
        System.out.println("Hero has " + hero.getHitPoints() + " HP and " + hero.getDamage() + " points of damage!");
        printDragonStatus(dragons);

        if (hero.getHitPoints() < 1) {
            System.out.println("You have fallen in battle...");
        } else {
            System.out.println("You Bested the dragons!");
        }
    }

    private static void heroAttackDragon(Dragon[] dragons, int dragonChoice, int heroDamage, Random random) {

        Dragon target = dragons[dragonChoice - 1];

        if (target.getHitPoints() < 1) {
            System.out.println("Dragon " + dragonChoice + " is already dead!");
            return;
        }

        int heroHitsForDmg = random.nextInt(heroDamage);
        target.setHitPoints(target.getHitPoints() - heroHitsForDmg);

        System.out.println("You hit Dragon " + dragonChoice + " for " + heroHitsForDmg + " HP!");

    }

    private static void dragonsAttackHero(Dragon[] dragons, Hero hero) {
        //Dragons attack Hero
        Random random = new Random();
        for (int i = 0; i < dragons.length; i++) {
            if (dragons[i].getHitPoints() > 0) {
                int dragonHitsForDmg = random.nextInt(dragons[i].getDamage());
                int newHitPoints = hero.getHitPoints() - dragonHitsForDmg;
                hero.setHitPoints(newHitPoints);
            }
        }
    }

    // now inside class
    private static void printDragonStatus(Dragon[] dragons) {
        System.out.println("Dragons Status");
        System.out.println("--------------");

        for (int i = 0; i < dragons.length; i++) {
            System.out.println("Dragon " + (i + 1) + " " + dragons[i].getHitPoints() + " HP and deals " + dragons[i].getDamage() + " points of damage");
        }
    }
}