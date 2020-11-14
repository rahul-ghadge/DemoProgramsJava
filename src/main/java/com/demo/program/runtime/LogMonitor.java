package com.demo.program.runtime;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Steve Jin (http://www.doublecloud.org)
 */
public class LogMonitor {
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws Exception {

		FileReader fr = null;
		BufferedReader br = null;

		fr = new FileReader("c:/temp/logSample/test.log");
		br = new BufferedReader(fr);

		while (true) {
			String line = br.readLine();
			if (line == null) {
				Thread.sleep(1 * 1000);
			} else {
				System.out.println(line);
			}

			if (1 == 0)
				break;
		}

	}
}