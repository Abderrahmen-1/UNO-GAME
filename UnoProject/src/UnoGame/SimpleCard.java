
package UnoGame;

public class SimpleCard extends CardClass {

	private int Number ; 
	
    public SimpleCard(int Number, Color color) {
        super(color);
        this.Number = Number ; 
    }
    
    public void setNumber(int Number) {
		this.Number = Number ; }
	
	
	public int getNumber() {
		return this.Number ; }

    @Override
    public boolean matches(CardClass topCard) {
        // Match by color
        if (this.getColor() == topCard.getColor()) {
            return true;
        } 

        // Match by number ONLY if the top card is also a SimpleCard
        if (topCard instanceof SimpleCard) {
            SimpleCard topSimple = (SimpleCard) topCard;
            return this.Number == topSimple.Number;
        }

        return false;
    }


	@Override
	public String toString() {   // redifinition de la methode toString
		return "|" + this.getColor() + "-" + this.Number +"|" ; 
	}


}



	 
	 
	 
	 
	 
	 
	 

