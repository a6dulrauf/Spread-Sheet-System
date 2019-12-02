package com.spreadsheet;

import java.util.ArrayList;
import java.util.List;


public class WorkBook {
	
	private List<SpreadSheet> workBook;
	private int spreadSheetCount;
	private int sheetLimit;
	
	public WorkBook() {
		
		this.workBook = new ArrayList<SpreadSheet>();
		this.workBook.add(new SpreadSheet("Sheet1"));
		this.workBook.add(new SpreadSheet("Sheet2"));
		this.workBook.add(new SpreadSheet("Sheet3"));
		this.spreadSheetCount = 3;
		this.sheetLimit = 256;
	}
	
	public boolean add() {
		
		if(this.workBook.size() == sheetLimit)
			return false;
		
		this.spreadSheetCount++;
		String s = "Sheet"+this.spreadSheetCount;
		this.workBook.add(new SpreadSheet(s));
		
		return true;
	}
	
	
	public int remove(String sheetName) {

		if(this.workBook.size() == 1)
			return -1;
		
		for (SpreadSheet sheet : this.workBook) {
			if(sheet.getSpreadSheetName().equalsIgnoreCase(sheetName)) {
				int index = this.workBook.indexOf(sheet);
				this.workBook.remove(sheet);
				return index;
			}
		}
		return -1;
	}
	
	public String remove(int index) {
		
		if(this.workBook.size() == 1)
			return null;
		
		if(index < this.workBook.size() && index >= 0) {
	
				return this.workBook.remove(index).getSpreadSheetName();
		}		
		return null;
	}
	
	public int move(String from, String to, boolean before) {
		if(from.equalsIgnoreCase(to))return -1;
		
		int fromIndex = -1;
		int toIndex = -1;
		for(SpreadSheet sheet : this.workBook) {
			if(fromIndex != -1 && toIndex != -1)break;
			
			if(sheet.getSpreadSheetName().equalsIgnoreCase(from)) {
				fromIndex = this.workBook.indexOf(sheet);
			}
			else if(sheet.getSpreadSheetName().equalsIgnoreCase(to)) {
				toIndex = this.workBook.indexOf(sheet);
			}
		}
		
		SpreadSheet sp = this.moveSheetsInList(fromIndex, toIndex, before);
		return sp == null ? -1 :this.workBook.indexOf(sp);
	}
	
	public String move(int from, int to, boolean before) {
	
		SpreadSheet sp = this.moveSheetsInList(from, to, before);
		return sp == null ? null : sp.getSpreadSheetName();
	}
	
	private SpreadSheet moveSheetsInList(int from, int to, boolean before) {
		
		if(from < 0 || to < 0
				|| from >= this.workBook.size() || to >= this.workBook.size()
				|| from == to) return null;
		
		SpreadSheet fromSheet = this.workBook.get(from);
		if(before) {
			if(to == 0) {
				this.workBook.add(0,this.workBook.get(from));
				this.workBook.remove(from + 1);
				
			}else {
				this.workBook.add(to, fromSheet);
				if(from < to) {
					this.workBook.remove(from);
				}else {
					this.workBook.remove(from + 1);
				}
				
			}
			
		}else {
			this.workBook.add(to + 1, fromSheet);
			if(from < to ) {
				this.workBook.remove(from);
			}else {
				this.workBook.remove(from + 1);
			}
			
		}
		return fromSheet;
		
		
	}
	
	public String moveToEnd(int from) {
		
		if(from < this.workBook.size() && from >= 0) {
			SpreadSheet sheet = this.workBook.remove(from);
			this.workBook.add(sheet);
			return sheet.getSpreadSheetName();
		}	
		return null;
	}
	
	public int moveToEnd(String from) {
		
		for(SpreadSheet sheet : this.workBook) {
			if(sheet.getSpreadSheetName().equalsIgnoreCase(from)) {
				int index = this.workBook.indexOf(sheet);
				SpreadSheet removedSheet = this.workBook.remove(index);
				this.workBook.add(removedSheet);
				return index;
			}
		}
		return -1;
	}
	
	public int rename(String currentName, String newName) {
		
		if(!this.getAllSheetNames().contains(currentName)
				|| this.getAllSheetNames().contains(newName))
			return -1;
		
		for(SpreadSheet sheet : this.workBook) {
			if(sheet.getSpreadSheetName().equalsIgnoreCase(currentName)) {
				sheet.setSpreadSheetName(newName);
				return this.workBook.indexOf(sheet);
			}
		}
		
		return -1;
	}
	
	private List<String> getAllSheetNames(){
		List <String> sheetNames = new ArrayList<>(); 
		for(SpreadSheet sheet : this.workBook) {
			sheetNames.add(sheet.getSpreadSheetName());
		}
		return sheetNames;
	}
	
	public int index(String sheetName) {
		for(SpreadSheet sheet : this.workBook) {
			if(sheet.getSpreadSheetName().equalsIgnoreCase(sheetName)) {
				return this.workBook.indexOf(sheet);
			}
		}
		return -1;
	}
	
	public String sheetName(int index) {
		if(index < this.workBook.size() && index >=0) {
			return this.workBook.get(index).getSpreadSheetName();
		}
		return null;
	}
	
	public int length() {
		return this.workBook.size();
	}
	
	public void display() {
		String s = "[ ";
		for(int i = 0; i < this.workBook.size(); i++) {
			
			if(i == this.workBook.size() - 1) 
				s += this.workBook.get(i).getSpreadSheetName()+" ]";
			else
			s += this.workBook.get(i).getSpreadSheetName() + ", ";
			
		}
		System.out.println(s);
	}
	public List<SpreadSheet> getWorkBook() {
		return workBook;
	}
	
	@Override
	public String toString() {
		
		return this.workBook.toString();
		
	}
}
