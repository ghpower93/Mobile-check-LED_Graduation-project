
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

class pc extends JPanel {

	/**
	* 
	*/
	static String portkey1;
	static String portkey2;
	static String portkey3;
	static String portkey4;
	static String portkey5;
	static String portkey6;
	static String portkey7;
	static String portkey8;
	static String portkey9;
	static String portkey10;
	
	static String port1;
	static String port2;
	static String port3;
	static String port4;
	static String port5;
	static String port6;
	static String port7;
	static String port8;
	static String port9;
	static String port10;
	private static final long serialVersionUID = 1L;
	public static int ID;
	JFrame frame = new JFrame("Server Interface");
	JPanel PanelS = new JPanel();
	static JTextArea ServerTextArea1 = new JTextArea(30, 60);

	JFrame Cframe = new JFrame("Port State");

	JPanel Panel1 = new JPanel();
	JPanel PanelMobile1 = new JPanel();
	JPanel PanelMobile2 = new JPanel();
	JPanel PanelMobile3 = new JPanel();
	JPanel PanelMobile4 = new JPanel();
	JPanel PanelMobile5 = new JPanel();
	JPanel PanelMobile6 = new JPanel();

	static JPanel Mobileport1 = new JPanel();
	static JPanel Mobileport2 = new JPanel();
	static JPanel Mobileport3 = new JPanel();
	static JPanel Mobileport4 = new JPanel();
	static JPanel Mobileport5 = new JPanel();
	static JPanel Mobileport6 = new JPanel();
	static JPanel Mobileport7 = new JPanel();
	static JPanel Mobileport8 = new JPanel();
	static JPanel Mobileport9 = new JPanel();
	static JPanel Mobileport10 = new JPanel();
	static JPanel Mobileport11 = new JPanel();
	static JPanel Mobileport12 = new JPanel();
	static JPanel Mobileport13 = new JPanel();
	static JPanel Mobileport14 = new JPanel();
	static JPanel Mobileport15 = new JPanel();
	JPanel Mobileport16 = new JPanel();
	JPanel Mobileport17 = new JPanel();
	JPanel Mobileport18 = new JPanel();
	JPanel Mobileport19 = new JPanel();
	JPanel Mobileport20 = new JPanel();
	JPanel Mobileport21 = new JPanel();
	JPanel Mobileport22 = new JPanel();
	JPanel Mobileport23 = new JPanel();
	JPanel Mobileport24 = new JPanel();
	JPanel Mobileport25 = new JPanel();
	JPanel Mobileport26 = new JPanel();
	JPanel Mobileport27 = new JPanel();
	JPanel Mobileport28 = new JPanel();
	JPanel Mobileport29 = new JPanel();
	JPanel Mobileport30 = new JPanel();

	static JLabel label2 = new JLabel("휴대폰 분별 처리 상태");

	JLabel idline4 = new JLabel();
	JLabel idline5 = new JLabel();
	JLabel idline6 = new JLabel();
	JLabel idline7 = new JLabel();
	JLabel idline8 = new JLabel();
	JLabel idline9 = new JLabel();
	JLabel idline10 = new JLabel();

	JPanel Panel2 = new JPanel();
	JPanel RIMPanel = new JPanel();
	JPanel BottomPanel = new JPanel();

