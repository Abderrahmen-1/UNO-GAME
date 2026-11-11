
package UnoGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
 

public class GameClass {

    private PlayerClass[] players;
    private int currentPlayerIndex;
    private int direction;
    private DeckClass deck = new DeckClass();
    private List<CardClass> discardPile;
    private boolean gameOver;
    protected Scanner scan;

    public void setScanner(Scanner scan) {  // and we gonna use this every time we need a scaner 
        this.scan = scan;
    }
    
    public Scanner getScanner() {  // same thing 
    	return this.scan;
    } 
    
    public GameClass() {
    	this.currentPlayerIndex = 0;
        this.direction = 1;
        this.deck = new DeckClass();
        this.discardPile = new ArrayList<>();
        this.gameOver = false;

    }

    public void startGame() {
        deck.shuffle();
        Distribution();   // correct distribution

        CardClass firstcard = deck.getDeck().remove(0);
        discardPile.add(firstcard);
        System.out.println("the card on the table is : " + firstcard);
    } 

    // give 7 cards to each existing player
    public void Distribution() {
        for (int p = 0; p < players.length; p++) {
            for (int i = 0; i < 7; i++) {
                players[p].getHand().add(deck.getDeck().remove(0));
            }
        }
    }
    
    public int getPlayerIndex() {
		return this.currentPlayerIndex;
	}
	
	public void setPlayerIndex( int currentPlayerIndex) {
		this.currentPlayerIndex = currentPlayerIndex ; 
	}
	
	public PlayerClass getNextPlayer() {
	    int nextIndex = (currentPlayerIndex + direction + players.length) % players.length;
	    return players[nextIndex];
	}
	
	public PlayerClass getPlayer(int currentPlayerIndex) {
		return this.players[this.currentPlayerIndex];
	}
	
	public void setPlayer(int currentPlayerIndex) {
		this.players[this.currentPlayerIndex] = this.players[currentPlayerIndex];
	}
	
	public int getCurrentPlayerIndex() {
		return this.currentPlayerIndex ; 
	}
	
	public void setCurrentPlayerIndex( int currentPlayerIndex ) {
		this.currentPlayerIndex = currentPlayerIndex ; 
	}
	
	public int getNextIndex() {
	    return (currentPlayerIndex + direction + players.length) % players.length;
	}

	public PlayerClass[] getPlayers() {
		return this.players;
	}
	
	public void setPlayers(PlayerClass[] players) {
        this.players = players;
    }
	
	public int getDirection() {
		return this.direction;
	}
	
	public void setDirection(int direction ) {
		this.direction = direction ; 
	}
	
	public DeckClass getDeck(){
		return this.deck ; 
	}
	
    public boolean isGameOver() {
        return gameOver;
    }
    
    public List<CardClass> getDiscardPile() {
		return this.discardPile;
	}
    
    public boolean getGameOver() {
    	return this.gameOver ; 
    }
    
    public void setGameOver() {
    	this.gameOver = true ; 
    }
    
    public String getWinner() {
    	for ( int i = 0 ; i < players.length ; i++ ) {
    		if ( players[i].PlayerCards() == 0 ) {
    			return players[i].getName() ; }  } 
    	return null ; } 
    

	public void SGame() {
		
	    PlayerClass Currplayer = this.players[currentPlayerIndex];   // get the Currplayer informations (his name and hand ) 
	    CardClass TopCard = discardPile.get(discardPile.size()-1);   // put the first card from the deck to the table 
	    System.out.println("------------------------------------------- ");
	    System.out.println("The current player is : " + Currplayer.getName()); 
	    System.out.println("The current player has : " + Currplayer.PlayerCards());
	    System.out.println("------------------------------------------- ");
	    System.out.println("The top card is " + TopCard);

	    CardClass CardPlayed = null;

	 // Find playable card 
	    List<CardClass> playebleCards = new ArrayList<>();  // a list that will get all the cards who can the current player play with 
	    
	    for ( int i = 0 ; i < Currplayer.getHand().size() ; i++ ) { 
	    	System.out.print((i+1)+" ) " + Currplayer.getHand().get(i)+"\t" );
	    	if ( Currplayer.getHand().get(i).matches(TopCard)) { 
	    		 playebleCards.add(Currplayer.getHand().get(i));  } } 
	    	
	    	while ( playebleCards.isEmpty() ) {
	    		
	    		deck.Draw(Currplayer, this); // draw a card from the deck 
	    		CardClass newCard = Currplayer.getHand().get(Currplayer.getHand().size()-1);
	    		
	    		if ( newCard.matches(TopCard)) {  // check if the drawed card match with the TopCard 
	    			// also here we applyed the polymorphisme because we have a different difinitions for the methode matches
	    			playebleCards.add(newCard); }  }  
	    		
	    	if ( !playebleCards.isEmpty()) { // show the playeble cards that the player can play with 
	    		System.out.println("\n\nYou can Play : ");
	    		for ( int i = 0 ; i < playebleCards.size() ; i++ ) {
	    			System.out.print((i+1) +")" + playebleCards.get(i)+"\t"); }  } 
	    		        
	    	int choiced ; 
	    	while (true) {
	    		System.out.println("Choice a card to play :");  // choice a cards from the playeble cards that he has
	    		 choiced = scan.nextInt();
	    		if ( choiced >= 1 && choiced <= playebleCards.size()) {
	    			break ; }   
	    		System.out.println("Invalide Card ");  }
	  
	    	
	    	CardPlayed = playebleCards.get(choiced - 1);   // put the playeble cards choiced from the user 
	    	
	    	Currplayer.getHand().remove(CardPlayed);  // remove the choiced card from the hand of the player 
	    	discardPile.add(CardPlayed);	 // add the playeble card to the discardPile (on the table )
	    	System.out.println("Played: " + CardPlayed);
	    	
	    	
	    	if ( CardPlayed instanceof ActionsClass ) {   // the application of the polymorphisme 
	    		((ActionsClass) CardPlayed).Action(this); // get the Action methode of the CardPlayer like Skip/Reverse/..../Wild 
	    	    
	    		if (CardPlayed instanceof Wild || CardPlayed instanceof DrawFour ) {
	    			System.out.println("The color choiced is : "+CardPlayed.getColor());
	    		}
	    		
	    	}  

	    Currplayer.UNOCard();

	    if (Currplayer.PlayerCards() == 0) {
	        gameOver = true;
	        return; // stop printing further
	    }

	    // Move to next player
	    currentPlayerIndex = (currentPlayerIndex + direction + players.length) % players.length; 
	}

    
    
    public void shuffleDiscardPile(List<CardClass> discardPile) {
    	
        if (discardPile.size() <= 1) return; // top card stays
        
        List<CardClass> newDeck = new ArrayList<>(discardPile.subList(0, discardPile.size() - 1)); // take the cards from the element 0 to the last element (cards) f the discardPile 
        Collections.shuffle(newDeck); 
        deck = new DeckClass();
        //deck.getDeck().clear();  
        deck.getDeck().addAll(newDeck);

        // keep only the top card in discardPile
        CardClass topCard = discardPile.get(discardPile.size() - 1);
        discardPile.clear();// remove all the cards from the discardPile 
        discardPile.add(topCard);

        System.out.println("Deck reshuffled from discard pile.");
    }


}   


