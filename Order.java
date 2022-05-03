import java.util.*;

/**
 * 
 * @author B_Leigh_Vining
 *
 */
public class Order implements OrderInterface{

	private int order_num;
	private DAY order_day;
	private int order_time;
	private Customer cust;
	private ArrayList<Beverage> orderList = new ArrayList<>();

	/**
	 * 
	 * @param time  The hour of the day
	 * @param day  The day of the week
	 * @param c  The customer for the order
	 */
	Order(int time, DAY day, Customer c) {
		order_time = time;
		order_day = day;
		cust = new Customer(c);
		order_num = random();
	}
	
	/**
	 * 
	 * @return  A random number between 10,000 and 90,0000 for the order number
	 */
	public int random() {
		int low = 10000;
		int high = 90000;
		
		int randomNum = (int) Math.floor(Math.random() * (high-low+1) + low);
		return randomNum;
	}
	
	public void addNewBeverage(String BName, SIZE s,
			boolean xShot, boolean xSyrup) {
		
		orderList.add(new Coffee(BName, s, xShot, xSyrup));
	}
	
	
	public void addNewBeverage(String BName, SIZE s) {
		
		orderList.add(new Alcohol(BName, s, isWeekend()));
	}
	
	public void addNewBeverage(String BName, SIZE s,
			int num, boolean add) {
		
		orderList.add(new Smoothie(BName, s, num, add));
	}
	
	public String toString() {
		String str = "";
		if (cust != null)
		{
		str += "\n\nOrder #: " + getOrderNo()
		+ "\nName: " + cust.getName()
		+ "\n\n";

		for (Beverage bev : orderList)
		{
			str += bev.toString();
		};
		
		str += "Order total: $" + calcOrderTotal();
	}
		return str;
	}
	
	/**
	 * 
	 * @param lo  An order object
	 * @return  -1 if the order number is below the object's order number, 1 if number is greater than the object's, and 0 if they are the same
	 */
	public int compareTo(Order lo) {
		
		if (this.getOrderNo() < lo.getOrderNo())
		{
			return -1;
		}
		else if (this.getOrderNo() > lo.getOrderNo())
		{
			return 1;
		}
		else return 0;
	}
	
	/**
	 * 
	 * @param n  The order number
	 */
	public void setOrderNo(int n) {
		order_num = n;
	}
	
	/**
	 * 
	 * @return  The order number
	 */
	public int getOrderNo() {
		return order_num;
	}
	
	/**
	 * 
	 * @param d
	 */
	public void setOrderDay(DAY d) {
		order_day = d;
	}
	
	/**
	 * 
	 * @return
	 */
	public DAY getOrderDay() {
		return order_day;
	}
	
	/**
	 * 
	 * @param time
	 */
	public void setOrderTime(int time) {
		order_time = time;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getOrderTime() {
		return order_time;
	}
	
	/**
	 * 
	 * @param c
	 */
	public void setCustomer(Customer c) {
		cust = new Customer(c);
	}
	
	/**
	 * 
	 * @return
	 */
	public Customer getCustomer() {
		return new Customer(cust);
	}
	
	public boolean isWeekend() {
		if (order_day == DAY.SATURDAY || order_day == DAY.SUNDAY)
		{
			return true;
		}
		else return false;
	}
	
	public Beverage getBeverage(int itemNum) {
		
		if (orderList.get(itemNum) == null)
		{
			return null;
		}
		else return	orderList.get(itemNum);
	}
	
	public double calcOrderTotal() {
		double cost = 0.0;
		for (Beverage bev : orderList)
		{
			cost += bev.calcPrice();
		}
		return cost;
	}
	
	public int findNumOfBeveType(TYPE tt) {
		int count = 0;
		
		for (Beverage bev : orderList)
		{
			if (bev.getType() == tt)
			{
				count += 1;
			}
		}
		return count;
	}

	/**
	 * 
	 * @return
	 */
	public int getTotalItems() {
		int count = 0;

		for (Beverage bev : orderList)
		{
			if (bev != null)
			{
				count += 1;
			}
		}
		return count;
	}
}