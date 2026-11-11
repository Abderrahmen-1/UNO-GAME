package UnoGame;
import java.util.Scanner ;
import java.util.Random ; 

public class Wild extends ActionsClass {
    
    public Wild() {
        super(Color.none);
    }

    public void setColor(Color color) {
        super.setColor(color);   // Update CardClass.color
    }

    public Color getColor() {
        return super.getColor();
    }
    
    @Override
    public void Action(GameClass game) {  // polymorphisme ( redifinition of the Action methode ) 
    	int c ; 
    	
    	if (game.getPlayer(game.getPlayerIndex()) instanceof BotPlayer ) {
    		Random rand = new Random();
    		 c = rand.nextInt(3); } 
    	
    	else {
    	Scanner scan = game.getScanner();
        System.out.println("Choose a color: 1=red 2=yellow 3=blue 4=green");
         c = scan.nextInt(); } 

        switch(c-1) {
            case 0: this.setColor(Color.red); break;
            case 1: this.setColor(Color.yellow); break;
            case 2: this.setColor(Color.blue); break;
            case 3: this.setColor(Color.green); break;
            default: this.setColor(Color.red); break;
        }  
    }   
     

	@Override
	public boolean matches(CardClass TopCard) {  // redifinition of the Action methode polymorphisme ( polymorphisme )
		//if (  TopCard.getColor() == this.getColor()) {
		//	return true ;  // check if the next card has the same color choiced from the wild card 
		//}
			return true ;  // means that the wild card can put it after all the cards 
			}

	@Override
	public String toString() { // redifinition de la methode toString
		return "|" + this.getColor() + "- wild |" ; 
	}
	
    
}