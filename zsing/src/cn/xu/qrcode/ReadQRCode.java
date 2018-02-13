package cn.xu.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class ReadQRCode {

	public static void main(String[] args) {
		try {
			MultiFormatReader formatReader = new MultiFormatReader();
			File file = new File("E:/img.png");
			BufferedImage image = ImageIO.read(file);

			BufferedImageLuminanceSource bImageS = new BufferedImageLuminanceSource(image);
			HybridBinarizer hybridBinarizer = new HybridBinarizer(bImageS);
			BinaryBitmap binaryBitmap = new BinaryBitmap(hybridBinarizer);

			// 定义二维码的参数 hints:暗示，线索
			HashMap hints = new HashMap();
			// 设置编码
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			Result result = formatReader.decode(binaryBitmap, hints);
			
			System.out.println("解析结果："+result.toString());
			System.out.println("二维码格式类型："+result.getBarcodeFormat());
			System.out.println("二维码中的内容："+result.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
