package services;

import java.util.ArrayList;
import java.util.List;

import models.OrderLine;
import models.Receipt;

public class CheckoutCalculatorService {
	protected List<OrderLine> allOrderLines;
	protected PriceService priceService;
	
	public CheckoutCalculatorService(List<OrderLine> allOrderLines) {
		this.allOrderLines = allOrderLines;
		this.priceService = new PriceService();
    }
    
    public Receipt getReceipt(int table, String guest) {
		List<OrderLine> orderLines = this.getOrderLinesForTable(table);
		
		if (guest != null) {
			orderLines = this.getOrderLinesForGuest(orderLines, guest);
		}

		if (orderLines.size() == 0) {
			System.out.println("We don't have a receipt for specified table or guest");
            System.exit(0);
		}

		return this.generateReceipt(orderLines);
    }

	protected List<OrderLine> getOrderLinesForTable(int table) {
		List<OrderLine> orderLinesForTable = new ArrayList<OrderLine>();

		for (OrderLine orderLine : allOrderLines) {
			if (orderLine.getTable() == table) {
				orderLinesForTable.add(orderLine);
			}
		}

		return orderLinesForTable;
	}

	protected List<OrderLine> getOrderLinesForGuest(List<OrderLine> tableOrderLines, String guest) {
		List<OrderLine> orderLinesForGuest = new ArrayList<OrderLine>();

		for (OrderLine orderLine : tableOrderLines) {
			if (orderLine.getGuest().equals(guest)) {
				orderLinesForGuest.add(orderLine);
            } 
        }

		return orderLinesForGuest;
	}

	protected Receipt generateReceipt(List<OrderLine> orderLines) {
		OrderLine firstOrderLine = orderLines.get(0);
		Receipt receipt = new Receipt(firstOrderLine.getWaiter(), firstOrderLine.getTable());

		for (OrderLine orderLine : orderLines) {

            String guest = orderLine.getGuest();
			String item = orderLine.getItem();
			int price = this.priceService.getPrice(item);

			receipt.addItem(guest, item, price);
		}

		return receipt;
	}
}
