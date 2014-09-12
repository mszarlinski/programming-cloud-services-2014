package pl.javaart.mszarlinski;

import pl.javaart.mszarlinski.server.EchoServer;

/**
 * 
 * @author Maciej
 *
 */
public class Main {
	public static void main(String[] args) throws Exception {
		int port;
		if (args.length > 0) {
			port = Integer.parseInt(args[0]);
		} else {
			System.out.println("Using default port 8080");
			port = 8080;
		}
		new EchoServer(port).run();
	}

}
