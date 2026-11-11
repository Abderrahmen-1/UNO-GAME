package UnoGame;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        // Welcome banner
        System.out.println("\n\n");
        System.out.println("			███████████████████████████████████████████████████████");
        System.out.println(" 			█                                                     █");
        System.out.println(" 			█            ██╗   ██╗███╗   ██╗ ██████╗              █");
        System.out.println(" 			█            ██║   ██║████╗  ██║██╔═══██╗             █");
        System.out.println(" 			█            ██║   ██║██╔██╗ ██║██║   ██║             █");
        System.out.println(" 			█            ██║   ██║██║╚██╗██║██║   ██║             █"); 
        System.out.println(" 			█            ╚██████╔╝██║ ╚████║╚██████╔╝             █");
        System.out.println(" 			█             ╚═════╝ ╚═╝  ╚═══╝ ╚═════╝              █");
        System.out.println(" 			█                                                     █");
        System.out.println(" 			█              🎮 BIENVENUE AU JEU UNO! 🎮            █");
        System.out.println(" 			█                 WELCOME TO UNO GAME!                █");
        System.out.println(" 			█                                                     █");
        System.out.println(" 			███████████████████████████████████████████████████████");
        System.out.println("\n");
        
        Scanner scan = new Scanner(System.in);
        int playersnumber;
        int choice;
        PlayerClass players[];
        GameClass game;

        do {
            System.out.println("Do you want to play vs computer or local?");
            System.out.println("1) Friends ");
            System.out.println("2) Bot  ");
            choice = scan.nextInt(); } while ( choice != 1 && choice != 2 );

        System.out.println("Please enter the number of players :");
        playersnumber = scan.nextInt();

        players = new PlayerClass[playersnumber];

        if ( choice == 1 ) {
            // Create players
            for (int i = 0; i < players.length; i++) {
                players[i] = new PlayerClass();
                System.out.println("The name of the player number "+(i+1));
                String name = scan.next();
                players[i].setName(name); }

             // create a game object
              game = new GameClass();

              game.setScanner(scan);

              // Put the players inside the game
              game.setPlayers(players);

            // Start the game (shuffle + distribution + first card)
              game.startGame();

              System.out.println("\n--- START PLAYING ---\n");

                while (!game.isGameOver()) {
                    game.SGame();
                }

                System.out.println("\n " + game.getWinner() + " WINS THE GAME!");

                System.out.println("\n--- GAME ENDED ---");

                game.getScanner().close();
            }

        else {

            // Create players
            players[0] = new PlayerClass() ; // the only human player
                System.out.println("Enter your name :\n");
                String name = scan.next();
                players[0].setName(name);

                // Create the botPlayers
                for ( int i = 1 ; i < playersnumber ; i++ ) {
                    players[i] = new BotPlayer();
                    System.out.println("Enter a name for your bots ( new friends ) :");
                    name = scan.next();
                    players[i].setName(name);  }

                // create a __Botgame__ object
                game = new BotGame();

                game.setScanner(scan);

                // Put the players inside the __Botgame__
                game.setPlayers(players);

                // Start the game (shuffle + distribution + first card)
                game.startGame();

                System.out.println("\n--- START PLAYING ---\n");

                // Keeping playing while the GameOver == false
                while (!game.isGameOver()) {
                    game.SGame();
                }

                System.out.println("\n " + game.getWinner() + " WINS THE GAME!");

                System.out.println("\n--- GAME ENDED ---");

                game.getScanner().close();
        }
    }
}

	    	
	