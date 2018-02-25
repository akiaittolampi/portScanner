package app.portscanner.com;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.println("Port where to start scan");
		int startPort = scanner.nextInt();
		System.out.println("Port where to end scan");
		int endPort = scanner.nextInt();

		String url = scanner.nextLine();
		ArrayList openPorts = new ArrayList();

		for (int i = startPort; i <= endPort; i++) {

			try {
				Socket sock = new Socket();
				sock.connect(new InetSocketAddress(url, i), 200);
				sock.close();
				openPorts.add(i);
			} catch (Exception e) {
				System.out.println("Port is not open " + i);
			}

		}
		System.out.println("Ports with state OPEN. ");
		for (Object o : openPorts) {
			System.out.println(o);
		}
	}
}
