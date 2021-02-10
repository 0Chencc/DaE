package burp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.io.PrintWriter;
import org.CTFCrackTools.Func;

public class BurpExtender implements IBurpExtender, ITab {
    public JPanel panel1;
    public JTabbedPane tabbedPane1;
    public JScrollPane scrollPane1;
    public JTextArea textArea1;
    public JScrollPane scrollPane2;
    public JTextArea textArea2;
    public JScrollPane scrollPane3;
    public JTextArea textArea3;
    public JScrollPane scrollPane4;
    public JTextArea textArea4;
    public JScrollPane scrollPane5;
    public JTextArea textArea5;
    public JScrollPane scrollPane6;
    public JTextArea textArea6;
    public JScrollPane scrollPane7;
    public JTextArea textArea7;
    public JScrollPane scrollPane8;
    public JTextArea textArea8;
    public JScrollPane scrollPane9;
    public JTextArea textArea9;
    public JPanel panel2;
    public JComboBox<String> comboBox1;
    public JComboBox<String> comboBox2;
    public JComboBox<String> comboBox3;
    public JTextArea textArea;
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
            textArea = (JTextArea) ((JScrollPane) tabbedPane1.getSelectedComponent()).getViewport().getView();
            String input = textArea.getText();
            int selectid = comboBox1.getSelectedIndex();
            switch (selectid){
                case 1:
                    textArea.setText(f.MorseDecode(input));
                    break;
                case 2:
                    textArea.setText(f.BaconCodeDecode(input));
                    break;
                case 3:
                    textArea.setText(f.Base64de(input));
                    break;
                case 4:
                    textArea.setText(f.Base32de(input));
                    break;
                case 5:
                    textArea.setText(f.URLDecoder(input));
                    break;
                case 6:
                    textArea.setText(f.UnicodeDecode(input));
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
            textArea = (JTextArea) ((JScrollPane) tabbedPane1.getSelectedComponent()).getViewport().getView();
            String input = textArea.getText();
            int selectid = comboBox2.getSelectedIndex();
            switch (selectid){
                case 1:
                    textArea.setText(f.MorseEncode(input));
                    break;
                case 2:
                    textArea.setText(f.BaconCodeEncode(input));
                    break;
                case 3:
                    textArea.setText(f.Base64en(input));
                    break;
                case 4:
                    textArea.setText(f.Base32en(input));
                    break;
                case 5:
                    textArea.setText(f.UrlEncoder(input));
                    break;
                case 6:
                    textArea.setText(f.UnicodeEncode(input));
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
            textArea = (JTextArea) ((JScrollPane) tabbedPane1.getSelectedComponent()).getViewport().getView();
            String input = textArea.getText();
            int selectid = comboBox3.getSelectedIndex();
            switch (selectid){
                case 1:
                    textArea.setText(f.Fence(input));
                    break;
                case 2:
                    textArea.setText(f.Caesar(input));
                    break;
                case 3:
                    textArea.setText(f.PigCode(input));
                    break;
                case 4:
                    textArea.setText(f.Rot13(input));
                    break;
                case 5:
                    textArea.setText(f.HextoString(input));
                    break;
                case 6:
                    textArea.setText(f.StringtoHex(input));
                    break;
                case 7:
                    textArea.setText(f.UnicodeToAscii(input));
                    break;
                case 8:
                    textArea.setText(f.AsciiToUnicode(input));
                    break;
                case 9:
                    textArea.setText(f.reverse(input));
                    break;
                default:
                    break;
            }
            comboBox3.setSelectedIndex(0);
        }
    }
    private void initialize(){
        panel1 = new JPanel();
        tabbedPane1 = new JTabbedPane();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        scrollPane2 = new JScrollPane();
        textArea2 = new JTextArea();
        scrollPane3 = new JScrollPane();
        textArea3 = new JTextArea();
        scrollPane4 = new JScrollPane();
        textArea4 = new JTextArea();
        scrollPane5 = new JScrollPane();
        textArea5 = new JTextArea();
        scrollPane6 = new JScrollPane();
        textArea6 = new JTextArea();
        scrollPane7 = new JScrollPane();
        textArea7 = new JTextArea();
        scrollPane8 = new JScrollPane();
        textArea8 = new JTextArea();
        scrollPane9 = new JScrollPane();
        textArea9 = new JTextArea();
        panel2 = new JPanel();
        comboBox1 = new JComboBox<>();
        comboBox2 = new JComboBox<>();
        comboBox3 = new JComboBox<>();
        panel = new JPanel();
        //======== this ========
/*        BorderLayout bl = new BorderLayout();
        bl.setHgap(10);
        panel.setLayout(bl);*/
        GridBagLayout gb = new GridBagLayout();
        gb.columnWidths = new int[] {298, 0, 0, 0};
        gb.rowHeights = new int[] {0, 0};
        gb.columnWeights = new double[] {1.0, 0.0, 0.0, 1.0E-4};
        gb.rowWeights = new double[] {1.0, 1.0E-4};
        panel.setLayout(gb);
        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout());

            //======== tabbedPane1 ========
            {
                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(textArea1);
                }
                tabbedPane1.addTab("1", scrollPane1);

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(textArea2);
                }
                tabbedPane1.addTab("2", scrollPane2);

                //======== scrollPane3 ========
                {
                    scrollPane3.setViewportView(textArea3);
                }
                tabbedPane1.addTab("3", scrollPane3);

                //======== scrollPane4 ========
                {
                    scrollPane4.setViewportView(textArea4);
                }
                tabbedPane1.addTab("4", scrollPane4);
                //======== scrollPane5 ========
                {
                    scrollPane5.setViewportView(textArea5);
                }
                tabbedPane1.addTab("5", scrollPane5);
                //======== scrollPane6 ========
                {
                    scrollPane6.setViewportView(textArea6);
                }
                tabbedPane1.addTab("6", scrollPane6);
                //======== scrollPane7 ========
                {
                    scrollPane7.setViewportView(textArea7);
                }
                tabbedPane1.addTab("7", scrollPane7);
                //======== scrollPane8 ========
                {
                    scrollPane8.setViewportView(textArea8);
                }
                tabbedPane1.addTab("8", scrollPane8);
                //======== scrollPane9 ========
                {
                    scrollPane9.setViewportView(textArea9);
                }
                tabbedPane1.addTab("9", scrollPane9);
            }
            panel1.add(tabbedPane1);
        }
        panel.add(panel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 10), 0, 0));

        //======== panel2 ========
        {
            panel2.setLayout(null);

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
            panel2.add(comboBox1);
            comboBox1.setBounds(0, 30, 110, comboBox1.getPreferredSize().height);
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
            panel2.add(comboBox2);
            comboBox2.setBounds(0, 60, 110, comboBox2.getPreferredSize().height);

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
            panel2.add(comboBox3);
            comboBox3.setBounds(0,90,110,comboBox3.getPreferredSize().height);
            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel2.getComponentCount(); i++) {
                    Rectangle bounds = panel2.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel2.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel2.setMinimumSize(preferredSize);
                panel2.setPreferredSize(preferredSize);
            }
        }
        panel.add(panel2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 10), 0, 0));
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