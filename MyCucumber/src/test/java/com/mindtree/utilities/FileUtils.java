package com.mindtree.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is used to copy a file from its source to its destination
 * 
 * @author M1046633
 *
 */

public class FileUtils {

	// Time stamp to append for file generation
	static String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date());

	public static void copyFile(File src, File dest) throws IOException {

		InputStream input = null;
		OutputStream output = null;

		try {

			input = new FileInputStream(src);
			output = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = input.read(buffer)) > 0) {

				output.write(buffer, 0, length);

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} finally {

			input.close();
			output.close();

		}

	}

}
