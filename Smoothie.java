/**
 * 
 * @author B_Leigh_Vining
 *
 */
public class Smoothie extends Beverage {

	
	private int fruit_num;
	private boolean protein_powder;
	private final double PROTEIN_COST = 1.50;
	private final double FRUIT_COST = 0.50;
	
/**
 * 
 * @param n  The name of the smoothie
 * @param s  The size of hte smoothie
 * @param num  The number of fruits in the smoothie
 * @param pow  Whether protein powder is used in the smoothie or not
 */
	Smoothie(String n, SIZE s, int num, boolean pow) {
		super(n, s);
		fruit_num = num;
		protein_powder = pow;
		super.setType(TYPE.SMOOTHIE);
	}

	@Override
	public String toString() {
		return super.toString() + 
				"\nProtein Powder? " + protein_powder
				+ "\nFruit Amount: " + fruit_num
				+ "\nPrice: $" + calcPrice();
	}

	/**
	 * 
	 * @param moo  A smoothie object
	 * @return  True if the two smoothies are the same, false if not
	 */
	public boolean equals(Smoothie moo) {
		if (super.equals(moo))
		{
			if (this.getNumOfFruits() == moo.getNumOfFruits()
					&& this.getAddProtein() == moo.getAddProtein())
			{
				return true;
			}
			else return false;
		}
		else return false;
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

		if (getAddProtein() == true)
		{
			cost += PROTEIN_COST;
		}
		if (getNumOfFruits() >= 1)
		{
			cost += getNumOfFruits() * FRUIT_COST;
		}

		return cost;
	}

	/**
	 * 
	 * @param num  The number of fruits used in the smoothie
	 */
	public void setNumOfFruits(int num) {
		fruit_num = num;
	}
	/**
	 * 
	 * @return  The number of fruits used in the smoothie
	 */
	public int getNumOfFruits() {
		return fruit_num;
	}

	/**
	 * 
	 * @param pow  Whether protein powder was used in the smoothie or not
	 */
	public void setProtein_powder(boolean pow) {
		protein_powder = pow;
	}
	
	/**
	 * 
	 * @return  True if protein powder was used, false if it was not
	 */
	public boolean getAddProtein() {
		return protein_powder;
	}
	
	/**
	 * 
	 * @return  The mispelling of the getter that is used in the test case
	 */
	public boolean getAddProtien() {
		return protein_powder;
	}
}