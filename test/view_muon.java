package test;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import model.BorrowEvent_ReturnEvent;
import java.awt.Color;

public class view_muon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nguoi_tra_textField;
	private JTextField tieu_de_textField;
	private JTextField id_textField;
	private JTextField tg_textField;

	public void Come_back(JButton cb_Button) {
		cb_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main1 M = new Main1();
				M.setVisible(true);
				dispose();

			}
		});
	}

	public view_muon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 467);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 64, 0));
		contentPane.setForeground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Label = new JLabel("THÔNG TIN MƯỢN SÁCH");
		Label.setFont(new Font("Times New Roman", Font.ITALIC, 21));
		Label.setForeground(SystemColor.textHighlight);
		Label.setBounds(54, 11, 239, 40);
		contentPane.add(Label);

		JLabel nguoi_tra_Label = new JLabel("Người Mượn: ");
		nguoi_tra_Label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		nguoi_tra_Label.setBounds(10, 67, 88, 40);
		contentPane.add(nguoi_tra_Label);

		nguoi_tra_textField = new JTextField();
		nguoi_tra_textField.setBounds(108, 72, 173, 35);
		contentPane.add(nguoi_tra_textField);
		nguoi_tra_textField.setColumns(10);

		JLabel tieu_de_Label = new JLabel("Tiêu đề sách:");
		tieu_de_Label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tieu_de_Label.setBounds(10, 127, 88, 35);
		contentPane.add(tieu_de_Label);

		tieu_de_textField = new JTextField();
		tieu_de_textField.setBounds(108, 127, 173, 35);
		contentPane.add(tieu_de_textField);
		tieu_de_textField.setColumns(10);

		JLabel id_Label = new JLabel("ID sách: ");
		id_Label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		id_Label.setBounds(10, 186, 88, 35);
		contentPane.add(id_Label);

		id_textField = new JTextField();
		id_textField.setBounds(108, 186, 173, 35);
		contentPane.add(id_textField);
		id_textField.setColumns(10);

		JLabel tg_Label = new JLabel("Thời gian trả:");
		tg_Label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tg_Label.setBounds(10, 255, 105, 35);
		contentPane.add(tg_Label);

		BorrowEvent_ReturnEvent tg = new BorrowEvent_ReturnEvent();
		String thoi_gian_muon = tg.tg_muon();

		tg_textField = new JTextField(thoi_gian_muon);
		tg_textField.setBounds(108, 255, 173, 35);
		contentPane.add(tg_textField);
		tg_textField.setColumns(10);

		JButton btnNewButton = new JButton("Hoàn tất");
		btnNewButton.setBounds(10, 334, 131, 50);
		contentPane.add(btnNewButton);

		JButton cb_Button = new JButton("Quay lại");
		cb_Button.setBounds(175, 334, 118, 50);
		contentPane.add(cb_Button);
		Come_back(cb_Button);

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String ngm = nguoi_tra_textField.getText();
				String TD = tieu_de_textField.getText();
				String id = id_textField.getText();

				if (!ngm.isEmpty() && !TD.isEmpty() && !id.isEmpty()) {

					String fileName = "C:\\Users\\THANH\\Desktop\\GK_OOP\\data_muon.txt";

					try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
						writer.write("người mượn: " + ngm + "\n");
						writer.write("tiêu đề sách: " + TD + "\n");
						writer.write("id sách: " + id + "\n");
						writer.write("thời gian mượn " + thoi_gian_muon + "\n");

					} catch (IOException ex) {
						System.err.println("Error occurred while writing data to the file: ");
					}
					nguoi_tra_textField.setText("");
					tieu_de_textField.setText("");
					id_textField.setText("");
					JOptionPane.showMessageDialog(null, "đã thêm thành công");
					Main1 M = new Main1();
					M.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "vui lòng điền thông tin vào");
				}

			}
		});

	}
}
