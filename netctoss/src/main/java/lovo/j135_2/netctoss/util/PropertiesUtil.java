package lovo.j135_2.netctoss.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	
	
	/**
	 * 配置文件读取方法
	 * @return
	 */
	public Properties getProperties(){
		Properties props = null;
		InputStream in = null;
		
		try {
			String path = this.getClass().getResource("/converters.properties").getPath();
			//空格在JAVA文件路径获取中，会变成%20
			if(path.contains("%20")){
				path = path.replace("%20", " ");
			}
			File file = new File(path);
			in = new BufferedInputStream(new FileInputStream(file));
			props = new Properties();
			props.load(in);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return props;
	}
	
	
	public static void main(String[] args) {
		PropertiesUtil util = new PropertiesUtil();
		Properties pros = util.getProperties();
		System.out.println(pros.get("2[0-9]{3}-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[0-1])"));
	}
	
	
}
