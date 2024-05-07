package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Main1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main1 frame = new Main1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void AddRemove(JButton btAdd_Remove) {
		btAdd_Remove.addActionListener(new ActionListener() {
		           
			public void actionPerformed(ActionEvent e) {
				view_AddRemove them_xoa = new view_AddRemove();
		        them_xoa.setVisible(true);
		        dispose();
		                  
			}
		});
	}
	public void ReturnEvent(JButton btReturn_Event) {
		btReturn_Event.addActionListener(new ActionListener() {
		           
			public void actionPerformed(ActionEvent e) {
				view_tra tra = new view_tra();
		        tra.setVisible(true);
		        dispose();
		                  
			}
		});
	}
	public void BorrowEvent(JButton btBorrow_Event) {
		btBorrow_Event.addActionListener(new ActionListener() {
		           
			public void actionPerformed(ActionEvent e) {
				view_muon muon = new view_muon();
		        muon.setVisible(true);
		        dispose();
		                  
			}
		});
	}
	public Main1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 522);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel MenuLabel = new JLabel("Menu");
		MenuLabel.setFont(new Font("Times New Roman", Font.BOLD, 34));
		MenuLabel.setForeground(new Color(220, 20, 60));
		MenuLabel.setBounds(175, 59, 93, 40);
		contentPane.add(MenuLabel);
		
		
		
		JButton btAdd_Remove = new JButton("Thêm,Xóa sách");
		btAdd_Remove.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btAdd_Remove.setBounds(121, 170, 204, 45);
		contentPane.add(btAdd_Remove);
		
		AddRemove(btAdd_Remove);
		
		JButton btReturn_Event = new JButton("Trả sách");
		btReturn_Event.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btReturn_Event.setBounds(121, 226, 204, 45);
		contentPane.add(btReturn_Event);
		
		ReturnEvent(btReturn_Event);
		
		JButton btBorrow_Event = new JButton("Mượn sách");
		btBorrow_Event.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btBorrow_Event.setBounds(121, 282, 204, 45);
		contentPane.add(btBorrow_Event);
		
		BorrowEvent(btBorrow_Event);
	}
}
