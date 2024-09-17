import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Math.round;

public class gui extends JFrame {

    private JPanel panel1;
    private JTextField textField1;
    private JRadioButton dolarRadioButton;
    private JRadioButton euroRadioButton;
    private JRadioButton sterlinRadioButton;
    private JRadioButton altınRadioButton;
    private JButton hesaplaButton;
    private JRadioButton bitcoinRadioButton;
    private JRadioButton dolarRadioButton1;
    private JRadioButton euroRadioButton1;
    private JRadioButton sterlinRadioButton1;
    private JRadioButton altınRadioButton1;
    private JRadioButton bitcoinRadioButton1;
    private JRadioButton türkLirasıRadioButton;
    private JRadioButton türkLirasıRadioButton1;
    private JLabel sonuc;

    public gui(){
        ButtonGroup group = new ButtonGroup();
        group.add(dolarRadioButton);
        group.add(euroRadioButton);
        group.add(sterlinRadioButton);
        group.add(altınRadioButton);
        group.add(bitcoinRadioButton);
        group.add(türkLirasıRadioButton);
        ButtonGroup group1 = new ButtonGroup();
        group1.add(dolarRadioButton1);
        group1.add(euroRadioButton1);
        group1.add(sterlinRadioButton1);
        group1.add(altınRadioButton1);
        group1.add(bitcoinRadioButton1);
        group1.add(türkLirasıRadioButton1);
        dolarRadioButton.setSelected(true);
        türkLirasıRadioButton1.setSelected(true);

        add(panel1);
        setSize(800,200);
        setTitle("Döviz Hesaplayıcı");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        dolarRadioButton.setActionCommand("USD");
        euroRadioButton.setActionCommand("EUR");
        sterlinRadioButton.setActionCommand("GBP");
        altınRadioButton.setActionCommand("gram-altin");
        bitcoinRadioButton.setActionCommand("bitcoin");
        türkLirasıRadioButton.setActionCommand("TRY");

        dolarRadioButton1.setActionCommand("USD");
        euroRadioButton1.setActionCommand("EUR");
        sterlinRadioButton1.setActionCommand("GBP");
        altınRadioButton1.setActionCommand("gram-altin");
        bitcoinRadioButton1.setActionCommand("bitcoin");
        türkLirasıRadioButton1.setActionCommand("TRY");
        textField1.setText("1");

        Doviz dov = new Doviz();

        hesaplaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                float miktar = 1;
                if (textField1.getText().isEmpty() == false) {
                    try {
                        miktar = Float.parseFloat(textField1.getText());
                    } catch (NumberFormatException ex) {
                        throw new RuntimeException(ex);
                    } finally {
                        sonuc.setText("Lütfen geçerli bir değer giriniz!!!");
                        sonuc.setForeground(Color.RED);
                    }
                }
                else{
                    textField1.setText("1");
                }
                String deger = Float.toString(miktar * dov.DovizCevir(group.getSelection().getActionCommand(),group1.getSelection().getActionCommand()));
                String miktarStr;
                if(round(miktar) == miktar){
                    int miktar1 = round(miktar);
                    miktarStr = Integer.toString(miktar1);
                }
                else{
                    miktarStr = Float.toString(miktar);
                }

                String mesaj1 = new String();
                String mesaj2 = new String();
                if(group.getSelection().getActionCommand() == "USD")
                    mesaj1 = "Amerikan Doları";
                else if(group.getSelection().getActionCommand() == "EUR")
                    mesaj1 = "Euro";
                else if(group.getSelection().getActionCommand() == "TRY")
                    mesaj1 = "Türk Lirası";
                else if(group.getSelection().getActionCommand() == "bitcoin")
                    mesaj1 = "Bitcoin";
                else if(group.getSelection().getActionCommand() == "gram-altin")
                    mesaj1 = "Gram altın";
                else if(group.getSelection().getActionCommand() == "GBP")
                    mesaj1 = "Sterlin";

                if(group1.getSelection().getActionCommand() == "USD")
                    mesaj2 = "Amerikan Dolarıdır";
                else if(group1.getSelection().getActionCommand() == "EUR")
                    mesaj2 = "Eurodur";
                else if(group1.getSelection().getActionCommand() == "TRY")
                    mesaj2 = "Türk Lirasıdır";
                else if(group1.getSelection().getActionCommand() == "bitcoin")
                    mesaj2 = "Bitcoindir";
                else if(group1.getSelection().getActionCommand() == "gram-altin")
                    mesaj2 = "Gram altındır";
                else if(group1.getSelection().getActionCommand() == "GBP")
                    mesaj2 = "Sterlindir";




                sonuc.setText(miktarStr + " " + mesaj1 + " " + deger + " " + mesaj2 + " ");
                sonuc.setForeground(new Color(0, 100, 0));
            }
        });
    }

}
