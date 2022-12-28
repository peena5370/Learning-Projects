package com.file.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.file.demo.model.FileSourceResponse;
import com.file.demo.model.RegexResponse;
import com.file.demo.utils.DateUtils;
import com.file.demo.utils.FileUtils;

public class MainApplication {
	static FileUtils fileUtils = new FileUtils();
	static DateUtils dateUtils = new DateUtils();

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new MainApplication().new RunnableImpl());

		thread.start();
		Thread.sleep(10000);
	}

	private class RunnableImpl implements Runnable {
		@Override
		public void run() {
			try {
        			// Loads file source and destination properties
				FileSourceResponse sourceResp = fileUtils.getFileDirectory("./config.properties");

				Path sourcePath = Paths.get(sourceResp.getSourceDir());
				Path destPath = Paths.get(sourceResp.getDestDir());

        			// Create directories if file paths not exists
				Files.createDirectories(sourcePath);
				Files.createDirectories(destPath);

				SAXReader reader = new SAXReader();

        			// Scan through all xml files inside the source path
				Files.walk(sourcePath).forEach(p -> {
					try {
						Document document = reader.read(new File(p.toAbsolutePath().toString()));
						Element xmlElem = document.getRootElement();
						Attribute attr = xmlElem.attribute("dateTime");

						RegexResponse resp = dateUtils.dateMatcher(attr.getValue(), "\\d+\\-\\d+\\-\\d+");
						if(resp.isBool()) {
							String[] dateArr = resp.getMatcherString().split("\\-");
							Path newPath = Paths.get(destPath.toString(), dateArr[0], dateArr[1], dateArr[2]);
							Files.createDirectories(newPath);

              						// Moves file to destination path
							Files.move(p.toAbsolutePath(), newPath.resolve(p.getFileName()));
						} else {
							System.out.println("not bool");
						}
					} catch (DocumentException | IOException e) {
						e.printStackTrace();
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
