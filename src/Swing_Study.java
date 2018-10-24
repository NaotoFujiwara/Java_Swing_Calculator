import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Swing_Study extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swing_Study frame = new Swing_Study();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	boolean isAfterOpe = false;
	boolean textField_EmptySetFlg = false;
	String ope = null;
	//int ope_BeforeNum = 0;
	//int ope_afterNum = 0;
	BigDecimal ope_BeforeNum = new BigDecimal("0.0");
	BigDecimal ope_afterNum = new BigDecimal("0.0");

	/**
	 * Create the frame.
	 */
	public Swing_Study() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("MS UI Gothic", Font.BOLD, 25));
		textField.setText("0");
		textField.setBounds(67, 10, 304, 63);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setHorizontalAlignment(JTextField.RIGHT);

		ActionListener ac = new doAction();

		JButton bt_allClear = new JButton("AC");
		bt_allClear.setBounds(62, 83, 69, 42);
		contentPane.add(bt_allClear);
		bt_allClear.addActionListener(ac);

		JButton bt_7 = new JButton("7");
		bt_7.setBounds(62, 139, 69, 42);
		contentPane.add(bt_7);
		bt_7.addActionListener(ac);

		JButton bt_4 = new JButton("4");
		bt_4.setBounds(62, 191, 69, 42);
		contentPane.add(bt_4);
		bt_4.addActionListener(ac);

		JButton bt_1 = new JButton("1");
		bt_1.setBounds(62, 243, 69, 42);
		contentPane.add(bt_1);
		bt_1.addActionListener(ac);

		JButton bt_clear = new JButton("C");
		bt_clear.setBounds(148, 83, 69, 42);
		contentPane.add(bt_clear);
		bt_clear.addActionListener(ac);

		JButton bt_8 = new JButton("8");
		bt_8.setBounds(148, 139, 69, 42);
		contentPane.add(bt_8);
		bt_8.addActionListener(ac);

		JButton bt_5 = new JButton("5");
		bt_5.setBounds(148, 191, 69, 42);
		contentPane.add(bt_5);
		bt_5.addActionListener(ac);

		JButton bt_2 = new JButton("2");
		bt_2.setBounds(148, 243, 69, 42);
		contentPane.add(bt_2);
		bt_2.addActionListener(ac);

		JButton bt_oneBack = new JButton("☒");
		bt_oneBack.setBounds(229, 83, 69, 42);
		contentPane.add(bt_oneBack);
		bt_oneBack.addActionListener(ac);

		JButton bt_9 = new JButton("9");
		bt_9.setBounds(229, 139, 69, 42);
		contentPane.add(bt_9);
		bt_9.addActionListener(ac);

		JButton bt_6 = new JButton("6");
		bt_6.setBounds(229, 191, 69, 42);
		contentPane.add(bt_6);
		bt_6.addActionListener(ac);

		JButton bt_3 = new JButton("3");
		bt_3.setBounds(229, 243, 69, 42);
		contentPane.add(bt_3);
		bt_3.addActionListener(ac);

		JButton bt_waru = new JButton("÷");
		bt_waru.setBounds(310, 83, 69, 42);
		contentPane.add(bt_waru);
		bt_waru.addActionListener(ac);

		JButton bt_kakeru = new JButton("×");
		bt_kakeru.setBounds(310, 139, 69, 42);
		contentPane.add(bt_kakeru);
		bt_kakeru.addActionListener(ac);

		JButton bt_hiku = new JButton("−");
		bt_hiku.setBounds(310, 191, 69, 42);
		contentPane.add(bt_hiku);
		bt_hiku.addActionListener(ac);

		JButton bt_tasu = new JButton("＋");
		bt_tasu.setBounds(310, 243, 69, 42);
		contentPane.add(bt_tasu);
		bt_tasu.addActionListener(ac);

		JButton bt_PlusOrMinus = new JButton("+/-");
		bt_PlusOrMinus.setBounds(62, 300, 69, 42);
		contentPane.add(bt_PlusOrMinus);
		bt_PlusOrMinus.addActionListener(ac);

		JButton bt_0 = new JButton("0");
		bt_0.setBounds(148, 300, 69, 42);
		contentPane.add(bt_0);
		bt_0.addActionListener(ac);

		JButton bt_dot = new JButton("．");
		bt_dot.setBounds(229, 300, 69, 42);
		contentPane.add(bt_dot);
		bt_dot.addActionListener(ac);

		JButton bt_equal = new JButton("=");
		bt_equal.setBounds(310, 300, 69, 42);
		contentPane.add(bt_equal);
		bt_equal.addActionListener(ac);


	}

	public class doAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			// TODO 自動生成されたメソッド・スタブ

			if(command.equals("AC") ||	command.equals("C") ||
					command.equals("+/-") ||command.equals("☒") ||command.equals("．")){

				editStyle(command);
			}

			if(!(command.equals("＋") || command.equals("−") ||
					command.equals("×") || command.equals("÷") ||
					command.equals("=") || command.equals("AC") ||
					command.equals("C") ||	command.equals("+/-") ||
					command.equals("☒") ||command.equals("．"))) {

				if(textField.getText().equals("0") || textField_EmptySetFlg) {
					textField.setText("");
					textField_EmptySetFlg = false;
				}

				if(isAfterOpe) {
					ope_afterNum = doAppend(command);
				}else {
					ope_BeforeNum = doAppend(command);
				}

			}else {

				//変数opeに四則演算記号以外の混入を防ぐため
				if(!(command.equals("="))) {
					ope = command;
				}else if(!(command.equals("=")) && !(ope_BeforeNum.compareTo(BigDecimal.ZERO)==0) && !(ope_afterNum.compareTo(BigDecimal.ZERO)==0)) {
					ope_BeforeNum = doCalc(ope_BeforeNum,ope_afterNum,ope);
					ope_afterNum = BigDecimal.ZERO;
				}
				isAfterOpe = true;
				textField_EmptySetFlg = true;
			}

			if(command.equals("=")) {
				ope_BeforeNum = doCalc(ope_BeforeNum,ope_afterNum,ope);
				ope_afterNum = BigDecimal.ZERO;
				//textField_EmptySetFlg = false;
				isAfterOpe = false;
			}
		}


		private void editStyle(String editThings) {
			switch(editThings) {
			case "AC":
				textField.setText("");
				ope_BeforeNum = BigDecimal.ZERO;
				ope_afterNum = BigDecimal.ZERO;
				isAfterOpe = false;
				textField_EmptySetFlg = false;
				break;

			case "C":
				textField.setText("");
				break;

			case "+/-":
				//あとで考える
				break;

			case "☒":
				textField.getText().substring(textField.getText().length(), 0);
				break;

			case "．":
				//あとで考える
				break;
			}
		}


		private BigDecimal doAppend(String strNum) {
			textField.setText(textField.getText() + strNum);
			BigDecimal result = new BigDecimal(textField.getText());
			return result;
		}


		//計算メソッド
		private BigDecimal doCalc(BigDecimal strNum1, BigDecimal strNum2, String ope) {
			BigDecimal result = new BigDecimal("0");

			switch(ope) {
			case "＋":
				result = strNum1.add(strNum2);
				break;

			case "−":
				result = strNum1.subtract(strNum2);
				break;

			case "×":
				result = strNum1.multiply(strNum2);
				break;

			case "÷":
				result = strNum1.divide(strNum2);
				break;
			}

			textField.setText(String.valueOf(result));
			return result;
		}
	}
}
