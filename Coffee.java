/**
 * 
 * @author B_Leigh_Vining
 *
 */
public class Coffee extends Beverage {

	private boolean X_shot, X_syrup;
	private final double EXTRA = 0.50;
	
	/**
	 * 
	 * @param n  The name of the coffee drink
	 * @param s  The size of the coffee drink
	 * @param sh  If there were extra shots or not
	 * @param sy  If there was extra syrup or not
	 */
	Coffee(String n, SIZE s, boolean sh, boolean sy) {
		super(n, s);
		X_shot = sh;
		X_syrup = sy;
		super.setType(TYPE.COFFEE);
	}
	
	@Override
	public String toString() {
		return super.toString()
				+ "\nExtra Shot? " + X_shot
				+ "\nExtra Syrup? " + X_syrup
				+ "\nPrice: $" + calcPrice();
	}
	
	@Override
	public double calcPrice() {
		double cost = 0.0;
		
		if (super.getSize() == SIZE.SMALL)
		{
			cost += BASE_PRICE;
		}
		
		else if (super.getSize() == SIZE.MEDIUM)
		{
			cost += BASE_PRICE + SIZE_PRICE;
		}
		
		else if (super.getSize() == SIZE.LARGE)
		{
			cost += BASE_PRICE + (2 * SIZE_PRICE);
		}
		
		if (X_shot == true)
		{
			cost += EXTRA;
		}
		if (X_syrup == true)
		{
			cost += EXTRA;
		}
		
		return cost;
	}
	
	/**
	 * 
	 * @param cof  A coffee drink
	 * @return  True if the 2 drinks are the same, false if not
	 */
	public boolean equals(Coffee cof) {
		if (super.equals(cof))
		{
			if (this.getExtraShot() == cof.getExtraShot()
					&& this.getExtraSyrup() == cof.getExtraSyrup())
			{
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	/**
	 * 
	 * @param ans  Whether there were extra shots added to the coffee
	 */
	public void setX_shot(boolean ans) {
		X_shot = ans;
	}
	
	/**
	 * 
	 * @return  True if there were extra shots added to the coffee, false if there were not
	 */
	public boolean getExtraShot() {
		return X_shot;
	}
	
	/**
	 * 
	 * @param ans  Whether there was extra syrup added to the coffee
	 */
	public void setX_syrup(boolean ans) {
		X_syrup = ans;
	}
	
	/**
	 * 
	 * @return  True if there was extra syrup added to the coffee, false if not
	 */
	public boolean getExtraSyrup() {
		return X_syrup;
	}
}