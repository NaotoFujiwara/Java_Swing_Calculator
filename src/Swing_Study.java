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
	private static final String DOT = ".";
	String ope = null;
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

		ActionListener append = new IsNumeric();
		ActionListener ope = new SetOpe();
		ActionListener calc = new DoCalc();
		ActionListener allClear = new DoAllClear();
		ActionListener clear = new DoClear();
		ActionListener dot = new AddDot();
		ActionListener delete = new RightDelete();
		ActionListener pm = new AddPlus_Minus();


		JButton bt_allClear = new JButton("AC");
		bt_allClear.setBounds(62, 83, 69, 42);
		contentPane.add(bt_allClear);
		bt_allClear.addActionListener(allClear);

		JButton bt_7 = new JButton("7");
		bt_7.setBounds(62, 139, 69, 42);
		contentPane.add(bt_7);
		bt_7.addActionListener(append);

		JButton bt_4 = new JButton("4");
		bt_4.setBounds(62, 191, 69, 42);
		contentPane.add(bt_4);
		bt_4.addActionListener(append);

		JButton bt_1 = new JButton("1");
		bt_1.setBounds(62, 243, 69, 42);
		contentPane.add(bt_1);
		bt_1.addActionListener(append);

		JButton bt_clear = new JButton("C");
		bt_clear.setBounds(148, 83, 69, 42);
		contentPane.add(bt_clear);
		bt_clear.addActionListener(clear);

		JButton bt_8 = new JButton("8");
		bt_8.setBounds(148, 139, 69, 42);
		contentPane.add(bt_8);
		bt_8.addActionListener(append);

		JButton bt_5 = new JButton("5");
		bt_5.setBounds(148, 191, 69, 42);
		contentPane.add(bt_5);
		bt_5.addActionListener(append);

		JButton bt_2 = new JButton("2");
		bt_2.setBounds(148, 243, 69, 42);
		contentPane.add(bt_2);
		bt_2.addActionListener(append);

		JButton bt_oneBack = new JButton("☒");
		bt_oneBack.setBounds(229, 83, 69, 42);
		contentPane.add(bt_oneBack);
		bt_oneBack.addActionListener(delete);

		JButton bt_9 = new JButton("9");
		bt_9.setBounds(229, 139, 69, 42);
		contentPane.add(bt_9);
		bt_9.addActionListener(append);

		JButton bt_6 = new JButton("6");
		bt_6.setBounds(229, 191, 69, 42);
		contentPane.add(bt_6);
		bt_6.addActionListener(append);

		JButton bt_3 = new JButton("3");
		bt_3.setBounds(229, 243, 69, 42);
		contentPane.add(bt_3);
		bt_3.addActionListener(append);

		JButton bt_waru = new JButton("÷");
		bt_waru.setBounds(310, 83, 69, 42);
		contentPane.add(bt_waru);
		bt_waru.addActionListener(ope);

		JButton bt_kakeru = new JButton("×");
		bt_kakeru.setBounds(310, 139, 69, 42);
		contentPane.add(bt_kakeru);
		bt_kakeru.addActionListener(ope);

		JButton bt_hiku = new JButton("−");
		bt_hiku.setBounds(310, 191, 69, 42);
		contentPane.add(bt_hiku);
		bt_hiku.addActionListener(ope);

		JButton bt_tasu = new JButton("＋");
		bt_tasu.setBounds(310, 243, 69, 42);
		contentPane.add(bt_tasu);
		bt_tasu.addActionListener(ope);

		JButton bt_PlusOrMinus = new JButton("+/-");
		bt_PlusOrMinus.setBounds(62, 300, 69, 42);
		contentPane.add(bt_PlusOrMinus);
		bt_PlusOrMinus.addActionListener(pm);

		JButton bt_0 = new JButton("0");
		bt_0.setBounds(148, 300, 69, 42);
		contentPane.add(bt_0);
		bt_0.addActionListener(append);

		JButton bt_dot = new JButton(".");
		bt_dot.setBounds(229, 300, 69, 42);
		contentPane.add(bt_dot);
		bt_dot.addActionListener(dot);

		JButton bt_equal = new JButton("=");
		bt_equal.setBounds(310, 300, 69, 42);
		contentPane.add(bt_equal);
		bt_equal.addActionListener(calc);

	}


	private class IsNumeric implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(textField.getText().equals("0")) {
				textField.setText("");
			}
			textField.setText(textField.getText() + e.getActionCommand());
		}
	}

	private class SetOpe implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ope = e.getActionCommand();
			firstNum = new BigDecimal(textField.getText());
			textField.setText("0");
		}
	}

	private class DoCalc implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			secondNum = new BigDecimal(textField.getText());
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
					//	result = firstNum.divide(secondNum,3,RoundingMode.HALF_UP);
					break;
				}
			}catch(ArithmeticException | NullPointerException exception) {
				System.out.println("例外発生");
			}
			textField.setText(String.valueOf(result));
		}
	}

	private class DoAllClear implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			firstNum = BigDecimal.ZERO;
			secondNum = BigDecimal.ZERO;
			textField.setText("0");
		}
	}

	private class DoClear implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			textField.setText("0");
		}
	}

	private class AddDot implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(textField.getText().contains(DOT)) {
				return;
			}
			textField.setText(textField.getText() + DOT);
		}
	}

	private class RightDelete implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(textField.getText().length()==1) {
				textField.setText("0");
			}else {
				textField.setText(textField.getText().substring(0, textField.getText().length()-1));
			}
		}
	}

	private class AddPlus_Minus implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String text = null;;

			if(textField.getText().equals("0")) {
				return;
			}else if(textField.getText().contains(DOT)) {
				text = aFewPtn(textField.getText());
				textField.setText(text);
				return;
			}

			if(Integer.parseInt(textField.getText()) < 0) {
				text = textField.getText().substring(1);
			}else {
				text = MINUS + textField.getText();
			}
			textField.setText(text);
		}
	}
	//少数の場合に遷移するメソッド
	private static String aFewPtn(String syousuu) {
		String text = null;
		if(syousuu.charAt(0)==MINUS) {
			text = syousuu.substring(1);
		}else {
			text = MINUS + syousuu;
		}
		return text;
	}
}