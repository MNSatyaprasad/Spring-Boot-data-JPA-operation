package com.bwas.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;
@Component
public class BookDetailsReader implements ItemReader<String> {

	String book[] = new String[] {"CRT","JAVA","PYTHON","JS","HTML","CSS","ANGULAR","REACT"};
	int count =0;
	
	
	public BookDetailsReader() {
		System.out.println("BookDetailsReader.BookDetailsReader()");
	}


	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("BookDetailsReader.read()");
		if(count<book.length) {
			return book[count++];
		}else {
			return null;
		}
		
	}

}
