package view;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Chess;
import model.ChessView;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import javax.swing.JLabel;

public class WuZiQiView extends JFrame {

	private JPanel contentPane;
	public static ChessView chessView=new ChessView();//设置棋盘
	//public Chess chess=new Chess();//设置棋子
	
	private JButton btnNewButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public static JRadioButton pcWar;//人机对战
	public static JRadioButton ppWar;//人人对战
	
	public static JTextArea textArea;
	public static JTextArea textArea_1;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private JPanel panel_2;
	private JLabel label_21;
	private JLabel label_22;
	private JLabel label_23;
	private JLabel label_24;
	private JLabel label_25;
	private JLabel label_26;
	private JLabel label_27;
	private JLabel label_28;
	private JLabel label_29;
	private JLabel label_30;
	private JLabel label_31;
	private JLabel label_32;
	private JLabel label_33;
	private JLabel label_34;
	private JLabel label_35;
	private JLabel label_36;
	private JLabel label_37;
	private JLabel label_38;
	private JLabel label_39;
	private JLabel label_40;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WuZiQiView frame = new WuZiQiView();
					frame.setVisible(true);
					
					chessView.addMouseListener(chessView);//添加鼠标监听器
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
				
	}

	/**
	 * Create the frame.
	 */
	public WuZiQiView() {
		setTitle("\u5C0F\u7C73\u4E94\u5B50\u68CB");
		setIconImage(Toolkit.getDefaultToolkit().getImage(WuZiQiView.class.getResource("/images/Chess_48px_502066_easyicon.net.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1117, 956);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		chessView.setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, 0, 0, Short.MAX_VALUE)
						.addComponent(chessView, GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(119, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 803, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE)
						.addComponent(chessView, GroupLayout.PREFERRED_SIZE, 802, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		label_21 = new JLabel("1");
		
		label_22 = new JLabel("2");
		
		label_23 = new JLabel("3");
		
		label_24 = new JLabel("4");
		
		label_25 = new JLabel("5");
		
		label_26 = new JLabel("6");
		
		label_27 = new JLabel("7");
		
		label_28 = new JLabel("8");
		
		label_29 = new JLabel("9");
		
		label_30 = new JLabel("10");
		
		label_31 = new JLabel("11");
		
		label_32 = new JLabel("12");
		
		label_33 = new JLabel("13");
		
		label_34 = new JLabel("14");
		
		label_35 = new JLabel("15");
		
		label_36 = new JLabel("16");
		
		label_37 = new JLabel("17");
		
		label_38 = new JLabel("18");
		
		label_39 = new JLabel("19");
		
		label_40 = new JLabel("20");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(label_21, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_22, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_23, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_24, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_25, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_26, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_27, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_28, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_29, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_30, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_31, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_32, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_33, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_34, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_35, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_36, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_37, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_39, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_40, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_38, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_21)
					.addGap(18)
					.addComponent(label_22)
					.addGap(26)
					.addComponent(label_23)
					.addGap(18)
					.addComponent(label_24)
					.addGap(27)
					.addComponent(label_25)
					.addGap(26)
					.addComponent(label_26)
					.addGap(18)
					.addComponent(label_27)
					.addGap(18)
					.addComponent(label_28)
					.addGap(18)
					.addComponent(label_29)
					.addGap(26)
					.addComponent(label_30)
					.addGap(29)
					.addComponent(label_31)
					.addGap(18)
					.addComponent(label_32)
					.addGap(18)
					.addComponent(label_33)
					.addGap(28)
					.addComponent(label_34)
					.addGap(18)
					.addComponent(label_35)
					.addGap(26)
					.addComponent(label_36)
					.addGap(18)
					.addComponent(label_37)
					.addGap(18)
					.addComponent(label_38)
					.addGap(27)
					.addComponent(label_39)
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addComponent(label_40)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel label = new JLabel("1");
		
		label_1 = new JLabel("2");
		
		label_2 = new JLabel("3");
		
		label_3 = new JLabel("4");
		
		label_4 = new JLabel("5");
		
		label_5 = new JLabel("6");
		
		label_6 = new JLabel("7");
		
		label_7 = new JLabel("8");
		
		label_8 = new JLabel("9");
		
		label_9 = new JLabel("10");
		
		label_10 = new JLabel("11");
		
		label_11 = new JLabel("12");
		
		label_12 = new JLabel("13");
		
		label_13 = new JLabel("14");
		
		label_14 = new JLabel("15");
		
		label_15 = new JLabel("16");
		
		label_16 = new JLabel("17");
		
		label_17 = new JLabel("18");
		
		label_18 = new JLabel("19");
		
		label_19 = new JLabel("1");
		
		label_20 = new JLabel("20");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addGap(34)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(label_9)
					.addGap(18)
					.addComponent(label_10)
					.addGap(31)
					.addComponent(label_11)
					.addGap(18)
					.addComponent(label_12)
					.addGap(27)
					.addComponent(label_13)
					.addGap(27)
					.addComponent(label_14)
					.addGap(18)
					.addComponent(label_15)
					.addGap(27)
					.addComponent(label_16)
					.addGap(26)
					.addComponent(label_17)
					.addGap(26)
					.addComponent(label_18)
					.addGap(18)
					.addComponent(label_20, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(label_19, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(49, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(label_4)
						.addComponent(label_5)
						.addComponent(label_6)
						.addComponent(label_7)
						.addComponent(label_8)
						.addComponent(label_9)
						.addComponent(label_10)
						.addComponent(label_19)
						.addComponent(label_12)
						.addComponent(label_13)
						.addComponent(label_14)
						.addComponent(label_15)
						.addComponent(label_16)
						.addComponent(label_17)
						.addComponent(label_18)
						.addComponent(label_20)
						.addComponent(label_11))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		btnNewButton = new JButton("\u5F00\u59CB\u6E38\u620F");
		btnNewButton.addMouseListener(new MouseAdapter() {//开始游戏
			@Override
			public void mouseClicked(MouseEvent e) {

				chessView.reset();
				Chess.lostOrWinFlag=false;
				
			}
		});


		JButton button = new JButton("\u6094\u68CB");
		button.addMouseListener(new MouseAdapter() {//悔棋
			@Override
			public void mouseClicked(MouseEvent e) {
				
				chessView.remorse();
			}
		});
		
		pcWar = new JRadioButton("\u4EBA\u673A\u5BF9\u6218");
		pcWar.setSelected(true);
		buttonGroup.add(pcWar);
		
		ppWar = new JRadioButton("\u4EBA\u4EBA\u5BF9\u6218");
		buttonGroup.add(ppWar);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 31));
		textArea.setText("\u9ED1\u65B9\u4E0B");
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 25));
		textArea_1.setLineWrap(true);
		textArea_1.setText("\u73B0\u5728\u662F\uFF1A\u4EBA\u673A\u5BF9\u6218");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(button, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
						.addComponent(ppWar, Alignment.LEADING)
						.addComponent(textArea_1, Alignment.LEADING)
						.addComponent(pcWar, Alignment.LEADING)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
						.addComponent(textArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
					.addGap(23))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addComponent(btnNewButton)
					.addGap(31)
					.addComponent(button)
					.addGap(39)
					.addComponent(pcWar)
					.addGap(18)
					.addComponent(ppWar)
					.addGap(12)
					.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(191, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
