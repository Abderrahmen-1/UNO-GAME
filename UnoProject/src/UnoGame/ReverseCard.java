package UnoGame;
//import java.util.ArrayList ;
//import java.util.List; 

class ReverseCard extends ActionsClass { 
	
	public ReverseCard( Color color) {
		super(color); }                           
	
   @Override 
	public void Action( GameClass game ) {  // polymorphisme pour la methode Action de la class ReverseClass 
	   if ( game.getPlayers().length == 2 ) {
		   int nextIndex = (game.getPlayerIndex() + game.getDirection() + game.getPlayers().length) % game.getPlayers().length;
	        game.setPlayerIndex(nextIndex);}

	   else {
	   game.setDirection(game.getDirection()*(-1));  // on doit multiplier la direction par (-1) pour changer la direction                          
	   }
	 }
   

   @Override
   public boolean matches(CardClass TopCard) {    // polymorphisme pour la methode matches 
	   return this.getColor() == TopCard.getColor() ;
   }

   @Override
   public String toString() {  // redifinition de la methode toString
	return "| reverse "+this.getColor() +" |" ;
   }
   
   
}

