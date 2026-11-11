package UnoGame;

public class DrawFour extends Wild {
	
	public DrawFour() {
		super();
	} 
	
	@Override
	public void Action(GameClass game) { 
		super.Action(game);
		
		for ( int i = 0 ; i < 4 ; i++ ) {
   		 game.getDeck().Draw(game.getNextPlayer(),game); } 
	}
		
	/*@Override
	public boolean matches(CardClass TopCard) {
		return true ; 
	} */
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	