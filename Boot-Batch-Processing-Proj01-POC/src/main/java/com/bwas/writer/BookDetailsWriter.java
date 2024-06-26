package com.bwas.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class BookDetailsWriter implements ItemWriter<String> {
	public BookDetailsWriter() {
		System.out.println("BookDetailsWriter.BookDetailsWriter()");
	}

	@Override
	public void write(List<? extends String> items) throws Exception {
		// TODO Auto-generated method stub
		items.forEach(System.out::println);

	}

}
