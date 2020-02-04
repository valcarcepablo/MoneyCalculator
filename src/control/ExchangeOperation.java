package control;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.CurrencySet;
import model.ExchangeRateSet;
import view.persistence.CurrencySetFetcher;
import view.persistence.ExchangeRateLoader;
import view.ui.FrmMain;

public class ExchangeOperation {

    private final CurrencySet currencySet;
    private final ExchangeRateSet rateSet;

    public ExchangeOperation() {
        currencySet = new CurrencySetFetcher().load();
        rateSet = new ExchangeRateLoader().load(currencySet);
    }

    public void execute() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            FrmMain frmMain = new FrmMain(currencySet.toArray(), rateSet);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            FrmMain frmMain = new FrmMain(currencySet.toArray(), rateSet);
        }
    }

}
