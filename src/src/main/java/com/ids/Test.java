package com.ids;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) throws Exception {

		File f = new File("src/main/resources/icon.txt");
		Scanner sc = new Scanner(f);
		List<String> icons = new ArrayList<>();
		while (sc.hasNext()) {
			String s1 = sc.nextLine();

			icons.add(s1);
			//	System.out.println(s1);
		}
		Set<String> sIcon = new TreeSet<>(icons);
		for (String icon : sIcon) {
			System.out.println("<li  className='float-left m-5'>" + "<" + icon
					+ " className='mr-3 h-8 w-8 text-cyan-700 group-hover:text-gray-500' aria-hidden='true' /> "
					+ "<input type='text' value='<" + icon
					+ " className=\"mr-3 h-8 w-8 text-cyan-700 group-hover:text-gray-500\" aria-hidden=\"true\" />'/></li>");
		}
	}

}
