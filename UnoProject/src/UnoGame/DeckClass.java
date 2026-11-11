package UnoGame;
import java.util.ArrayList ;
import java.util.Collections;
import java.util.List ; 

public class DeckClass {
	  
	private List<CardClass> deck = new ArrayList<>();
	
	public DeckClass() {  // constractor of the class
	      this.deck = create(); 
	       }
	
	
	public List<CardClass> create(){ // creation of the deck (deck is the all 108 cards of UNO 
		 Color[] colors = {Color.red , Color.yellow , Color.blue , Color.green }; 
		 
		    
		for ( int i = 0 ; i < 4 ; i++ ) {
			deck.add( new SimpleCard( 0 , colors[i]) ); }      // 1 carts de num 0 chaque color 
		
		for ( int n = 0 ; n <= 1 ; n++ ) {
			for ( int j = 1 ; j <= 9 ; j++ ) {
				for ( int i = 0 ; i < 4 ; i++ ) {
					deck.add(new SimpleCard( j , colors[i]));  // 2 carts pour touts les num de 1 a 9 pour chaque color 
					 } }  }
		
		for ( int j = 0 ; j < 2 ; j++ ) {
			for ( int i = 0 ; i < 4 ; i++ ) {
				deck.add(new SkipCard(colors[i]));  // creation de skip cards 
					}  } 
		
		for ( int j = 0 ; j < 2 ; j++ ) {
			for ( int i = 0 ; i < 4 ; i++ ) {
				deck.add(new DrawTwo(colors[i]));  // creation de draw two classes 
				 }  } 
		
		for ( int j = 0 ; j < 2 ; j++ ) {
			for (int i = 0 ; i < 4 ; i++ ) {  
				deck.add(new ReverseCard(colors[i]));   // creation de reverse classes 
				 }  }  
		
		for ( int j = 0 ; j < 4 ; j++ ) {
				deck.add(new Wild());     // creation of the wild cards 
				 }  
		
		for ( int j = 0 ; j < 4 ; j++ ) {
				deck.add(new DrawFour());   // creation of the draw four cards 
				 }  
		
		return deck ; } 

	
	public void shuffle(){
		Collections.shuffle(deck); 
	}
	
	public List<CardClass> getDeck(){
		return this.deck ; 
	} 
	
	public void Draw(PlayerClass player, GameClass game) {
	    if (deck.isEmpty()) {
	        game.shuffleDiscardPile(game.getDiscardPile());
	    }

	    if (!deck.isEmpty()) {
	        player.getHand().add(deck.remove(0));
	    } //else {
	        //System.out.println("The Deck is Empty, no card to draw!");
	    //}
	}

	} 

	
	
