package com.bwas.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class BookDetailsProcesser implements ItemProcessor<String,String>{

	public BookDetailsProcesser() {
		System.out.println("BookDetailsProcesser.BookDetailsProcesser()");
	}

	@Override
	public String process(String item) throws Exception {
		String bookTitle=null;
		if(item.equalsIgnoreCase("CRT"))
			bookTitle=item +" By Navenn";
		else if(item.equalsIgnoreCase("JAVA"))
			bookTitle = item+" By NataRaz";
		else if(item.equalsIgnoreCase("PYTHON"))
			bookTitle = item+" By Roger Feder";
		else if(item.equalsIgnoreCase("Js"))
			bookTitle = item+" By Finni";
		else if(item.equalsIgnoreCase("HTML"))
			bookTitle = item+" By Bharat";
		else if(item.equalsIgnoreCase("CSS"))
			bookTitle = item+" By SUdhkar";
		else if(item.equalsIgnoreCase("ANGULAR"))
			bookTitle = item+" By Sundar";
		else if(item.equalsIgnoreCase("REACT"))
			bookTitle = item+" By Satya";
		else 
			bookTitle=null;
		
		return bookTitle;
	}

}
