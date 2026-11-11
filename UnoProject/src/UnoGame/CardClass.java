package UnoGame;
//import java.util.List ; 

enum Color {
	red , yellow , blue , green , none }


public abstract class CardClass {
	
	private Color color ;   
	 
	public CardClass( Color color ) {     // constrator of the class Card 
		this.color = color ; }
	
	public Color getColor() {
		return this.color ; } 
	
	public void setColor(Color color) {
		this.color = color ; }

	
	public abstract boolean matches(CardClass TopCard);  // abstract methode 
	 
	public abstract String toString(); 
		  
} 
