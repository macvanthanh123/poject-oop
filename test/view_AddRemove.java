package test;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class view_AddRemove extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					view_AddRemove frame = new view_AddRemove();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public void Add_Remove_Book(JButton btAdd_Remove) {
		btAdd_Remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_book hien_thi_book = new view_book();
				hien_thi_book.setVisible(true);
		        dispose();
		                  
			}
		});
	}
	public void Add_Remove_EBook(JButton BTADD_REMOVE_BOOK) {
		BTADD_REMOVE_BOOK.addActionListener(new ActionListener() {
		           
			public void actionPerformed(ActionEvent e) {
				view_ebook hien_thi_ebook = new view_ebook();
				hien_thi_ebook.setVisible(true);
		        dispose();
		                  
			}
		});
	}
	public void Come_back(JButton cb_Button) {
		cb_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main1 M = new Main1();
				M.setVisible(true);
		        dispose();
		                  
			}
		});
	}
	public view_AddRemove() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 332, 293);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 160, 122));
		contentPane.setForeground(new Color(255, 160, 122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton BTADD_REMOVE_EBOOK = new JButton("Add,Remove EBook");
		BTADD_REMOVE_EBOOK.setBackground(new Color(255, 255, 255));
		BTADD_REMOVE_EBOOK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BTADD_REMOVE_EBOOK.setBounds(56, 37, 190, 49);
		contentPane.add(BTADD_REMOVE_EBOOK);
		Add_Remove_EBook(BTADD_REMOVE_EBOOK);
		JButton BTADD_REMOVE_BOOK = new JButton("Add,Remove Book");
		BTADD_REMOVE_BOOK.setBackground(new Color(255, 255, 255));
		BTADD_REMOVE_BOOK.setForeground(new Color(0, 0, 0));
		BTADD_REMOVE_BOOK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BTADD_REMOVE_BOOK.setBounds(56, 108, 190, 49);
		contentPane.add(BTADD_REMOVE_BOOK);
		Add_Remove_Book(BTADD_REMOVE_BOOK);
		
		JButton cb_Button = new JButton("Come Back");
		cb_Button.setBounds(56, 179, 190, 42);
		contentPane.add(cb_Button);
		Come_back(cb_Button);
	}
}
