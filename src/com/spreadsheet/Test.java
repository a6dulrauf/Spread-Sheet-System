package com.spreadsheet;

import java.util.ArrayList;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		WorkBook workBook= new WorkBook();
		//add method
		System.out.println("Add two new sheets");
		workBook.add();workBook.add();
		workBook.display();

		//Remove Methods
		System.out.println("Remove Sheet1 than remove 0 index sheet");
		workBook.remove("Sheet1");
		workBook.remove(0);
		workBook.display();
		
		//Move
		System.out.println("Move from = sheet5 , to = Sheet4 and before = true ");
		workBook.move("Sheet5", "Sheet4", true);
		workBook.display();
		System.out.println("Move from = 0 index , to = 1 index and before = false ");
		workBook.move(0, 1, false);
		workBook.display();
		
		//Move to End
		System.out.println("Move 0 index to end");
		workBook.moveToEnd(0);
		System.out.println("Move Sheet3 to end");
		workBook.moveToEnd("Sheet3");
		workBook.display();
		
		//Rename Mehtod
		System.out.println("Rename Sheet5 to Sheet0");
		workBook.rename("Sheet5", "Sheet0");
		
		//Index Method
		int index = workBook.index("Sheet4");
		workBook.display();
		System.out.println("Index of Sheet4 "+index);
		
		//SheetName
		System.out.println("Sheet Name at index 0 "+workBook.sheetName(0));
		
		//Length
		System.out.println("Length "+workBook.length());
	}

}
