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

	private static final char MINUS = '-';
	boolean isAfterOpe = false;
	boolean textField_EmptySetFlg = false;
	String ope = null;
	//int ope_BeforeNum = 0;
	//int ope_afterNum = 0;
	BigDecimal ope_BeforeNum = new BigDecimal("0.0");
	BigDecimal ope_afterNum = new BigDecimal("0.0");
	BigDecimal firstNum = new BigDecimal("0");
	BigDecimal secondNum = new BigDecimal("0");

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

		JButton bt_dot = new JButton(".");
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
			if(command == "0" || command == "1" || command == "2" || command == "3" || command == "4"
					|| command == "5" || command == "6" || command == "7" || command == "8" || command == "9") {
				NumberAppend na = new NumberAppend();
				na.doAppend(command);
			}else if(command == "＋" || command == "−" || command == "×" || command == "÷") {
				ope = command;
				firstNum = new BigDecimal(textField.getText());
				textField.setText("");
			}else if (command == "=") {
				secondNum = new BigDecimal(textField.getText());
				Calclator cl = new Calclator();
				cl.doCalc(firstNum, secondNum, ope);
			}else if (command == "C" || command == "AC") {
				Clear c = new Clear();
				c.doClear(command);
			}else if(command == ".") {
				Dot d = new Dot();
				d.addDot(command);
			}else if(command == "☒") {
				RightDelete rd = new RightDelete();
				rd.doDelete(command);
			}else if(command == "+/-") {
				PlusMinus pm = new PlusMinus();
				pm.doPlusMinus(command);
			}
		}
	}


	private class NumberAppend{
		private void doAppend(String strNum) {
			if(textField.getText().equals("0")) {
				textField.setText("");
			}
			textField.setText(textField.getText() + strNum);
		}
	}


	private class Calclator{
		private void doCalc(BigDecimal firstNum, BigDecimal secondNUm, String ope) {
			BigDecimal result = new BigDecimal("0");
			try {
				switch(ope) {
				case "＋":
					result = firstNum.add(secondNum);
					break;

				case "−":
					result = firstNum.subtract(secondNum);
					break;

				case "×":
					result = firstNum.multiply(secondNum);
					break;

				case "÷":
					result = firstNum.divide(secondNum);
					break;
				}
			}catch(ArithmeticException e) {
				System.out.println("例外発生");
			}
			textField.setText(String.valueOf(result));
		}
	}


	private class Clear{
		private void doClear(String str) {
			if(str == "C") {
				textField.setText("");
			}else {
				firstNum = BigDecimal.ZERO;
				secondNum = BigDecimal.ZERO;
				textField.setText("0");
			}
		}
	}


	private class Dot{
		private void addDot(String dot) {
			textField.setText(textField.getText() + dot);
		}
	}


	private class RightDelete{
		private void doDelete(String str) {
			textField.setText(textField.getText().substring(0, textField.getText().length()-1));
		}
	}


	private class PlusMinus{
		private void doPlusMinus(String str) {
			String text = null;
			if(!(textField.getText() == "0")) {
				if(Integer.parseInt(textField.getText()) < 0) {
					text = textField.getText().substring(1);
				}else {
					text = MINUS + textField.getText();
				}
				textField.setText(text);
			}
		}
	}
}
