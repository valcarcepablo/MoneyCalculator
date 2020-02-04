package view.persistence;

import model.Currency;
import model.CurrencySet;

public class CurrencySetFetcher implements CurrencySetLoader {

    
    @Override
    public CurrencySet load() {
        CurrencySet set = new CurrencySet();
        set.add(new Currency("EUR", "Euro", "€"));
        set.add(new Currency("USD", "Dollar americano", "$"));
        set.add(new Currency("LBT", "Libra esterlina", "£"));
        return set;
    }
    
}

