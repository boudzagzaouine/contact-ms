package com.ids;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("src/main/resources/init/test.txt");
		Scanner sc = new Scanner(f);
		double amount = 0;
		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] block = line.split("	");
			int qte = Integer.valueOf(block[0]);
			double pu = Double.valueOf(block[1]);
			amount += qte * pu;
		}
		System.out.println(amount);

	}

}
