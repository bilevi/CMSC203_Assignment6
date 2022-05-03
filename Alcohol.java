/**
 * 
 * @author B_Leigh_Vining
 *
 */
public class Alcohol extends Beverage {

	private boolean weekend;
	private final double WEEKEND_COST = 0.60;
	
	/**
	 * 
	 * @param n  The name of the drink
	 * @param s  The size of the drink
	 * @param end  Whether its the weekend or not
	 */
	Alcohol(String n, SIZE s, boolean end) {
		super(n, s);
		weekend = end;
		super.setType(TYPE.ALCOHOL);
	}
	
	@Override
	public String toString() {
		return super.toString() +
				"\nIs it the weekend? " + weekend
				+ "\nPrice: $" + calcPrice();
	}
	
	/**
	 * 
	 * @param alc  The Alcoholic drink
	 * @return  True if the drinks are the same and false if they are not
	 */
	public boolean equals(Alcohol alc) {
		if (super.equals(alc))
		{
			if (this.getWeekend() == alc.getWeekend())
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

		if (getWeekend() == true)
		{
			cost += WEEKEND_COST;
		}

		return cost;
	}
	
	/**
	 * 
	 * @param end  Whether its the weekend or not
	 */
	public void setWeekend(boolean end) {
		weekend = end;
	}
	
	/**
	 * 
	 * @return  True if it is the weekend or false if it is not
	 */
	public boolean getWeekend() {
		return weekend;
	}
}