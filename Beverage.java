/**
 * 
 * @author B_Leigh_Vining
 *
 */
abstract class Beverage {

	private String bevName;
	private TYPE type;
	private SIZE size;
	protected final double BASE_PRICE = 2.0;
	protected final double SIZE_PRICE = 1.0;
	
	/**
	 * 
	 * @param n  The name of the beverage
	 * @param s  The size of the beverage
	 */
	Beverage(String n, SIZE s){
		bevName = n;
		size = s;
	}
	/**
	 * 
	 * @param n  The name of the beverage
	 * @param t  the type of the beverage
	 * @param s  the size of the beverage
	 */
	Beverage(String n, TYPE t, SIZE s){
		bevName = n;
		type = t;
		size = s;
	}
	
	/**
	 * 
	 * @return  The calculated price
	 */
	public abstract double calcPrice();
	
	@Override
	public String toString() {
		return "\nName: " + bevName
				+ "\nSize: " + size;
	}
	
	/**
	 * 
	 * @param bev  A beverage object
	 * @return  True if the two beverages are the same, false if they are not
	 */
	public boolean equals(Beverage bev) {
		if (this.getBevName() == bev.getBevName() && this.getType() == bev.getType()
				&& this.getSize() == bev.getSize())
		{
			return true;
		}
		else return false;
	}
	
	/**
	 * 
	 * @param n
	 */
	public void setBevName(String n) {
		bevName = n;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getBevName() {
		return bevName;
	}
	
	/**
	 * 
	 * @param t
	 */
	public void setType (TYPE t) {
		type = t;
	}
	
	/**
	 * 
	 * @return
	 */
	public TYPE getType() {
		return type;
	}
	
	/**
	 * 
	 * @param s
	 */
	public void setSize(SIZE s) {
		size = s;
	}
	
	/**
	 * 
	 * @return
	 */
	public SIZE getSize() {
		return size;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getBasePrice() {
		return BASE_PRICE;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getSizePrice() {
		return SIZE_PRICE;
	}
}