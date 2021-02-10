package burp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.io.PrintWriter;
import org.CTFCrackTools.Func;

public class BurpExtender implements IBurpExtender, ITab {
    public JTabbedPane tabbedPane1;
    public JScrollPane scrollPane1;
    public JTextArea textArea1;
    public JScrollPane scrollPane2;
    public JTextArea textArea2;
    public JComboBox<String> comboBox1;
    public JComboBox<String> comboBox2;
    public JComboBox<String> comboBox3;
    private JPanel panel;
    private IBurpExtenderCallbacks callbacks;

    private static PrintWriter stdout;
    public Func f = new Func();
    @Override
    public void registerExtenderCallbacks(final IBurpExtenderCallbacks callbacks)
    {
        this.callbacks = callbacks;
        String version = "1.0.0";
        callbacks.setExtensionName(String.format("DaE (%s) - CTFCrackTools's Burpsuite Plugin - Decode and Encode", version));
        // 定义输出
        stdout = new PrintWriter(callbacks.getStdout(), true);
        stdout.println("@Author: 0chencc");
        stdout.println("@Github: github.com/0Chencc");
        // UI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initialize();
            }
        });
    }
    /*
                     "MorseDeCode",
                    "BaconDeCode",
                    "Base64Decode",
                    "Base32Decode",
                    "URLdecode",
                    "UnicodeDecode"
     */
    private void comboBox1ItemStateChanged(ItemEvent e) {
        // TODO add your code here
        if(e.getStateChange() == ItemEvent.SELECTED){
            String input = textArea1.getText();
            int selectid = comboBox1.getSelectedIndex();
            switch (selectid){
                case 1:
                    textArea2.setText(f.MorseDecode(input));
                    break;
                case 2:
                    textArea2.setText(f.BaconCodeDecode(input));
                    break;
                case 3:
                    textArea2.setText(f.Base64de(input));
                    break;
                case 4:
                    textArea2.setText(f.Base32de(input));
                    break;
                case 5:
                    textArea2.setText(f.URLDecoder(input));
                    break;
                case 6:
                    textArea2.setText(f.UnicodeDecode(input));
                    break;
                default:
                    break;
            }
            comboBox1.setSelectedIndex(0);
        }
    }
    private void comboBox2ItemStateChanged(ItemEvent e) {
        // TODO add your code here
        if (e.getStateChange()==ItemEvent.SELECTED){
            String input = textArea1.getText();
            int selectid = comboBox2.getSelectedIndex();
            switch (selectid){
                case 1:
                    textArea2.setText(f.MorseEncode(input));
                    break;
                case 2:
                    textArea2.setText(f.BaconCodeEncode(input));
                    break;
                case 3:
                    textArea2.setText(f.Base64en(input));
                    break;
                case 4:
                    textArea2.setText(f.Base32en(input));
                    break;
                case 5:
                    textArea2.setText(f.UrlEncoder(input));
                    break;
                case 6:
                    textArea2.setText(f.UnicodeEncode(input));
                    break;
                default:
                    break;
            }
            comboBox2.setSelectedIndex(0);
        }
    }
    /*
    *               "Fence",
                    "CaesarCode",
                    "PigCode",
                    "Rot13",
                    "Hex2String",
                    "String2Hex",
                    "Unicode2Ascii",
                    "Ascii2Unicode",
                    "Reverse"
    *
    * */
    private void comboBox3ItemStateChanged(ItemEvent e) {
        // TODO add your code here
        if (e.getStateChange()==ItemEvent.SELECTED){
            String input = textArea1.getText();
            int selectid = comboBox3.getSelectedIndex();
            switch (selectid){
                case 1:
                    textArea2.setText(f.Fence(input));
                    break;
                case 2:
                    textArea2.setText(f.Caesar(input));
                    break;
                case 3:
                    textArea2.setText(f.PigCode(input));
                    break;
                case 4:
                    textArea2.setText(f.Rot13(input));
                    break;
                case 5:
                    textArea2.setText(f.HextoString(input));
                    break;
                case 6:
                    textArea2.setText(f.StringtoHex(input));
                    break;
                case 7:
                    textArea2.setText(f.UnicodeToAscii(input));
                    break;
                case 8:
                    textArea2.setText(f.AsciiToUnicode(input));
                    break;
                case 9:
                    textArea2.setText(f.reverse(input));
                    break;
                default:
                    break;
            }
            comboBox3.setSelectedIndex(0);
        }
    }
    private void initialize(){
        tabbedPane1 = new JTabbedPane();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        scrollPane2 = new JScrollPane();
        textArea2 = new JTextArea();
        comboBox1 = new JComboBox<>();
        comboBox2 = new JComboBox<>();
        comboBox3 = new JComboBox<>();
        panel = new JPanel();
        //======== this ========
/*        BorderLayout bl = new BorderLayout();
        bl.setHgap(10);
        panel.setLayout(bl);*/
        GridBagLayout gb = new GridBagLayout();
        gb.columnWidths = new int[] {40, 60, 0, 0, 0, 60, 30};
        gb.rowHeights = new int[] {25, 70, 40, 70, 30};
        gb.columnWeights = new double[] {0.0, 0.5, 0.0, 0.0, 0.0, 0.5, 0.0};
        gb.rowWeights = new double[] {0.0, 0.4, 0.0, 0.4, 1.0};
        {
            scrollPane1.setPreferredSize(new Dimension(300, 20));
            textArea1.setLineWrap(true);
            scrollPane1.setViewportView(textArea1);
        }
        panel.setLayout(gb);

        panel.add(scrollPane1, new GridBagConstraints(1, 1, 5, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 20, 10), 0, 0));
        panel.add(comboBox1, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 20, 10), 0, 0));
        panel.add(comboBox2, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 20, 10), 0, 0));
        panel.add(comboBox3, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 20, 10), 0, 0));

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                "Decode as",
                "MorseDeCode",
                "BaconDeCode",
                "Base64Decode",
                "Base32Decode",
                "URLdecode",
                "UnicodeDecode"
        }));
        comboBox1.addItemListener(e -> comboBox1ItemStateChanged(e));
        //---- comboBox2 ----
        comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
                "Encode as",
                "MorseEncode",
                "BaconEncode",
                "Base64Encode",
                "Base32DEncode",
                "URLencode",
                "UnicodeEncode"
        }));
        comboBox2.addItemListener(e -> comboBox2ItemStateChanged(e));
        comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {
                "Decrypt as",
                "Fence",
                "CaesarCode",
                "PigCode",
                "Rot13",
                "Hex2String",
                "String2Hex",
                "Unicode2Ascii",
                "Ascii2Unicode",
                "Reverse"
        }));
        comboBox3.addItemListener(e ->comboBox3ItemStateChanged(e));
        {
            scrollPane2.setPreferredSize(new Dimension(300, 20));
            textArea2.setLineWrap(true);
            scrollPane2.setViewportView(textArea2);
        }
        panel.add(scrollPane2, new GridBagConstraints(1, 3, 5, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 20, 10), 0, 0));
        callbacks.customizeUiComponent(panel);
        callbacks.addSuiteTab(BurpExtender.this);
    }
    @Override
    public String getTabCaption(){
        return "DaE";
    }

    @Override
    public Component getUiComponent() {
        return panel;
    }


}