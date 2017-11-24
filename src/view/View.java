package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

public class View extends JFrame {
	
	public static String FLASHERROR = "ERROR";
	public static String FLASHINFO = "INFO";

	private static JPanel contentPane;
	private static JPanel pagePanel;
	private static JPanel flashPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
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
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		flashPanel = new JPanel();
		flashPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		flashPanel.setLayout(new GridBagLayout());
		flashPanel.setVisible(false);
		contentPane.add(flashPanel, BorderLayout.NORTH);
		instantiatePage();
		redirectTo("HOME");
	}
	
	public void instantiatePage()
	{
		pagePanel = new JPanel();
		pagePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		pagePanel.setLayout(new CardLayout());
		File pageDir = new File("src/view/page");
		for(File page : pageDir.listFiles())
		{
			String pageName = page.getName().replace(".java", "");
			try {
				
				JPanel panel = (JPanel) Class.forName("view.page."+pageName).newInstance();
				pagePanel.add(panel, pageName.toUpperCase());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		contentPane.add(pagePanel, BorderLayout.CENTER);
	}
	
	public static void flash(String alertType, String message)
	{
		String taggedMessage = "<html>" + message + "</html>";
		JLabel notice = new JLabel(taggedMessage);
		if (alertType.equals(FLASHERROR))
		{
			flashPanel.setBackground(new Color(255, 102, 102));
			notice.setForeground(new Color(153, 0, 0));
			flashPanel.add(notice);
		}
		else if (alertType.equals(FLASHINFO))
		{
			flashPanel.setBackground(new Color(153, 255, 153));
			notice.setForeground(new Color(0, 153, 0));
			flashPanel.add(notice);
		}
		flashPanel.setVisible(true);
	}
	
	public static void redirectTo(String pageName)
	{
		cleanFlashPanel();
		CardLayout cardLayout = (CardLayout) pagePanel.getLayout();
		cardLayout.show(pagePanel, pageName);
	}
	
	private static void cleanFlashPanel()
	{
		flashPanel.setVisible(false);
	}

}
