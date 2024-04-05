package com.bwas.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bwas.entity.MarriageSeeker;
import com.bwas.service.IMarriageSeekerServiceMgmt;
@Component
public class LargeObjectRunner implements CommandLineRunner {

	@Autowired
	private IMarriageSeekerServiceMgmt service;
	@Override
	public void run(String... args) throws Exception {
	
		
		/*
		 * Scanner sc = new Scanner(System.in);
		 * System.out.println("Enter the Person naame"); String name = sc.next();
		 * System.out.println("Enter the Person Address"); String addres = sc.next();
		 * System.out.println("Enter the person photo File Complate file Adderess::");
		 * String photoPath = sc.next();
		 * System.out.println("Enter the person biodata file complare path ::"); String
		 * bioDataPath = sc.next().replace("?", "");
		 * System.out.println("Enter the Person Indian ?"); Boolean indian =
		 * sc.nextBoolean();
		 * 
		 * //prepare byte[] repesenting photo file content InputStream is = new
		 * FileInputStream(photoPath); byte[] photoData= new byte[is.available()];
		 * photoData = is.readAllBytes(); is.close(); //prepare char[] repesenting
		 * biodata content File file = new File(bioDataPath); Reader reader = new
		 * FileReader(file); char[] biodataContent = new char[(int)file.length()];
		 * reader.read(biodataContent); reader.close(); sc.close();
		 * 
		 * MarriageSeeker marriageSeeker = new MarriageSeeker(name, addres, photoData,
		 * LocalDateTime.of(1995,12,31,12,45), biodataContent, indian);
		 * service.registerMarriageSeeker(marriageSeeker);
		 */
		
		Optional<MarriageSeeker> opt = service.searchSeekerById(152);
		if(opt.isEmpty()) {
			
			MarriageSeeker seeker = opt.get();
			System.out.println(seeker.getId()+"   "+seeker.getName()+"   "+seeker.getIndian());
			OutputStream os = new FileOutputStream("photo_asd.gfif");
			os.write(seeker.getPhoto());
			os.flush();
			Writer writer = new FileWriter("biodata.txt");
			writer.write(seeker.getBoidata());
			writer.flush();
			System.out.println("LOBS are retrived ");
		}
		else {
			System.out.println("No id found");
		}
		
		

	}

}
