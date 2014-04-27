package gui_launcher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPContent_Welcome {

	
	static JPanel DrawMe() {
		
		JPanel jptr = new JPanel(new BorderLayout());
		jptr.setBackground(InitProgram.contentBgColor);
		
		JLabel jlWelcome = new JLabel("Welcome to Hemixos !");
		jlWelcome.setForeground(Color.WHITE);
		jlWelcome.setBorder(BorderFactory.createEmptyBorder(0, 200, 0, 0));
		jlWelcome.setFont(new Font("Segoe UI", Font.BOLD, 17));
	
		jptr.add(jlWelcome, BorderLayout.CENTER);
		
		return jptr;
	}
	
	
	
}
