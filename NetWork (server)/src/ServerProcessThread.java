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
				iaport = this.socket.getPort(); // 같으면 출력 안하고 달라지면 출력하게끔 어떻게 할까?
				consoleLog2(ia, iaport);
	
				request = buffereedReader.readLine();

//수정할것
		
			
				pc.addLog(request);
			

			
				if (request == null) {
					pc.addLog("클라이언트로부터 연결 끊김");
					doQuit(printWriter);
					break;
				}
				tokens = request;
				if(!(tokens.contains("번포트:")) && !(tokens.contains("ed"))) {
				if (tokens.equals("엘지전자 경산")) {
					pc.addLog("작업 대기중");
					pc.label2.setText("엘지전자 경산 휴대폰 처리상태");

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

				} else if (tokens.equals("삼성전자 동대구")) {
					pc.addLog("작업 대기중");
					pc.label2.setText("삼성전자 동대구 지점 휴대폰 처리상태");

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

				} else if (tokens.equals("구글 잠실")) {
					pc.addLog("작업 대기중");
					pc.label2.setText("구글 잠실 지점 휴대폰 처리상태");

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
					if(request.contains("파일 작업완료")) {
						request="다음작업 대기중";
					}
					else {
					pc.addLog(this.RMA+ "작업 확인바람");
				
					List<String> where = new ArrayList<String>();
					where.add("PRODUCT_ERROR_발생");
					where.add("MANUFACTURE_CHECK_바람");
				
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
			pc.addLog("작업자 컴퓨터: " + Thread.currentThread().getId() + "접속 종료...\n");
		}

	}

	private void removeWriter(PrintWriter writer) {
		synchronized (listWriters) {
			listWriters.remove(writer);
		}
	}

	private void doQuit(PrintWriter writer) {
		removeWriter(writer);

	//	String data = this.RMA + " 접속 종료.";
		// broadcast(data);
		pc.addLog("작업자 컴퓨터: " + Thread.currentThread().getId() + "접속 종료...\n");

	}

	private void doJoin(String RMA, PrintWriter writer) {
		this.RMA = RMA;
		// String data = "RMANumber : "+RMA;
		// consoleLog(data);
		// broadcast(RMA);
		// writer pool에 저장
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