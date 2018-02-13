package cn.xu.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;

import org.junit.Test;

/**
 * example:
 * VCard vcard = new VCard("姓名", "组织", "角色", 
				"家庭电话", "家庭年住址", 
				"邮箱", "二维码生成路径后缀名.png");
		vcard.createVCardQrCodeImg();
 * 
 */
public class Demo {
	
	@Test
	public void test1() {
		VCard vcard = new VCard("xxx", "xx", "xxxx", 
				"xxx", "河南省 xxxx ", "2753573524@qq.com", "xxxx.png");
		vcard.createVCardQrCodeImg();
	}
	
	public void test2()throws Exception {
		CreateQRCode cqr = new CreateQRCode('M', 'B', 7, 2, "utf-8");
		cqr.setQrData("");
		 BufferedImage bImgQr = cqr.getBufferedImageQRCode();
		 cqr.write(bImgQr, "png", new File("E:/demo.png"));
	}

}
