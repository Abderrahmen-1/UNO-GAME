package UnoGame;

import java.util.ArrayList;
import java.util.List; 

public class PlayerClass {
	
	private String name ; 
    private List<CardClass> Hand = new ArrayList<>();
    
    
    public List<CardClass> setHand(List<CardClass> deck){  
	    for (int i = 0 ; i < 7 ; i++ ) {
	    	if ( !deck.isEmpty()) {
	        Hand.add(deck.remove(0));  } } 
	    return Hand;  }    
    
    
    public void setName(String name) {
    	this.name = name ; 
    }
    
    public String getName() {
    	return this.name ; } 
    
    
    public List<CardClass> getHand(){
    	return this.Hand ; 
    }
    
    public int PlayerCards() {
    	return this.Hand.size();
    }
    
    public void  UNOCard() {
    	if ( this.PlayerCards() == 1 ) {
    		System.out.println( this.name + ": Uno! "); }
    	} 
}  
    
    

    
    
	
	
	
	
	
	
	
	
	


