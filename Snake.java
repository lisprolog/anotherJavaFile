package snake;
//package com.zetcode;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Snake extends JFrame {

    public Snake() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Board());
        setTitle("Snake");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
        setResizable(false);
        setLocationRelativeTo(null);	
        pack();
	setVisible(true);

    }
    
    public static void main(String[] args) {
	/*        
        EventQueue.invokeLater(() -> {
            JFrame ex = new Snake();
            ex.setVisible(true);
        });
	*/

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame ex = new Snake();
                ex.setVisible(true);
            }
        });
	
    }
}
