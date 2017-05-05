package lovo.j135_2.netctoss.converter;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lovo.j135_2.netctoss.util.PropertiesUtil;

public class UtilDateConverter extends PropertyEditorSupport {

	/**
	 * text即为来至于页面的数据
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Date date = null;
		SimpleDateFormat format = null;
		try {
			PropertiesUtil util = new PropertiesUtil();
			Properties prop = util.getProperties();
			Set<Object> keys = prop.keySet();//获取键的集合
			if(text != null && !"".equals(text)){
				for (Object object : keys) {
					String key = (String) object;
					Pattern p = Pattern.compile(key);
					Matcher m = p.matcher(text);
					if(m.matches()){
						format = new SimpleDateFormat(prop.getProperty(key));
						date = format.parse(text);
						break;
					}
				}
			}else{
				this.setValue(null);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		this.setValue(date);
	}
}
