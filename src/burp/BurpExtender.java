package burp;

import javax.swing.*;
import java.awt.*;
import java.io.PrintWriter;

import burp.ui.MainUi;

/**
 * @author linchen
 */
public class BurpExtender implements IBurpExtender, ITab {
    private IBurpExtenderCallbacks callbacks;
    private static PrintWriter stdout;
    private final MainUi main = new MainUi();
    @Override
    public void registerExtenderCallbacks(final IBurpExtenderCallbacks callbacks)
    {
        this.callbacks = callbacks;
        callbacks.setExtensionName(String.format("DaE (%s) - CTFCrackTools's Burpsuite Plugin - Decode and Encode", Config.VERSION));
        // 定义输出
        stdout = new PrintWriter(callbacks.getStdout(), true);
        stdout.println("@Author: 0chencc");
        stdout.println("@Github: github.com/0Chencc");
        // UI
        SwingUtilities.invokeLater(this::initialize);
    }
    private void initialize(){
        callbacks.customizeUiComponent(main);
        callbacks.addSuiteTab(BurpExtender.this);
    }
    @Override
    public String getTabCaption(){
        return "DaE";
    }

    @Override
    public Component getUiComponent() {
        return main;
    }


}