	static TextArea txt = new TextArea("PORT1");
	static TextArea txt2 = new TextArea("PORT2");
	static TextArea txt3 = new TextArea("PORT3");
	static TextArea txt4 = new TextArea("PORT4");
	static TextArea txt5 = new TextArea("PORT5");
	static TextArea txt6 = new TextArea("PORT6");
	static TextArea txt7 = new TextArea("PORT7");
	static TextArea txt8 = new TextArea("PORT8");
	static TextArea txt9 = new TextArea("PORT9");
	static TextArea txt10 = new TextArea("PORT10");
	static TextArea txt11 = new TextArea("PORT11");
	static TextArea txt12 = new TextArea("PORT12");
	static TextArea txt13 = new TextArea("PORT13");
	static TextArea txt14 = new TextArea("PORT14");
	static TextArea txt15 = new TextArea("PORT15");
	static TextArea txt16 = new TextArea("PORT16");
	static TextArea txt17 = new TextArea("PORT17");
	static TextArea txt18 = new TextArea("PORT18");
	static TextArea txt19 = new TextArea("PORT19");
	static TextArea txt20 = new TextArea("PORT20");
	static TextArea txt21 = new TextArea("PORT21");
	static TextArea txt22 = new TextArea("PORT22");
	static TextArea txt23 = new TextArea("PORT23");
	static TextArea txt24 = new TextArea("PORT24");
	static TextArea txt25 = new TextArea("PORTW25");
	static TextArea txt26 = new TextArea("PORT26");
	static TextArea txt27 = new TextArea("PORT27");
	static TextArea txt28 = new TextArea("PORT28");
	static TextArea txt29 = new TextArea("PORT29");
	static TextArea txt30 = new TextArea("PORT30");

	public void createFrame() {

		ServerTextArea1.setEditable(false);

		JScrollPane sp = new JScrollPane(ServerTextArea1);

		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Server Log");
		frame.add(PanelS, "Center");
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setSize(700, 600);



		PanelS.add(sp, BorderLayout.CENTER);
		sp.setSize(800,800);
		PanelS.setBackground(new Color(59, 61, 75));
	}

