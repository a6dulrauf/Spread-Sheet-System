package com.spreadsheet;

import java.util.ArrayList;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		WorkBook workBook= new WorkBook();
		//System.out.println(workBook.add(new SpreadSheet("Sheet_1")));
		
		//System.out.println(workBook.remove("Sheet_4"));
		//System.out.println(workBook.remove(2));
		
		//System.out.println(workBook.move("Sheet_1", "Sheet_3", true));
		//System.out.println(workBook.moveToEnd("Sheet_1"));
		//System.out.println(workBook.rename("Sheet_2","MySheet"));
		//System.out.println(workBook.index("Sheet_4"));
		//System.out.println(workBook.sheetName(-1));
		//System.out.println();
		//System.out.println(workBook);
		
		//SpreadSheet sp1 = new SpreadSheet("Sheet_4");
		boolean a = workBook.add();
		workBook.add();
		workBook.display();
		System.out.println(workBook +" "+a);
		//for(int i=0;i<256;i++) {
			//boolean out = workBook.add();
			//System.out.println(out);
		//}
		System.out.println(workBook);
		//System.out.println(workBook.moveToEnd("Sheet1"));
		//System.out.println(workBook.rename("Sheet2","Sheet6"));
		//System.out.println(workBook.remove("Sheet1"));
		//System.out.println(workBook.sheetName(0));
		//System.out.println(workBook.index("Sheet1"));
		//System.out.println(workBook.move("Sheet3", "Sheet1", false));
		//System.out.println(workBook.move(2, 4, true));
		int []A = {0,1,2,3,4,5};
		for (int i : A) {
			System.out.println(workBook.remove(0));
		}
		//System.out.println(workBook.remove(0));//+workBook.remove(1));
		System.out.println(workBook);
		
		System.out.println(workBook.length());
		System.out.println(workBook);
		/*
		List test = new ArrayList<>();
		test.add("1"+1);
		int i = test.indexOf("11");
		System.out.println("Test "+i);
		*/
		System.out.println(workBook.index("Sheet"+5));
		
	}

}
