package UnoGame;

class DrawTwo extends ActionsClass {

	public DrawTwo(Color color) {
		super(color); }    
	
	@Override
	
	public void Action(GameClass game) {    // un polymorphisme pour la class of draw two 
	    PlayerClass player = game.getNextPlayer();
	    DeckClass deck = game.getDeck();

	    deck.Draw(player,game);
	    deck.Draw(player,game);

	    // skip the target player's turn
	    //game.setPlayerIndex(game.getNextIndex());
	}

	@Override 
	public boolean matches(CardClass TopCard) {   // polymorphisme pour la methode matches aussi 
		return this.getColor() == TopCard.getColor() ;
	}

	@Override
	public String toString() {  // redifinition de la methode toString 
		return "| draw-two " + this.getColor() + "|" ;  
	} 

}



