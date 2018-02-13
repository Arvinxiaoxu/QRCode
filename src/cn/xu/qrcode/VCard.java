package cn.xu.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;

import org.junit.Test;
/**
 * vcard 的版本：https://en.wikipedia.org/wiki/VCard
 * example:
 * VCard vcard = new VCard("姓名", "组织", "角色", 
				"家庭电话", "家庭年住址", 
				"邮箱", "二维码生成路径后缀名.png");
		vcard.createVCardQrCodeImg();
 * @author Administrator
 *
 */

public class VCard {
	public static String LF = "\n"; 
	public static String BEGIN="BEGIN:VCARD";
	public static String VERSION = "VERSION:4.0";
	public static String N="N:";
	public static String FN="FN:";//姓名
	public static String ORG="ORG:";//组织
	public static String TITLE="TITLE:";//职位
	public static String PHOTO_MEDIATYPE="PHOTO;MEDIATYPE=image/gif:";
	public static String TEL_TYPE_Work="TEL;TYPE=work,voice;VALUE=uri:";//工作电话
	public static String TEL_TYPE_Home="TEL;TYPE=home,voice;VALUE=uri:";//家庭电话
	public static String ADR_TYPE_WORK_PREF="ADR;TYPE=WORK,PREF:";//工作住址
	public static String LABEL_TYPE_WORK_PREF="LABEL;TYPE=WORK,PREF:";//工作标签和家庭标签没事区别
	
	public static String ADR_TYPE_HOME="ADR;TYPE=HOME:";//家庭住址
	public static String LABEL_TYPE_HOME="LABEL;TYPE=HOME:";//家庭标签
	public static String x_QQ="x-qq:";//不起作用
	public static String EMAIL="EMAIL:";//电子邮箱
	public static String REV="REV:";//不起作用
	public static String END="END:VCARD";
	
	public static Integer _VERSION =18;
	public static char ERROR_CORRECT ='M' ;
	public static char ENCODE_MODE = 'B';
	public static String CHARSET = "utf-8";
	
	private String name ="暂无";
	private String org ="暂无";//公司名称
	private String role ="暂无";
	private String workTel ="暂无";
	private String homeTel ="暂无";
	private String addrWork ="暂无";
	private String addrHome ="暂无";
	private String email ="暂无";
	private String qrPath = "C:/vcard.png";
	
	
	
	


	public VCard(String name, String org, String role, String homeTel, String addrHome, String email, String qrPath) {
		super();
		this.name = name;
		this.org = org;
		this.role = role;
		this.homeTel = homeTel;
		this.addrHome = addrHome;
		this.email = email;
		this.qrPath = qrPath;
	}


	public VCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getOrg() {
		return org;
	}


	public void setOrg(String org) {
		this.org = org;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getWorkTel() {
		return workTel;
	}


	public void setWorkTel(String workTel) {
		this.workTel = workTel;
	}


	public String getHomeTel() {
		return homeTel;
	}


	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}


	public String getAddrWork() {
		return addrWork;
	}


	public void setAddrWork(String addrWork) {
		this.addrWork = addrWork;
	}


	public String getAddrHome() {
		return addrHome;
	}


	public void setAddrHome(String addrHome) {
		this.addrHome = addrHome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getQrPath() {
		return qrPath;
	}


	public void setQrPath(String qrPath) {
		this.qrPath = qrPath;
	}

	public void createVCardQrCodeImg() {
		StringBuffer qrData  = new StringBuffer();
		qrData.append(autoAddLF(BEGIN));
		qrData.append(autoAddLF(VERSION));
		qrData.append(autoAddContentLF(FN,name));
		qrData.append(autoAddContentLF(ORG,org));
		//PHOTO;MEDIATYPE=image/gif:http://www.example.com/dir_photos/my_photo.gif
		qrData.append(autoAddContentLF(PHOTO_MEDIATYPE,"http://img.zcool.cn/community/0175f85803a1eca84a0e282b635968.gif"));
		qrData.append(autoAddContentLF(TITLE,role));
		qrData.append(autoAddContentLF(TEL_TYPE_Work,workTel));
		qrData.append(autoAddContentLF(TEL_TYPE_Home,homeTel));
		qrData.append(autoAddContentLF(ADR_TYPE_WORK_PREF,addrWork));
		qrData.append(autoAddContentLF(ADR_TYPE_HOME,addrHome));
		qrData.append(autoAddContentLF(EMAIL,email));
		qrData.append(autoAddLF(END));
		
		CreateQRCode cqr = new CreateQRCode(ERROR_CORRECT, ENCODE_MODE, _VERSION, 2, CHARSET);
		cqr.setQrData(qrData.toString());
		BufferedImage bImgQr = cqr.getBufferedImageQRCode();
		cqr.write(bImgQr, "png", new File(qrPath));
	}
	
	
	public String autoAddLF(String arg1) {
		
		return new String(arg1+LF);
	}
	public String autoAddContentLF(String arg1,String content) {
		
		return new String(arg1+content+LF);
	}

}
