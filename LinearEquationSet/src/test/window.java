package test;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;


public class window extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel1=new JPanel();
	JLabel label1=new JLabel();
	JLabel label2=new JLabel();
	JTextField text1=new JTextField(5);
	JTextArea text2=new JTextArea(5,10);
	JTextField textans=new JTextField(20);
	JButton button1=new JButton();
	JTextArea text5 = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(text5);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window frame = new window();
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public window() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dell\\Pictures\\201411101637422870.jpg"));
		setTitle("\u7EBF\u6027\u65B9\u7A0B\u7EC4\u8BA1\u7B97\u5668");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1091, 601);
		getContentPane().setLayout(null);
		panel1.setBounds(0, 0, 1073, 553);
		getContentPane().add(panel1);
		panel1.setLayout(null);
		label1.setFont(new Font("宋体", Font.PLAIN, 20));
		label1.setBounds(119, 91, 122, 52);
		panel1.add(label1);
		text1.setFont(new Font("宋体", Font.PLAIN, 20));
		text1.setBounds(255, 102, 93, 35);
		panel1.add(text1);
		label2.setFont(new Font("宋体", Font.PLAIN, 20));
		label2.setBounds(119, 143, 129, 35);
		panel1.add(label2);
		text2.setFont(new Font("Monospaced", Font.PLAIN, 20));
		text2.setBounds(119, 178, 256, 162);
		panel1.add(text2);
		textans.setFont(new Font("宋体", Font.PLAIN, 20));
		textans.setBounds(119, 391, 328, 42);
		panel1.add(textans);
		button1.setFont(new Font("宋体", Font.PLAIN, 20));
		button1.setBounds(185, 467, 82, 35);
		panel1.add(button1);
		
		label1.setText("请输入长度:");
		label2.setText("请输入系数:");
		
		clickAction act1=new clickAction();
		
		button1.addActionListener(act1);
		button1.setText("计算");
		
		JLabel label = new JLabel("\u8BA1\u7B97\u7ED3\u679C:");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(119, 340, 106, 42);
		panel1.add(label);
		text5.setWrapStyleWord(true);
		text5.setRows(10);
		text5.setLineWrap(true);
		text5.setFont(new Font("Monospaced", Font.PLAIN, 20));	
		text5.setBounds(568, 108, 370, 370);
		text5.setCaretPosition(text5.getText().length());
		//panel1.add(text5);
		panel1.add(scrollPane);
		JLabel background = new JLabel("");
		background.setHorizontalAlignment(SwingConstants.TRAILING);
		background.setIcon(new ImageIcon(window.class.getResource("/test/relax.jpg")));
		background.setBounds(0, 0, 1073, 553);
		panel1.add(background);
		scrollPane.setBounds(550, 82, 394, 391);
		
		
		
		textans.addActionListener(act1);
		
		
	}
	class clickAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			String text3=text1.getText();
			int num=Integer.valueOf(text3);
			String[] text4=text2.getText().split("\n");
			if(text4.length!=num) textans.setText("缺少数据，请重新输入");
			else {
				float[][] ma=new float[num][num];
				float[] mb=new float[num];
				calculation.fillinfo2(text4,ma,mb,num);
				String lans=calculation.GetResult(ma,mb);
				textans.setText(lans);
				text5.setText(calculation.getexplain());
			}
		}
	}
}
