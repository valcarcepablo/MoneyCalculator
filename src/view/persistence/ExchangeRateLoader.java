package view.persistence;

import model.CurrencySet;
import model.ExchangeRate;
import model.ExchangeRateSet;

public class ExchangeRateLoader {

    public ExchangeRateSet load(CurrencySet c) {
        ExchangeRateSet set = new ExchangeRateSet();
        for (int i = 0; i < c.size(); i++) {
            for (int j = 0; j < c.size(); j++) {
                if (c.get(i).equals(c.get(j))) {
                    set.add(new ExchangeRate(c.get(i), c.get(i), 1));
                } else {
                	if(c.get(i).getCode().equals("EUR") && c.get(j).getCode().equals("USD")) 
                		set.add(new ExchangeRate(c.get(i), c.get(j), (float) 1.1));
                	if(c.get(i).getCode().equals("USD") && c.get(j).getCode().equals("EUR")) 
                		set.add(new ExchangeRate(c.get(i), c.get(j), (float) 0.9));
                	if(c.get(i).getCode().equals("EUR") && c.get(j).getCode().equals("LBT")) 
                		set.add(new ExchangeRate(c.get(i), c.get(j), (float) 0.82));
                	if(c.get(i).getCode().equals("LBT") && c.get(j).getCode().equals("EUR")) 
                		set.add(new ExchangeRate(c.get(i), c.get(j), (float) 1.18));
                	if(c.get(i).getCode().equals("USD") && c.get(j).getCode().equals("LBT")) 
                		set.add(new ExchangeRate(c.get(i), c.get(j), (float) 0.7));
                	if(c.get(i).getCode().equals("LBT") && c.get(j).getCode().equals("USD")) 
                		set.add(new ExchangeRate(c.get(i), c.get(j), (float) 1.3));	
                }
            }
        }
        return set;
    }
}
