package jp.co.drm.util;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

public class DrmUtils {

	public static byte[] BufferedImage2Bytes(BufferedImage image,
            String imageFormat) throws IOException{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(image, imageFormat, bos);
		return bos.toByteArray();

	}
	public static  List<File> getFilesOfDir(File dir){

		List<File> lstFile = new ArrayList<File>();

		File[] files = dir.listFiles();

		for(File file : files) {

			if(!file.exists() || file.isHidden()){
				continue;
			}

			if(file.isDirectory()){
				List<File> subFiles = getFilesOfDir(file);
				lstFile.addAll(subFiles);
			}else if(file.isFile()){
				lstFile.add(file);
			}
		}

		return lstFile;

	}

	public static  List<File> getFilesOfDir(String homeDir){
		return getFilesOfDir(new File(homeDir));


	}

	public static  List<String> getFileNamesOfDir(String homeDir){
		List<File> lstFile = getFilesOfDir(homeDir);
		List<String> ret = lstFile.stream()
				.map(p -> p.getPath()).collect(Collectors.toList());
		return ret;

	}


}