	public void ClientFrame() {

		RIMPanel.setLayout(new GridLayout(6, 5));
		Panel1.setLayout(new GridLayout(6, 6, 10, 5));

		RIMPanel.setBackground(new Color(59, 61, 75));
		PanelMobile1.setBackground(new Color(59, 61, 75));
		PanelMobile2.setBackground(new Color(59, 61, 75));
		PanelMobile3.setBackground(new Color(59, 61, 75));
		PanelMobile4.setBackground(new Color(59, 61, 75));
		PanelMobile5.setBackground(new Color(59, 61, 75));
		PanelMobile6.setBackground(new Color(59, 61, 75));

		BottomPanel.setBackground(new Color(59, 61, 75));
		Panel2.setBackground(new Color(59, 61, 75));
		Panel1.setBackground(new Color(59, 61, 75));

		Mobileport1.setBackground(new Color(59, 61, 75));
		Mobileport2.setBackground(new Color(59, 61, 75));
		Mobileport3.setBackground(new Color(59, 61, 75));
		Mobileport4.setBackground(new Color(59, 61, 75));
		Mobileport5.setBackground(new Color(59, 61, 75));
		Mobileport6.setBackground(new Color(59, 61, 75));
		Mobileport7.setBackground(new Color(59, 61, 75));
		Mobileport8.setBackground(new Color(59, 61, 75));
		Mobileport9.setBackground(new Color(59, 61, 75));
		Mobileport10.setBackground(new Color(59, 61, 75));
		Mobileport11.setBackground(new Color(59, 61, 75));
		Mobileport12.setBackground(new Color(59, 61, 75));
		Mobileport13.setBackground(new Color(59, 61, 75));
		Mobileport14.setBackground(new Color(59, 61, 75));
		Mobileport15.setBackground(new Color(59, 61, 75));
		Mobileport16.setBackground(new Color(59, 61, 75));
		Mobileport17.setBackground(new Color(59, 61, 75));
		Mobileport18.setBackground(new Color(59, 61, 75));
		Mobileport19.setBackground(new Color(59, 61, 75));
		Mobileport20.setBackground(new Color(59, 61, 75));
		Mobileport21.setBackground(new Color(59, 61, 75));
		Mobileport22.setBackground(new Color(59, 61, 75));
		Mobileport23.setBackground(new Color(59, 61, 75));
		Mobileport24.setBackground(new Color(59, 61, 75));
		Mobileport25.setBackground(new Color(59, 61, 75));
		Mobileport26.setBackground(new Color(59, 61, 75));
		Mobileport27.setBackground(new Color(59, 61, 75));
		Mobileport28.setBackground(new Color(59, 61, 75));
		Mobileport29.setBackground(new Color(59, 61, 75));
		Mobileport30.setBackground(new Color(59, 61, 75));

		label2.setForeground(Color.WHITE);

		idline4.setFont(new Font("Lovelo Black", Font.PLAIN, 14));
		idline4.setForeground(Color.white);

		Mobileport1.setLayout(new BorderLayout());
		Mobileport2.setLayout(new BorderLayout());
		Mobileport3.setLayout(new BorderLayout());
		Mobileport4.setLayout(new BorderLayout());
		Mobileport5.setLayout(new BorderLayout());
		Mobileport6.setLayout(new BorderLayout());
		Mobileport7.setLayout(new BorderLayout());
		Mobileport8.setLayout(new BorderLayout());
		Mobileport9.setLayout(new BorderLayout());
		Mobileport10.setLayout(new BorderLayout());
		Mobileport11.setLayout(new BorderLayout());
		Mobileport12.setLayout(new BorderLayout());
		Mobileport13.setLayout(new BorderLayout());
		Mobileport14.setLayout(new BorderLayout());
		Mobileport15.setLayout(new BorderLayout());
		Mobileport16.setLayout(new BorderLayout());
		Mobileport17.setLayout(new BorderLayout());
		Mobileport18.setLayout(new BorderLayout());
		Mobileport19.setLayout(new BorderLayout());
		Mobileport20.setLayout(new BorderLayout());
		Mobileport21.setLayout(new BorderLayout());
		Mobileport22.setLayout(new BorderLayout());
		Mobileport23.setLayout(new BorderLayout());
		Mobileport24.setLayout(new BorderLayout());
		Mobileport25.setLayout(new BorderLayout());
		Mobileport26.setLayout(new BorderLayout());
		Mobileport27.setLayout(new BorderLayout());
		Mobileport28.setLayout(new BorderLayout());
		Mobileport29.setLayout(new BorderLayout());
		Mobileport30.setLayout(new BorderLayout());

		PanelMobile1.setLayout(new GridLayout(1, 5));
		PanelMobile2.setLayout(new GridLayout(1, 5));
		PanelMobile3.setLayout(new GridLayout(1, 5));
		PanelMobile4.setLayout(new GridLayout(1, 5));
		PanelMobile5.setLayout(new GridLayout(1, 5));
		PanelMobile6.setLayout(new GridLayout(1, 5));

		frame.pack();

		Panel2.setLayout(new GridLayout(1, 1));
		BottomPanel.setLayout(new GridLayout(3, 1));

		txt.setEditable(false);
		txt2.setEditable(false);
		txt3.setEditable(false);
		txt4.setEditable(false);
		txt5.setEditable(false);
		txt6.setEditable(false);
		txt7.setEditable(false);
		txt8.setEditable(false);
		txt9.setEditable(false);
		txt10.setEditable(false);
		txt11.setEditable(false);
		txt12.setEditable(false);
		txt13.setEditable(false);
		txt14.setEditable(false);
		txt15.setEditable(false);
		txt16.setEditable(false);
		txt17.setEditable(false);
		txt18.setEditable(false);
		txt19.setEditable(false);
		txt20.setEditable(false);
		txt21.setEditable(false);
		txt22.setEditable(false);
		txt23.setEditable(false);
		txt24.setEditable(false);
		txt25.setEditable(false);
		txt26.setEditable(false);
		txt27.setEditable(false);
		txt28.setEditable(false);
		txt29.setEditable(false);
		txt30.setEditable(false);

		frame.setSize(500, 500);

		frame.add(RIMPanel, "North");

		RIMPanel.add(label2);// 타이틀

		RIMPanel.add(idline4);
		RIMPanel.add(idline5);

		label2.setHorizontalAlignment(SwingConstants.CENTER);

		label2.setFont(new Font("Lovelo Black", Font.PLAIN, 13));
		label2.setFont(new Font("Lovelo Black", Font.PLAIN, 13));

		frame.add(Panel1, "Center");

		Mobileport1.add(txt, "Center");
		Mobileport2.add(txt2, "Center");
		Mobileport3.add(txt3, "Center");
		Mobileport4.add(txt4, "Center");
		Mobileport5.add(txt5, "Center");
		Mobileport6.add(txt6, "Center");
		Mobileport7.add(txt7, "Center");
		Mobileport8.add(txt8, "Center");
		Mobileport9.add(txt9, "Center");
		Mobileport10.add(txt10, "Center");
		Mobileport11.add(txt11, "Center");
		Mobileport12.add(txt12, "Center");
		Mobileport13.add(txt13, "Center");
		Mobileport14.add(txt14, "Center");
		Mobileport15.add(txt15, "Center");
		Mobileport16.add(txt16, "Center");
		Mobileport17.add(txt17, "Center");
		Mobileport18.add(txt18, "Center");
		Mobileport19.add(txt19, "Center");
		Mobileport20.add(txt20, "Center");
		Mobileport21.add(txt21, "Center");
		Mobileport22.add(txt22, "Center");
		Mobileport23.add(txt23, "Center");
		Mobileport24.add(txt24, "Center");
		Mobileport25.add(txt25, "Center");
		Mobileport26.add(txt26, "Center");
		Mobileport27.add(txt27, "Center");
		Mobileport28.add(txt28, "Center");
		Mobileport29.add(txt29, "Center");
		Mobileport30.add(txt30, "Center");

		PanelMobile1.add(Mobileport1);
		PanelMobile1.add(Mobileport2);
		PanelMobile1.add(Mobileport3);
		PanelMobile1.add(Mobileport4);
		PanelMobile1.add(Mobileport5);

		PanelMobile2.add(Mobileport6);
		PanelMobile2.add(Mobileport7);
		PanelMobile2.add(Mobileport8);
		PanelMobile2.add(Mobileport9);
		PanelMobile2.add(Mobileport10);

		PanelMobile3.add(Mobileport11);
		PanelMobile3.add(Mobileport12);
		PanelMobile3.add(Mobileport13);
		PanelMobile3.add(Mobileport14);
		PanelMobile3.add(Mobileport15);

		PanelMobile4.add(Mobileport16);
		PanelMobile4.add(Mobileport17);
		PanelMobile4.add(Mobileport18);
		PanelMobile4.add(Mobileport19);
		PanelMobile4.add(Mobileport20);

		PanelMobile5.add(Mobileport21);
		PanelMobile5.add(Mobileport22);
		PanelMobile5.add(Mobileport23);
		PanelMobile5.add(Mobileport24);
		PanelMobile5.add(Mobileport25);

		PanelMobile6.add(Mobileport26);
		PanelMobile6.add(Mobileport27);
		PanelMobile6.add(Mobileport28);
		PanelMobile6.add(Mobileport29);
		PanelMobile6.add(Mobileport30);

		Panel1.add(PanelMobile1);
		Panel1.add(PanelMobile2);
		Panel1.add(PanelMobile3);
		Panel1.add(PanelMobile4);
		Panel1.add(PanelMobile5);
		Panel1.add(PanelMobile6);

		frame.add(Panel2, "South");
		Panel2.add(BottomPanel);
		txt.setCaretPosition(0);
		txt.setPreferredSize(null);

		frame.setVisible(true);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

	}

