package com.demo.program.img.compress;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;

import javax.activation.MimetypesFileTypeMap;
import javax.imageio.ImageIO;

public class ReadImages {

	// array of supported extensions (use a List if you prefer)
	static final String[] EXTENSIONS = new String[] { "gif", "png", "bmp", "jpg", "jpeg", "GIF", "PNG", "BMP", "JPG", "JPEG" };

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("----------------------------------------------------------------");
		System.out.println("Sample file paths (Without space in folder names)");
		System.out.println("WINDOWS : C:\\\\Documents\\\\rahulg\\\\Pictures");
		System.out.println("LINUX   : /home/rahulg/Pictures");
		System.out.println("----------------------------------------------------------------");

		System.out.print("Paste file path here as per above pattern : ");

		String directoryPath = sc.next();

		if (null != directoryPath && directoryPath.trim().length() > 0) {

			File dir = new File(directoryPath.trim());

			if (dir.isDirectory()) { // make sure it's a directory
				for (final File file : dir.listFiles(IMAGE_FILTER)) {

					if (file.isFile()) {

						String mimetype = new MimetypesFileTypeMap().getContentType(file);
						String type = mimetype.split("/")[0];
						if (type.equals("image")) {

							// System.out.println("It's an image");
							// else
							// System.out.println("It's NOT an image");
							//

							BufferedImage img = null;
							String extension = "";

							try {
								img = ImageIO.read(file);

								System.out.println(" Image: " + file.getName());
								System.out.println(" Width : " + img.getWidth());
								System.out.println(" Height: " + img.getHeight());
								System.out.println(" Size  : " + file.length());

								int i = file.getName().lastIndexOf('.');
								if (i > 0) {
									extension = file.getName().substring(i + 1);
								}
								System.out.println(" Extension  : " + extension);

								ImageUtils.resizeImage(img, directoryPath, extension, file);

								System.out.println("----------------------------------------------------------------");

							} catch (final IOException e) {
								System.out.println("Error occurred for image : " + file.getName());
								e.printStackTrace();
							}
						} else {
							System.out.println("Not image : " + file.getName());
						}
					}
				}
			} else {
				System.out.println("Given is not valid directory path. Please try again");
			}

		} else {
			System.out.println("Please enter directory path");
		}

	}

	// filter to identify images based on their extensions
	static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

		@Override
		public boolean accept(final File dir, final String name) {
			for (final String ext : EXTENSIONS) {
				if (name.endsWith("." + ext)) {
					return (true);
				}
			}
			return (false);
		}
	};

}