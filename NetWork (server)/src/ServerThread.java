import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 개별 클라이언트와 메세지를 주고 받는 스레드
 *   Socket: 멤버변수, 생성자를 통해서 TestServer에서 할당 받는다.
 * 1. extends Thread
 * 2. run()
 *   클라이언트의 메세지를 주고 받는 비즈니스(Socket)
 * @author 관리자
 *
 */


public class ServerThread extends Thread{
 //멤버변수로 선언

 private BufferedReader br = null;
 private PrintWriter pw = null;
 private String userIP = Frame.socket.getInetAddress().toString();
 private int userPORT = Frame.socket.getPort();
 ServerThread(){

 }
 //오버라이딩일 경우 throw 불가.
 public void run(){
  try{
	  pc.ServerTextArea1.append(userIP+" : "+userPORT+"\n");
	  pc.ServerTextArea1.append("신호생성기\n");
	  pc.ServerTextArea1.append("작업 대기중\n");
	  
	  
   service();
  // FileReceiver2.getConnention();
  }catch(IOException e){
   System.out.println("**"+userIP+"님 접속 종료.");
  } catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}finally{
   try {
    closeAll();
   } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
  }
 }
 
 private void service()throws IOException{
  br = new BufferedReader(new InputStreamReader( Frame.socket.getInputStream()));
  pw = new PrintWriter( Frame.socket.getOutputStream(), true);
  String str = null;
  while(true){
   str = br.readLine();//F,S,E
   
   
   if(str == null){
	   pc.ServerTextArea1.append(userIP+"님이 연결을 종료했습니다.");
    break;
   }
   //pw.println(FileReceiver.result+pc.portkey);
 // pc.ServerTextArea1.append(userIP+" 라즈베리파이: "+str +"\n");
   System.out.println(str);
   	   if (str.equals("1Hello"))
   	   {
   		 
	   pw.println(pc.port1+pc.portkey1);
	    
	   }
   	   else if (str.equals("2Hello"))
   	   {
   		  
	   pw.println(pc.port2+pc.portkey2);
	    
	   }
   	else if (str.equals("3Hello"))
	   {
		  
	   pw.println(pc.port3+pc.portkey3);
	    
	   } 
   	else if (str.equals("4Hello"))
	   {
		  
	   pw.println(pc.port4+pc.portkey4);
	    
	   } 
   	else if (str.equals("5Hello"))
	   {
		  
	   pw.println(pc.port5+pc.portkey5);
	    
	   } 
   	else if (str.equals("6Hello"))
	   {
		  
	   pw.println(pc.port6+pc.portkey6);
	    
	   } 
   	else if (str.equals("7Hello"))
	   {
		  
	   pw.println(pc.port7+pc.portkey7);
	    
	   } 
   	else if (str.equals("8Hello"))
	   {
		  
	   pw.println(pc.port8+pc.portkey8);
	    
	   } 
   	else if (str.equals("9Hello"))
	   {
		  
	   pw.println(pc.port9+pc.portkey9);
	    
	   } 
   	
	   else
	   {
	   // pw.println("quit");
	   }
		   
	   
   }
  }
 
 public void closeAll()throws IOException{
  if (pw != null)
   pw.close();
  if (br != null)
   br.close();
  if ( Frame.socket != null)
	  Frame.socket.close();
 }
}
