import java.util.*;

/**
 * 
 * @author B_Leigh_Vining
 *
 */
public class BevShop implements BevShopInterfce {
		private int alcohol_num = 0;
		private Customer cust;
		private Order order;
		private ArrayList<Order> orderList = new ArrayList<>();
		
		BevShop( ) {
		}
		
		public boolean validTime(int t) {
			if (t >= 8 && t <= 23)
			{
				return true;
			}
			else return false;
		}
		
		public boolean eligibleForMore() {
			if (alcohol_num < MAX_ORDER_FOR_ALCOHOL)
			{
				return true;
			}
			else return false;
		}
		
		public boolean validAge(int a) {
			if (a > MIN_AGE_FOR_ALCOHOL)
			{
				return true;
			}
			else return false;
		}
		
		public void startNewOrder(int t, DAY d,
				String custName, int custAge) {
			cust = new Customer(custName, custAge);
			order = new Order(t, d, cust);
			orderList.add(order);
			alcohol_num = 0;
		}
		
		public void processCoffeeOrder(String bName, SIZE s,
				boolean xShot, boolean xSyrup) {
			order.addNewBeverage(bName, s, xShot, xSyrup);
		}
		
		public void processAlcoholOrder(String bName, SIZE s) {
			order.addNewBeverage(bName, s);
			alcohol_num++;
		}
		
		public void processSmoothieOrder(String bName, SIZE s,
				int fruitNum, boolean add) {
			order.addNewBeverage(bName, s, fruitNum, add);
		}
		
		public int findOrder(int num) {
			for (Order order : orderList)
			{
				if (order.getOrderNo() == num)
				{
					return orderList.indexOf(order);
				}
			}
			return -1;
		}
	
		public double totalOrderPrice(int num) {
			int ord = findOrder(num);
			order = orderList.get(ord);
			return order.calcOrderTotal();
		}
		
		public double totalMonthlySale() {
			double total = 0.0;
			
			for (Order ord : orderList)
			{
				total += ord.calcOrderTotal();
			}
			return total;
		}
		
		public void sortOrders() {
			int startScan, index, minIndex, minValue;
			Order minOrd;
			
			for (startScan = 0; startScan < orderList.size() - 1; startScan++)
			{
				minIndex = startScan;
				minValue = orderList.get(startScan).getOrderNo();
				minOrd = orderList.get(startScan);
				
				 for (index = startScan + 1; index < orderList.size(); index++)
				 {
					 if (orderList.get(index).getOrderNo() < minValue)
					 {
						 minValue = orderList.get(index).getOrderNo();
						 minOrd = orderList.get(index);
						 minIndex = index;
					 }
				 }
				 
				 orderList.set(minIndex, orderList.get(startScan));
				 orderList.set(startScan, minOrd);
			}
		}
		
		public Order getOrderAtIndex(int ind) {
			return orderList.get(ind);
		}
		
		/**
		 * 
		 * @param num  The number of fruit used so far
		 * @return  If the number of fruit is greater than the maximum fruit allowed
		 */
		public boolean isMaxFruit(int num) {
			if (num > MAX_FRUIT)
			{
				return true;
			}
			else return false;
		}
		
		/**
		 * 
		 * @return  The current order that is being filled out in the list
		 */
		public Order getCurrentOrder() {
			return orderList.get(orderList.size() - 1);
		}
		
		/**
		 * 
		 * @return  The maximum amount of alcohol per order
		 */
		public int getMaxOrderForAlcohol() {
			return MAX_ORDER_FOR_ALCOHOL;
		}
		
		/**
		 * 
		 * @return  The number of alcoholic drinks ordered so far
		 */
		public int getNumOfAlcoholDrink() {
			return alcohol_num;
		}
		
		/**
		 * 
		 * @return  The minimum age to purchase alcohol
		 */
		public int getMinAgeForAlcohol() {
			return MIN_AGE_FOR_ALCOHOL;
		}
		
		/**
		 * 
		 * @return  The total number of orders for the month/per month
		 */
		public int totalNumOfMonthlyOrders() {
			int count = 0;
			
			for (Order ord : orderList)
			{
				if (ord != null)
				{
					count += 1;
				}
			}
			return count;
		}
		
		@Override
		public String toString() {
			String shop = "";
			
			for (Order ord : orderList)
			{
				shop += ord.toString();
			}
			
			shop += "\nMonthly Sales: $" + totalMonthlySale();
			
			return shop;
				
		}
}