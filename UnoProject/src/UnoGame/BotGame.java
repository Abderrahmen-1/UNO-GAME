package UnoGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BotGame extends GameClass { 
	
	public BotGame() {
		super();
	}      

	@Override 
    public void SGame() {
	    PlayerClass Currplayer = this.getPlayer(this.getCurrentPlayerIndex());                                           //this.players[currentPlayerIndex];   // get the Currplayer informations (his name and hand ) 
	    CardClass TopCard = this.getDiscardPile().get(this.getDiscardPile().size()-1);                                  //discardPile.get(discardPile.size()-1);   // put the first card from the deck to the table 
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
	    		
	    		this.getDeck().Draw(Currplayer, this);  //deck.Draw(Currplayer, this); // draw a card from the deck 
	    		CardClass newCard = Currplayer.getHand().get(Currplayer.getHand().size()-1);
	    		
	    		if ( newCard.matches(TopCard)) {  // check if the drawed card match with the TopCard 
	    			// also here we applyed the polymorphisme because we have a different difinitions for the methode matches
	    			playebleCards.add(newCard); }  }  
	    		
	    	if ( !playebleCards.isEmpty()) { // show the playeble cards that the player can play with 
	    		System.out.println("\n\nYou can Play : ");
	    		for ( int i = 0 ; i < playebleCards.size() ; i++ ) {
	    			System.out.print((i+1) +")" + playebleCards.get(i)+"\t"); }  } 
	    		        
	    	int choiced ;
	    	
            if ( Currplayer instanceof BotPlayer ) {
	    	    
	    	    Random rand = new Random(); 
	    	    int choice = rand.nextInt(playebleCards.size());
	    	    CardPlayed = playebleCards.get(choice); 
	    	    
	    	    Currplayer.getHand().remove(CardPlayed);
	    	    this.getDiscardPile().add(CardPlayed);      //discardPile.add(CardPlayed);
	    	    System.out.println("\nPlayed: " + CardPlayed); } 
            
	    	
            else {
	    	while (true) { // the real player 
	    		//this.setScanner(scan);
	    		System.out.println("Choice a card to play :");  // choice a cards from the playeble cards that he has
	    		 choiced =scan.nextInt();
	    		if ( choiced >= 1 && choiced <= playebleCards.size()) {
	    			break ; }   
	    		System.out.println("Invalide Card ");  } 
	    
	    	CardPlayed = playebleCards.get(choiced - 1);   // put the playeble cards choiced from the user 
	    	 
	    	Currplayer.getHand().remove(CardPlayed);  // remove the choiced card from the hand of the player 
	    	this.getDiscardPile().add(CardPlayed);        //discardPile.add(CardPlayed);	 // add the playeble card to the discardPile (on the table )
	    	System.out.println("\nPlayed: " + CardPlayed);
	    	
	    	}
	    	
	    	
	    	if ( CardPlayed instanceof ActionsClass ) {   // the application of the polymorphisme 
	    		((ActionsClass) CardPlayed).Action(this); // get the Action methode of the CardPlayer like Skip/Reverse/..../Wild 
	    		
	    		if (CardPlayed instanceof Wild || CardPlayed instanceof DrawFour ) {
	    			System.out.println("The color choiced is : "+CardPlayed.getColor());
	    		}
	    	}  

	    Currplayer.UNOCard();

	    if (Currplayer.PlayerCards() == 0) {
	    	this.setGameOver();   //gameOver = true;
	        return; // stop printing further
	    }

	    // Move to next player 
	    this.setCurrentPlayerIndex((this.getCurrentPlayerIndex() + this.getDirection() + this.getPlayers().length) % this.getPlayers().length);
	    this.getNextPlayer();
	}

	
	
	
	
	
	
	
	
}
