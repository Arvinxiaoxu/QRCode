package cn.xu.qrcode;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 使用zsing创建二维码
 * @author Administrator
 *
 */
public class CradeQrCode {
	
	public static void main(String[] args) {
		int width = 300;
		int height = 300;
		String format = "png";
		String contents = "http://www.baidu.com";
		
		//定义二维码的参数 hints:暗示，线索
		HashMap hints = new HashMap();
		//设置编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		//设置错的纠错能力 一般都设置为M 纠错能力越强 存储的信息就越少
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		//设置边距
		hints.put(EncodeHintType.MARGIN, 2);
		
		try {
			//matrix:矩阵
			 BitMatrix   bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height,hints);
			 Path file = new File("E:/img.png").toPath();
			 MatrixToImageWriter.writeToPath(bitMatrix, format, file);
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	

}
