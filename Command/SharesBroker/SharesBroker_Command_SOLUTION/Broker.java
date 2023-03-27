/* 
 * INVOKER
 * 
 */

import java.util.*;
public class Broker {
    private List<SharesOrder> sharesOrders = new ArrayList<SharesOrder>();
    private SharesOrder command;

    public void takeOrder(SharesOrder order) {
	sharesOrders.add(order);
    }

    public void placeOrders() {
	for (SharesOrder order: sharesOrders) {
	    order.execute(); // polymorphism
	}
	sharesOrders.clear(); // to prevent repeat orders
    }

}
