
package jmenubarexample;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;

public class JMenuBarExample implements ActionListener {

    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu fileMenu, editMenu;
    private JMenuItem newMenuItem, openMenuItem, saveMenuItem, exitMenuItem, cutMenuItem, copyMenuItem, pasteMenuItem;

    public JMenuBarExample() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("JMenuBar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(this);
        fileMenu.add(newMenuItem);

        openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(this);
        fileMenu.add(openMenuItem);

        saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(this);
        fileMenu.add(saveMenuItem);

        fileMenu.addSeparator();

        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(this);
        fileMenu.add(exitMenuItem);

        editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        cutMenuItem = new JMenuItem("Cut");
        cutMenuItem.addActionListener(this);
        editMenu.add(cutMenuItem);

        copyMenuItem = new JMenuItem("Copy");
        copyMenuItem.addActionListener(this);
        editMenu.add(copyMenuItem);

        pasteMenuItem = new JMenuItem("Paste");
        pasteMenuItem.addActionListener(this);
        editMenu.add(pasteMenuItem);

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newMenuItem) {
            JOptionPane.showMessageDialog(frame, "New file created");
        } else if (e.getSource() == openMenuItem) {
            JOptionPane.showMessageDialog(frame, "Open file");
        } else if (e.getSource() == saveMenuItem) {
            JOptionPane.showMessageDialog(frame, "File saved");
        } else if (e.getSource() == exitMenuItem) {
            System.exit(0);
        } else if (e.getSource() == cutMenuItem) {
            JOptionPane.showMessageDialog(frame, "Text cut");
        } else if (e.getSource() == copyMenuItem) {
            JOptionPane.showMessageDialog(frame, "Text copied");
        } else if (e.getSource() == pasteMenuItem) {
            JOptionPane.showMessageDialog(frame, "Text pasted");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JMenuBarExample();
            }
        });
    }
}

