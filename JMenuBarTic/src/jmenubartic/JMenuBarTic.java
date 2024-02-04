
package jmenubartic;

import javax.swing.*;

public class JMenuBarTic {
    JMenuBar menuBar;
    JMenu file, edit, format, view, help, zoom;
    JMenuItem newItem, open, save, exit;
    JMenuItem zoomin, zoomout, statusBar;
    JFrame frame;
    JTextArea jta;
   
    public JMenuBarTic()
    {
        frame = new JFrame();
        frame.setTitle("Menu-Driven App");
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null); //Center Screen for JFrame
        
        //Adding JMenuBar components
        //MenuBar
        menuBar = new JMenuBar();
        //Menus
        file = new JMenu("File");
        edit = new JMenu("Edit");
        format = new JMenu("Format");
        view = new JMenu("View");
        help = new JMenu("Help");
        //MenuItems
        newItem = new JMenuItem("New");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        exit = new JMenuItem("Exit");
        
        //Adding JMenuBar components 
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(format);
        menuBar.add(view);
        menuBar.add(help);
        
        //Adding menuItems to menu
        file.add(newItem);
        file.add(open);
        file.add(save);
        file.add(exit);
        
        //Creating objects of JMenuItem for view menu
        zoom = new JMenu("Zoom");
        view.add(zoom);
        statusBar = new JMenuItem("Status Bar");
        view.add(statusBar);
        zoomin = new JMenuItem("Zoom In");
        zoomout = new JMenuItem("Zoom Out");
        //Adding to zoom menu
        zoom.add(zoomin);
        zoom.add(zoomout);
        
        //Adding textarea to JFrame
        jta = new JTextArea();
        frame.add(jta);
        
        //Adding JMenuBar to JFrame
        frame.setJMenuBar(menuBar);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }
    public static void main(String[] args) {
     JMenuBarTic obj =new JMenuBarTic
        ();
    }
}