	public static void addLog(String log) {
		ServerTextArea1.append(log + "\n");
		ServerTextArea1.setCaretPosition(ServerTextArea1.getDocument().getLength());
	/*	pc.portkey1=null;
		pc.portkey2=null;
		pc.portkey3=null;
		pc.portkey4=null;
		pc.portkey5=null;
		pc.portkey6=null;
		pc.portkey7=null;
		pc.portkey8=null;
		pc.portkey9=null;
		pc.portkey10=null;
		
		pc.port1=null;
		pc.port2=null;
		pc.port3=null;
		pc.port4=null;
		pc.port5=null;
		pc.port6=null;
		pc.port7=null;
		pc.port8=null;
		pc.port9=null;
		pc.port10=null;*/
		
		if (log.contains("1번포트")) {
			pc.port1="F";
			pc.portkey1="1";
			if (log.contains("Verified  배터리")) {
				pc.txt.setBackground(Color.GREEN);
				pc.txt.setText("PORT1 \n Verified");
				pc.port1="V";

			}

			else if (log.contains("Not verified  배터리")) {
				pc.txt.setBackground(Color.YELLOW);
				pc.txt.setText("PORT1 \n Not verified");
				pc.port1="E";


			} else {
			
				pc.txt.setBackground(Color.GRAY);
				pc.txt.setText("PORT1 \n Disconnected");
			}
		} else if (log.contains("2번포트")) {
			pc.port2="F";
			pc.portkey2="2";
			if (log.contains("Verified  배터리")) {
				pc.port2="V";
				pc.txt2.setBackground(Color.GREEN);
				pc.txt2.setText("PORT2 \n Verified");

			}

			else if (log.contains("Not verified  배터리")) {
				pc.port2="E";
				pc.txt2.setBackground(Color.YELLOW);
				pc.txt2.setText("PORT2 \n Not verified");

			} else {
			
				pc.txt2.setBackground(Color.GRAY);
				pc.txt2.setText("PORT2 \n Disconnected");
			}
		} else if (log.contains("3번포트")) {
			pc.portkey3="3";
			pc.port3="F";
			if (log.contains("Verified  배터리")) {
				pc.port3="V";
				
				pc.txt3.setBackground(Color.GREEN);
				pc.txt3.setText("PORT3 \n Verified");

			}

			else if (log.contains("Not verified  배터리")) {
				pc.port3="E";
				
				pc.txt3.setBackground(Color.YELLOW);
				pc.txt3.setText("POR3 \n Not verified");

			} else {
			
				
				pc.txt3.setBackground(Color.GRAY);
				pc.txt3.setText("PORT3 \n Disconnected");
			}
		} else if (log.contains("4번포트")) {
			pc.portkey4="4";
			if (log.contains("Verified  배터리")) {
				pc.port4="V";
				
				pc.txt4.setBackground(Color.GREEN);
				pc.txt4.setText("PORT4 \n Verified");

			}

			else if (log.contains("Not verified  배터리")) {
				pc.port4="E";
				
				pc.txt4.setBackground(Color.YELLOW);
				pc.txt4.setText("PORT4 \n Not verified");

			} else {
				pc.port4="F";
				
				pc.txt4.setBackground(Color.GRAY);
				pc.txt4.setText("PORT4 \n Disconnected");
			}
		} else if (log.contains("5번포트")) {
			pc.portkey5="5";
			if (log.contains("Verified  배터리")) {
				pc.port5="V";
				
				pc.txt5.setBackground(Color.GREEN);
				pc.txt5.setText("PORT5 \n Verified");

			}

			else if (log.contains("Not verified  배터리")) {
				pc.port5="E";
				
				pc.txt5.setBackground(Color.YELLOW);
				pc.txt5.setText("PORT5 \n Not verified");

			} else {
				pc.port5="F";
				
				pc.txt5.setBackground(Color.GRAY);
				pc.txt5.setText("PORT5 \n Disconnected");
			}
		}

		else if (log.contains("6번포트")) {		
			pc.portkey6="6";
			if (log.contains("Verified  배터리")) {
				pc.txt6.setBackground(Color.GREEN);
				pc.txt6.setText("PORT6 \n Verified");

			}

			else if (log.contains("Not verified  배터리")) {
				pc.txt6.setBackground(Color.YELLOW);
				pc.txt6.setText("PORT6 \n Not verified");

			} else {
				pc.txt6.setBackground(Color.GRAY);
				pc.txt6.setText("PORT6 \n Disconnected");
			}
		} else if (log.contains("7번포트")) {
			pc.portkey7="7";
			if (log.contains("Verified  배터리")) {
				pc.txt7.setBackground(Color.GREEN);
				pc.txt7.setText("PORT7 \n Verified");

			}

			else if (log.contains("Not verified  배터리")) {
				pc.txt7.setBackground(Color.YELLOW);
				pc.txt7.setText("PORT7 \n Not verified");

			} else {
				pc.txt7.setBackground(Color.GRAY);
				pc.txt7.setText("PORT7 \n Disconnected");
			}
		} else if (log.contains("8번포트")) {
			pc.portkey8="8";
			if (log.contains("Verified  배터리")) {
				pc.txt8.setBackground(Color.GREEN);
				pc.txt8.setText("PORT8 \n Verified");

			}

			else if (log.contains("Not verified  배터리")) {
				pc.txt8.setBackground(Color.YELLOW);
				pc.txt8.setText("PORT8 \n Not verified");

			} else {
				pc.txt8.setBackground(Color.GRAY);
				pc.txt8.setText("PORT8 \n Disconnected");
			}
		} else if (log.contains("9번포트")) {
			pc.portkey9="9";
			if (log.contains("Verified  배터리")) {
				pc.txt9.setBackground(Color.GREEN);
				pc.txt9.setText("PORT9 \n Verified");

			}

			else if (log.contains("Not verified  배터리")) {
				pc.txt9.setBackground(Color.YELLOW);
				pc.txt9.setText("PORT9 \n Not verified");

			} else {
				pc.txt9.setBackground(Color.GRAY);
				pc.txt9.setText("PORT9 \n Disconnected");
			}
		} else if (log.contains("10번포트")) {
			pc.portkey10="10";
			if (log.contains("Verified  배터리")) {
				pc.txt10.setBackground(Color.GREEN);
				pc.txt10.setText("PORT10 \n Verified");

			}

			else if (log.contains("Not verified  배터리")) {
				pc.txt10.setBackground(Color.YELLOW);
				pc.txt10.setText("PORT10 \n Not verified");

			} else {
				pc.txt10.setBackground(Color.GRAY);
				pc.txt10.setText("PORT10 \n Disconnected");
			}
			
			pc.portkey1=null;
			pc.portkey2=null;
			pc.portkey3=null;
			pc.portkey4=null;
			pc.portkey5=null;
			pc.portkey6=null;
			pc.portkey7=null;
			pc.portkey8=null;
			pc.portkey9=null;
			pc.portkey10=null;
			
			pc.port1=null;
			pc.port2=null;
			pc.port3=null;
			pc.port4=null;
			pc.port5=null;
			pc.port6=null;
			pc.port7=null;
			pc.port8=null;
			pc.port9=null;
			pc.port10=null;
		}
	}

}

