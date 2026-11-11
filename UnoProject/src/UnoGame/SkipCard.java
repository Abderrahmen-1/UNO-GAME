package UnoGame;
//import java.util.List ; 

public class SkipCard extends ActionsClass {

	public SkipCard(Color color) {
			super(color);
		}

    @Override
	public void Action(GameClass game) {  // redifinition of the Action methode polymorphisme ( polymorphisme ) 
		  // Skip the next player according to current direction
	      int nextIndex = (game.getPlayerIndex() + game.getDirection() + game.getPlayers().length) % game.getPlayers().length;
			        game.setPlayerIndex(nextIndex);
			    }

	@Override
	public boolean matches(CardClass TopCard) {  //  redifinition of the matches methode polymorphisme ( polymorphisme ) 
			return this.getColor() == TopCard.getColor() ; 
		}

	@Override
	public String toString() {  // redifinition de la methode toString
		return "| skip "+this.getColor()+ " |" ; 
	}
	}
