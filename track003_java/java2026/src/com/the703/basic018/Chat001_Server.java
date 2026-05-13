package com.the703.basic018;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class Chat001_Server {
	public static void main(String[] args) {
		// 1) 서버소켓(a/s 센터), 포트 바인딩(문 열어 놓기)
		ServerSocket ascenter = null;
		Socket info = null;

		try {
			ascenter = new ServerSocket(703); // 127.0.0.1:703 [ | | | | ] 응답받을 칸 열어 놓고 대기중 (703번 포트)
			System.out.println("[Server] 1. 서버준비완료 A/S 센터 OPEN....");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("[Server] 2. 고객 기다리는중....");

		try {
			info = ascenter.accept(); // 요청들어오면 info가 받음
			// 연결이 들어오면 소켓으로 연결
			System.out.println("[Server] 4. 고객님 연락와서 상담사랑(socket) 연결함....");

			Thread sender = new Sender(info);
			sender.start();
			Thread receiver = new Receiver(info);
			receiver.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/////////////////////////////////////////////////////////////////////////////////////
//	3) 클라이언트 소켓을 <-> 상담사 소켓이 읽어들이기
//	(★듣기 InputStream > 프로그램기준 > 말하기 OutputStream)
class Receiver extends Thread {
	DataInputStream in;
	Socket socket;

	public Receiver() {
		super();
	}

	public Receiver(Socket socket) {
		this.socket = socket;
		try {
			in = new DataInputStream(socket.getInputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		try {
			while (in != null) {
				System.out.println(in.readUTF());
			}
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("통신을 마무리 합니다.");
		} finally {
			try {
				if(in != null) { in.close(); }
				if(socket != null) { socket.close(); }
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}

/////////////////////////////////////////////////////////////////////////////////////

//(듣기 InputStream > 프로그램기준 > ★말하기 OutputStream)
class Sender extends Thread {
	DataOutputStream out;
	Socket socket;
	String who; 
	SimpleDateFormat sdf;
	
	public Sender() {
		super();
	}

	public Sender(Socket socket) {
		this.socket = socket;	//상대방과 연결되어 있는 정보
		try {
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//누가, 시간
		this.who = "[" + ( socket.getPort() == 703 ? "Client" : "Server") ; //포트번호를 가지고있으면 client
		this.sdf = new SimpleDateFormat("HH:mm:ss"); //hh 12시간 기준(am/pm) , HH 24시간제 (13시 14시...)
	}

	@Override
	public void run() {
		BufferedReader br = 
				new BufferedReader((new InputStreamReader(System.in)));	//카보드로 써서 말하기
		try {
			while (out != null) {
				String time = sdf.format(System.currentTimeMillis());
				out.writeUTF( this.who + time + "]" + br.readLine());
			}
		}catch(Exception e) {
//			e.printStackTrace();
			System.out.println("통신을 마무리 합니다.");
		}finally {
			  try {
				if(br != null)br.close();
				if(out != null) { out.close(); }
				if(!socket.isClosed()) { socket.close(); }
			} catch (IOException e) {
				e.printStackTrace();
				
			} 

		}
	}
}

/*
 * 
 * 1. http 통신 - 단방향 (client 요청이 있을때, server 응답하고 연결 종료) 2. socket 통신 - 양방향
 * (특정포트를 통해 실시간으로 정보 주고 받음 - tcp/udp) 3. 소켓통신흐름 1) 서버소켓(as 센터), 포트 바인딩(문 열어 놓기)
 * 2) 클라이언트 연결 요청 수락 3) 클라이언트 소켓을 <-> 상담사 소켓이 읽어들이기 (InputStream > 프로그램기준 >
 * OutputStream)
 * 
 */