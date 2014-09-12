package pl.javaart.mszarlinski;

import pl.javaart.mszarlinski.server.EchoServer;

/**
 * 
 * @author mszarlinski
 *
 */
public class Main {
	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			throw new IllegalArgumentException("Port must be specified");
		}
		System.out.println("[HINT] You can overwrite default port using -Dport=9090 argument.");
		int port = Integer.parseInt(args[0]);
		new EchoServer(port).run();
	}
}
