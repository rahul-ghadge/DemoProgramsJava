package com.demo.program.runtime;

import java.io.*;

public class RuntimeExe {

	public static String getIfConfig() throws IOException {

		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec("ifconfig");

		int character;

		StringBuilder builder = new StringBuilder();

		while ((character = process.getInputStream().read()) != -1) {
			builder.append((char) character);
		}

		System.out.println(builder);

		return builder.toString();

	}

	public static void checkUNIXCommand(String command) throws IOException, InterruptedException {

		Process process = Runtime.getRuntime().exec(command);

		StringBuilder builder = new StringBuilder();
		BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));

		String line;

		while ((line = input.readLine()) != null) {
			builder.append(line);
		}
		System.out.println(builder);

		int exitVal = process.waitFor();
		System.out.println("Exited with error code " + exitVal);

	}

	public static void main(String[] args) {

		try {

			// getIfConfig();
			// checkUNIXCommand("ls -lrt");
			// checkUNIXCommand("pwd");

			checkUNIXCommand("tail -f /home/rahulg/nodesource_setup.sh");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
