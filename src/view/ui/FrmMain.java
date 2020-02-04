package view.ui;

import model.Currency;
import model.ExchangeRateSet;

public class FrmMain extends javax.swing.JFrame {

    private final Currency[] currencies;
    private final ExchangeRateSet rates;

    public FrmMain(Currency[] currencies, ExchangeRateSet rates) {        
        this.currencies = currencies;
        this.rates = rates;
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContents = new javax.swing.JPanel();
        panelEquals = new javax.swing.JPanel();
        panelSource = new javax.swing.JPanel();
        txtSource = new javax.swing.JTextField();
        comboSource = new javax.swing.JComboBox();
        panelOutcome = new javax.swing.JPanel();
        txtOutcome = new javax.swing.JTextField();
        comboOutcome = new javax.swing.JComboBox();
        butCalculate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Converter");
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.X_AXIS));

        panelContents.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));
        panelContents.setLayout(new javax.swing.BoxLayout(panelContents, javax.swing.BoxLayout.X_AXIS));
        panelContents.add(panelEquals);

        panelSource.setLayout(new java.awt.GridBagLayout());

        txtSource.setColumns(15);
        panelSource.add(txtSource, new java.awt.GridBagConstraints());

        comboSource.setModel(new CurrencyComboModel(currencies));
        comboSource.setSelectedIndex(0);
        panelSource.add(comboSource, new java.awt.GridBagConstraints());

        panelContents.add(panelSource);

        panelOutcome.setLayout(new java.awt.GridBagLayout());

        txtOutcome.setEditable(false);
        txtOutcome.setColumns(15);
        panelOutcome.add(txtOutcome, new java.awt.GridBagConstraints());

        comboOutcome.setModel(new CurrencyComboModel(currencies));
        comboOutcome.setSelectedIndex(0);
        panelOutcome.add(comboOutcome, new java.awt.GridBagConstraints());

        panelContents.add(panelOutcome);

        butCalculate.setText("Calculate");
        butCalculate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butCalculateMouseClicked(evt);
            }
        });
        panelContents.add(butCalculate);

        getContentPane().add(panelContents);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butCalculateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butCalculateMouseClicked
        if (!"".equals(txtSource.getText())) {
            convertToSecondAmount();
        }
    }//GEN-LAST:event_butCalculateMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCalculate;
    private javax.swing.JComboBox comboOutcome;
    private javax.swing.JComboBox comboSource;
    private javax.swing.JPanel panelContents;
    private javax.swing.JPanel panelEquals;
    private javax.swing.JPanel panelOutcome;
    private javax.swing.JPanel panelSource;
    private javax.swing.JTextField txtOutcome;
    private javax.swing.JTextField txtSource;
    // End of variables declaration//GEN-END:variables

    private void convertToSecondAmount() {
        double firstAmount = Double.parseDouble(txtSource.getText());
        double rate = rates.getRate(currencies[comboSource.getSelectedIndex()],
                currencies[comboOutcome.getSelectedIndex()]);
        txtOutcome.setText(String.valueOf(firstAmount * rate));
    }
}

