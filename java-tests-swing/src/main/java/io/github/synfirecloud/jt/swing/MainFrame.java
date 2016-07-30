package io.github.synfirecloud.jt.swing;

import sun.applet.Main;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by synFireCloud on 7/19/16.
 */
public class MainFrame extends JFrame {
	private JList<ListItemModel> finds;
	private JButton send;
	private JTextPane logContent;
	private JTextPane sendContent;
	private JScrollPane findsScroll,logContentScroll,sendContentScroll;

	public MainFrame() throws HeadlessException {
		super();
		finds = new JList<ListItemModel>();
		findsScroll = new JScrollPane(finds);
		findsScroll.setBounds(0,0,200,400);
		finds.setCellRenderer(new ListItem());
		finds.setListData(new ListItemModel[]{new ListItemModel("FireCloud","IPv4,IPv6","A1:23:45:12:45:23"),new ListItemModel("YangNan.Shi","IPv4,IPv6","A1:23:45:12:45:23")});

		send = new JButton("Send");
		send.setBounds(550,350,50,50);
		send.setMargin(new Insets(0,0,0,0));

		logContent = new JTextPane();
		logContentScroll = new JScrollPane(logContent);
		logContentScroll.setBounds(200,0,400,350);

		sendContent = new JTextPane();
		sendContentScroll = new JScrollPane(sendContent);
		sendContentScroll.setBounds(200,350,350,50);


		this.setLayout(null);
		this.add(findsScroll);
		this.add(logContentScroll);
		this.add(sendContentScroll);
		this.add(send);
		this.setSize(600,425);
		this.setResizable(false);
	}

	public static void main(String[] args){
		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
