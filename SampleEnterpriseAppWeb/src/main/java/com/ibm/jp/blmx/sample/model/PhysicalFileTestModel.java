package com.ibm.jp.blmx.sample.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PhysicalFileTestModel {
	private static final String _DATE_TIME_FORMAT = "YYYY/MM/dd (E) HH:mm:ss.SSS zZ";
	private SimpleDateFormat sdf;

	public PhysicalFileTestModel() {
		sdf = new SimpleDateFormat(_DATE_TIME_FORMAT);
	}

	public void writeFile(String path) throws IOException {
		Writer writer = getWriter(path);
		String dateTime = sdf.format(new Date());
		writer.write(dateTime);
		writer.flush();
		writer.close();
	}

	private Writer getWriter(String path) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new FileOutputStream(path));
		return pw;
	}
}
