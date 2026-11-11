package UnoGame;

public abstract class ActionsClass extends CardClass {
	
	public ActionsClass(Color color) {
		super(color); }    
		  
		  public abstract void Action(GameClass game);  // application de l'abstraction 
		  //public abstract boolean matches(CardClass TopCard);  // application de l'abstraction 

		  public boolean matches() {
			// TODO Auto-generated method stub
			return false;
		  }
		  
		 
} 


