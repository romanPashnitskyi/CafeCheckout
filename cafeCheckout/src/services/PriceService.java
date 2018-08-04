package services;

import java.util.HashMap;
import java.util.Map;

public class PriceService {
    protected Map<String, Integer> prices;
    
    public PriceService() {
        this.prices = new HashMap<String, Integer>();

        this.prices.put("�����", 12);
        this.prices.put("ϳ��", 60);
        this.prices.put("������", 20);
        this.prices.put("����", 88);
        this.prices.put("�������", 16);
        this.prices.put("��������", 28);
    }

    public int getPrice(String item) {
        if (!this.prices.containsKey(item)) {
            System.out.println("Price for item '" + item + "' is not set!");
            System.exit(0);
        }

        return this.prices.get(item);
    }
}