public class Frame {
	static Socket socket;
	static String FileName = null;
	public static final int PORT = 50002;
	 static  String PY_IP = "10.10.88.18";
	 static ServerSocket serverSocket = null;

	public static void main(String[] args) {
		pc ServerPanel = new pc();
		ServerPanel.createFrame();
		pc ClientPanel = new pc();
		
		List<PrintWriter> listWriters = new ArrayList<PrintWriter>(); // listWriters 변수는 채팅 서버에 연결된 모든 클라이언트들을 저장하고 있는
																		// List입니다. ( join시 추가됨 )

		try {
			serverSocket = new ServerSocket(PORT);
			// 2. 바인딩
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			pc.addLog("IP : " + hostAddress + ", PORT : " + PORT);
			pc.addLog("소켓 생성 완료...");
			// 3. 요청 대기
			   while(true){
			socket = serverSocket.accept();

			pc.addLog("작업 클라이언트- IP: "+ socket.getInetAddress().toString()+" PORT: "+ socket.getPort() + "접속 완료...\n");

		//	if(Thread.currentThread().getId().equals)
		//	pysending.send();
		//main824318946
		//main824318946
			//java.net.Socket
			//
		
			//5[Ljava.lang.StackTraceElement;@31221be2RUNNABLEnull
			//5[Ljava.lang.StackTraceElement;@31221be2RUNNABLEnull

			
			if(socket.getInetAddress().toString().contains(PY_IP))
			{
				  ServerThread st = new ServerThread();
				    st.start();
				    
			
			}
			else{
			ClientPanel.ClientFrame();
			new ServerProcessThread(socket, listWriters).start();
			
		
			}
			   }
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
	}

}