import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServerProcessThread extends Thread {
	private String RMA = null;
	private Socket socket = null;
	static ServerSocket Ssocket = null;
	List<PrintWriter> listWriters = null;
	static InetAddress ia = null;
	static int iaport = 0;
	static InetAddress preIP = null;
	static int preport = 0;
	String tokens;
	static String fileName;
	static String request = "";
	String imeis;

	public ServerProcessThread(Socket socket, List<PrintWriter> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
		// this.Ssocket = Ssocket;
	}

	@Override
	public void run() {
		try {
			
			
			
			BufferedReader buffereedReader = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

			PrintWriter printWriter = new PrintWriter(
					new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));

			while (true) {

				/*if(socket.isClosed())
				{
			
					socket=Frame.serverSocket.accept();
					//socket = serverSocket.accept();
					buffereedReader = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
					
				}*/
				
				
				this.socket.getInetAddress();
				InetAddress ia = this.socket.getInetAddress();
				iaport = this.socket.getPort(); // ������ ��� ���ϰ� �޶����� ����ϰԲ� ��� �ұ�?
				consoleLog2(ia, iaport);
	
				request = buffereedReader.readLine();

//�����Ұ�
		
			
				pc.addLog(request);
			

			
				if (request == null) {
					pc.addLog("Ŭ���̾�Ʈ�κ��� ���� ����");
					doQuit(printWriter);
					break;
				}
				tokens = request;
				if(!(tokens.contains("����Ʈ:")) && !(tokens.contains("ed"))) {
				if (tokens.equals("�������� ���")) {
					pc.addLog("�۾� �����");
					pc.label2.setText("�������� ��� �޴��� ó������");

					List<String> where = new ArrayList<String>();
					where.add("LG");
					where.add("LG V SERIES");

					where.add("4664ee3e");
					where.add("LMV500N3043a8c1");
					where.add("LGF510Sf3b15a6f");

					where.add(2, (String.valueOf(where.size() - 2)));

					String[] imei = new String[where.size()];
					where.toArray(imei);
					doJoin(tokens, printWriter);
					imeis=Arrays.toString(imei);
					broadcast(imeis);
					imeis=null;
					where.clear();

				} else if (tokens.equals("�Ｚ���� ���뱸")) {
					pc.addLog("�۾� �����");
					pc.label2.setText("�Ｚ���� ���뱸 ���� �޴��� ó������");

					List<String> where = new ArrayList<String>();
					where.add("SAMSUNG");
					where.add("SAMSUNG GALAXCY SERIES");

					where.add("ebdedcde");
					
					where.add(2, (String.valueOf(where.size() - 2)));

					String[] imei = new String[where.size()];
					where.toArray(imei);
					doJoin(tokens, printWriter);
					imeis=Arrays.toString(imei);
					broadcast(imeis);
					imeis=null;
					where.clear();

				} else if (tokens.equals("���� ���")) {
					pc.addLog("�۾� �����");
					pc.label2.setText("���� ��� ���� �޴��� ó������");

					List<String> where = new ArrayList<String>();
					where.add("GOOGLE");
					where.add("PIXEL SERIES");

					where.add("1324233363934313");
					where.add("1324204339643934");
					where.add("1324233363934313");
					where.add("1324204339643934");
					where.add("1324233363934313");
					where.add("1324204339643934");
					where.add("1324233363934313");
					where.add("1324204339643934");
					where.add("1324233363934313");
					where.add("1324204339643934");
					where.add("1324204339643934");
					where.add("1324233363934313");
					where.add("1324204339643934");
					where.add("1324204339643934");
					where.add("1324233363934313");
					where.add("1324204339643934");
					where.add(2, (String.valueOf(where.size() - 2)));

					String[] imei = new String[where.size()];
					where.toArray(imei);
					doJoin(tokens, printWriter);
					broadcast(Arrays.toString(imei));
					 where.clear();

				}
	
				
				else {
					if(request.contains("���� �۾��Ϸ�")) {
						request="�����۾� �����";
					}
					else {
					pc.addLog(this.RMA+ "�۾� Ȯ�ιٶ�");
				
					List<String> where = new ArrayList<String>();
					where.add("PRODUCT_ERROR_�߻�");
					where.add("MANUFACTURE_CHECK_�ٶ�");
				
					where.add("Notify_error");
					where.add(2, "0");

					

					String[] imei = new String[where.size()];
					where.toArray(imei);
					doJoin(tokens, printWriter);
					imeis=Arrays.toString(imei);
					broadcast(imeis);
					imeis=null;
					where.clear();
					}
				}
			//	FileReceiver fr = new FileReceiver(socket);
			//	fr.start();
			}
				else {
					
					
					
				}	
			
			}
		
			// fileName = request.substring(a+14,b);
		
	
//			File f = new File("355693104743623.ad");
		} catch (  IOException e) {
			e.printStackTrace();
			pc.addLog("�۾��� ��ǻ��: " + Thread.currentThread().getId() + "���� ����...\n");
		}

	}

	private void removeWriter(PrintWriter writer) {
		synchronized (listWriters) {
			listWriters.remove(writer);
		}
	}

	private void doQuit(PrintWriter writer) {
		removeWriter(writer);

	//	String data = this.RMA + " ���� ����.";
		// broadcast(data);
		pc.addLog("�۾��� ��ǻ��: " + Thread.currentThread().getId() + "���� ����...\n");

	}

	private void doJoin(String RMA, PrintWriter writer) {
		this.RMA = RMA;
		// String data = "RMANumber : "+RMA;
		// consoleLog(data);
		// broadcast(RMA);
		// writer pool�� ����
		addWriter(writer);
	}

	private void addWriter(PrintWriter writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}

	private void broadcast(String data) {
		synchronized (listWriters) {
			for (PrintWriter writer : listWriters) {
				writer.println(data);
				writer.flush();

			}
		}
	}

	/*
	 * static void FN(String FileNam) { FileNam = fileName; }
	 */


	private void consoleLog2(InetAddress ip, int port) {
		if (ip != preIP && port != preport) {
	
			pc.addLog(ip + " : " + port);
		} else {

		}
		preIP = ip;
		preport = port;

	}
}