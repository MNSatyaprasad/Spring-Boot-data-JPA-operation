package com.bwas.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.bwas.model.ExamResult;

@Component
public class ExamResultProcessor implements ItemProcessor<ExamResult, ExamResult> {
	@Override
	public ExamResult process(ExamResult item) throws Exception {
		if(item.getPercentage()>=95) {
			return item;
		}
		return null;
	}
}
