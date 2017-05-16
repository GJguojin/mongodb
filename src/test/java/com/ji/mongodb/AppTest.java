package com.ji.mongodb;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ji.mongodb.model.Document;
import com.ji.mongodb.repository.DocumentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private DocumentRepository documentRepository;

	@Test
	public void test() throws Exception {
		Document d = new Document();
		String key = UUID.randomUUID().toString();
		d.setKey(key);

		InputStream in = new FileInputStream("E:\\12306Bypass_1.11.42_XiaZaiBa.zip");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024 * 1];
		int n = 0;
		while ((n = in.read(buffer)) != -1) {
			out.write(buffer, 0, n);
		}
		byte[] byteArray = out.toByteArray();
		d.setFile(byteArray);
		
		in.close();
		out.close();
		Long t1 = System.currentTimeMillis();
		documentRepository.insert(d);
		Long t2 = System.currentTimeMillis();
		logger.info("upload:"+(t2-t1));
		
		documentRepository.findOne(key);
		
		t1 = System.currentTimeMillis();
		logger.info("download:"+(t1-t2));
	}

}
