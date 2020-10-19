package com.eomcs.pms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import com.eomcs.context.ApplicationContextListener;
import com.eomcs.pms.listener.AppInitListener;
import com.eomcs.pms.listener.DataHandlerListener;
import com.eomcs.pms.listener.RequestMappingListener;

public class ServerApp01 {
  static boolean stop = false;

  static Map<String, Object> context = new Hashtable<>();

  List<ApplicationContextListener> listeners = new ArrayList<>();

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void removeAppicationContextListener(ApplicationContextListener listener) {
    listeners.remove(listener);
  }


  private void notifyApplicationContextListenerOnServiceStarted() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized(context);
    }
  }

  private void notifyapplicationContextListenerOnServiceStopped() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed(context);
    }
  }

  public void service(int port){
    notifyApplicationContextListenerOnServiceStarted();

    try(ServerSocket serverSocket = new ServerSocket(port)){
      System.out.println("서버 실행 중...");
      while (true) {
        Socket clientSocket = serverSocket.accept();

        if (stop) {
          break;
        }
        new Thread(() -> handleClient(clientSocket)).start();

      } }catch (Exception e) {
        e.printStackTrace();
      }
    notifyApplicationContextListenerOnServiceStopped();
  }

  public static void main(String[] args) {
    ServerApp server = new ServerApp();

    server.addApplicationContextListener(new AppInitListener());
    server.addApplicationContextListener(new DataHandlerListener());
    server.addApplicationContextListener(new RequestMappingListener);

    sever.service(8888);
  }

  private static void handleClient(Socket clientSocket) {
    InetAddress address = clientSocket.getInetAddress();
    System.out.printf("클라이언트(%s)가 연결되었습니다.\n",
        address.getHostAddress());

    try(Socket socket = clientSocket;
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())));
  }
}

// # quit해도 서버 종료 안하게
// main에게 예외를 던지면 원래 있던 캐치가 캐치하고 서버를 종료하게되므로 예외처리를 해야한다
// 우리는 계속 클라이언트를 받고싶기때문에 이렇게 되면 곤란함
// 예외를 어디서 캐치할지 결정권이 있다
// 두가지 방법이있다
// 1 main에서 새 try catch 만들기
// 2 메서드에서 try catch 만들기
// 스레드라면 2 방법이 낫다

// java -Dfile.encoding=UTF-8 -cp bin/main ~

//