package com.spreadsheet;

public class Test {

	public static void main(String[] args) {
		WorkBook workBook= new WorkBook();
		System.out.println(workBook.add(new SpreadSheet("Sheet_1")));
		
		//System.out.println(workBook.remove("Sheet_2"));
		
		System.out.println(workBook.move("Sheet_1", "Sheet_3", true));
		System.out.println();
		System.out.println(workBook);
	}

}
