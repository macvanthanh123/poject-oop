package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class view_ebook extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tieu_de;
	private JTextField tac_gia;
	private JTextField nam_xuat_ban;
	private JTable table;
	private JTextField ID;
	private int STT = 0;
	private ArrayList<String[]> dataList = new ArrayList<>();
	private String bookfile = "C:\\Users\\THANH\\Desktop\\GK_OOP\\test\\ebook_data.txt";
	private JTextField kt_file_Field;
	private JTextField dd_textField;

	private void saveToFile(int STT, String id, String tieu_de, String tac_gia, String nam_xuat_ban, String KTF,
			String DDF) {

		try {
			PrintWriter writer = new PrintWriter(new FileWriter(bookfile, true));
			writer.println(STT + "," + id + "," + tieu_de + "," + tac_gia + "," + nam_xuat_ban + "," + KTF + "," + DDF);
			writer.flush();
			writer.close();
			JOptionPane.showMessageDialog(null, "thêm sách thành công");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void Come_back(JButton cb_Button) {
		cb_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_AddRemove view_add_remove = new view_AddRemove();
				view_add_remove.setVisible(true);
				dispose();

			}
		});
	}

	public void removeFromFile(Object[] data_need_remove) {
		try {
			File inputFile = new File(bookfile);
			File tempFile = new File("C:\\OOP_thanh\\Giu_Ki_OOP\\src\\test\\temp.txt");

			StringJoiner dong_can_xoa = new StringJoiner(",");
			for (Object element : data_need_remove) {
				dong_can_xoa.add(element.toString());
			}

			String lineToRemove = dong_can_xoa.toString();
			// Tạo đối tượng BufferedReader để đọc từ tệp gốc
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			// Tạo đối tượng BufferedWriter để ghi vào tệp tạm thời
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			String currentLine;

			// Đọc từng dòng từ tệp gốc
			while ((currentLine = reader.readLine()) != null) {
				// Nếu dòng hiện tại không phải là dòng muốn xóa, ghi vào tệp tạm thời
				if (!currentLine.equals(lineToRemove)) {
					writer.write(currentLine + System.getProperty("line.separator"));
				}
			}
			// Đóng đối tượng đọc và ghi
			writer.close();
			reader.close();

			// Xóa tệp gốc
			if (!inputFile.delete()) {
				System.out.println("Không thể xóa tệp gốc");
				return;
			}
			// Đổi tên tệp tạm thời thành tên tệp gốc
			if (!tempFile.renameTo(inputFile)) {
				System.out.println("Không thể đổi tên tệp tạm thời");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public view_ebook() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 64, 0));
		panel.setBounds(0, 0, 708, 273);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel tieu_de_Label = new JLabel("Tiêu đề:");
		tieu_de_Label.setBounds(10, 11, 102, 32);
		panel.add(tieu_de_Label);

		JLabel tac_gia_Label = new JLabel("Tác giả:");
		tac_gia_Label.setBounds(10, 54, 102, 32);
		panel.add(tac_gia_Label);

		JLabel nam_xuat_ban_Label = new JLabel("năm xuất bản:");
		nam_xuat_ban_Label.setBounds(10, 97, 102, 38);
		panel.add(nam_xuat_ban_Label);

		tieu_de = new JTextField();
		tieu_de.setBounds(122, 17, 277, 26);
		panel.add(tieu_de);
		tieu_de.setColumns(10);

		tac_gia = new JTextField();
		tac_gia.setBounds(122, 60, 277, 26);
		panel.add(tac_gia);
		tac_gia.setColumns(10);

		nam_xuat_ban = new JTextField();
		nam_xuat_ban.setBounds(122, 106, 277, 25);
		panel.add(nam_xuat_ban);
		nam_xuat_ban.setColumns(10);

		JLabel IDLabel = new JLabel("ID sách:");
		IDLabel.setBounds(10, 146, 102, 25);
		panel.add(IDLabel);

		ID = new JTextField();
		ID.setBounds(122, 148, 277, 23);
		panel.add(ID);
		ID.setColumns(10);

		JLabel kt_file_Label = new JLabel("Kích thước file:");
		kt_file_Label.setBounds(10, 188, 102, 32);
		panel.add(kt_file_Label);

		kt_file_Field = new JTextField();
		kt_file_Field.setBounds(122, 188, 277, 23);
		panel.add(kt_file_Field);
		kt_file_Field.setColumns(10);

		JLabel dd_Label = new JLabel("Định dạng file: ");
		dd_Label.setBounds(10, 231, 102, 31);
		panel.add(dd_Label);

		dd_textField = new JTextField();
		dd_textField.setBounds(122, 230, 277, 26);
		panel.add(dd_textField);
		dd_textField.setColumns(10);

		// nút add
		JButton bt_add = new JButton("Thêm");
		bt_add.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		bt_add.setBounds(521, 19, 131, 56);
		panel.add(bt_add);

		DefaultTableModel model = new DefaultTableModel();

		bt_add.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name = tieu_de.getText();
				String tacj = tac_gia.getText();
				String namxbb = nam_xuat_ban.getText();
				String KT_file = kt_file_Field.getText();
				String id = ID.getText();
				String DD_file = dd_textField.getText();

				STT++;
				String STt = String.valueOf(STT);
				if (name.isEmpty() == false && tacj.isEmpty() == false && namxbb.isEmpty() == false) {
					Object[] rowData = { STt, id, name, tacj, namxbb, KT_file, DD_file };
					((DefaultTableModel) table.getModel()).addRow(rowData);
					saveToFile(STT, id, name, tacj, namxbb, KT_file, DD_file);
					tieu_de.setText("");
					tac_gia.setText("");
					nam_xuat_ban.setText("");
					ID.setText("");
					kt_file_Field.setText("");
					dd_textField.setText("");

				} else {
					JOptionPane.showMessageDialog(null, "vui lòng nhập dữ liệu vào ô");
				}

			}
		});

		// nút xóa

		JButton bt_remove = new JButton("Xóa");
		bt_remove.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		bt_remove.setBounds(521, 97, 131, 56);
		panel.add(bt_remove);

		bt_remove.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				Object[] temp = new String[table.getColumnCount()];
				if (selectedRow != -1) {

					for (int i = 0; i < table.getColumnCount(); i++) {
						Object value = table.getValueAt(selectedRow, i);

						temp[i] = value;

					}
					((DefaultTableModel) table.getModel()).removeRow(selectedRow);
					removeFromFile(temp);
				} else {
					JOptionPane.showMessageDialog(null, "hãy chọn dòng để xóa ");
				}
			}
		});

		// nút come back
		JButton cb_Button = new JButton("Quay lại");
		cb_Button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cb_Button.setBounds(521, 175, 131, 56);
		panel.add(cb_Button);
		Come_back(cb_Button);
		// chuyển đổi các dòng dữ liệu text thành arraylist
		try {
			BufferedReader br = new BufferedReader(new FileReader(bookfile));
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				dataList.add(data);
			}
			br.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		// Chuyển đổi ArrayList thành mảng hai chiều để cho vô bảng
		int Phan_tu_cuoi = dataList.size();
		String[][] dataArray = new String[Phan_tu_cuoi][];
		for (int i = 0; i < Phan_tu_cuoi; i++) {
			dataArray[i] = dataList.get(i);
		}
		// tuần tự STT
		if (Phan_tu_cuoi > 0) {
			STT = Integer.parseInt(dataArray[Phan_tu_cuoi - 1][0]);
		}

		table = new JTable(model);
		table.setBackground(new Color(245, 222, 179));
		table.setModel(new DefaultTableModel(
				dataArray,
				new String[] {
						"STT", "ID", "Tiêu Đề", "Tác giả", "Năm xuất bản", "Kích thước file", "Định dạng file"
				}));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 274, 708, 388);
		contentPane.add(scrollPane);

	}
}
