package bookshop;

import java.util.LinkedHashMap;
import java.util.Map;

public class DB_book {
	private static Map<String, Book> map = new LinkedHashMap();
	static {
		map.put("1",new Book("1","javaweb开发","老1","一本好书"));
		map.put("2",new Book("2","javaweb2开发","老2","一本好书2"));
		map.put("3",new Book("3","javaweb3开发","老3","一本好书3"));
		map.put("4",new Book("4","javaweb4开发","老4","一本好书4"));
		map.put("5",new Book("5","javaweb5开发","老5","一本好书5"));
		map.put("6",new Book("6","javaweb6开发","老6","一本好书6"));
	}
	public static Map<String, Book> getAll(){
		
		return map;
		
	}
	

}
