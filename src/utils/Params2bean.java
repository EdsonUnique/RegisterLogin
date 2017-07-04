package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.sun.org.apache.commons.beanutils.ConvertUtils;
import com.sun.org.apache.commons.beanutils.Converter;
/**
 * 将请求参数的值赋给Javabean
 * @author Edson121
 *
 */
public class Params2bean {

	public static void copy(Object bean,Map params){
		try {
			ConvertUtils.register(new Converter(){//给BeanUtils注册转换器

				public Object convert(Class type, Object date) {
					String value=(String)date;
					if(value==null || value.trim().equals("")){
						return null;
					}else{
						SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
						try {
							return format.parse(value);
						} catch (ParseException e) {
							throw new RuntimeException(e);
						}
					}
					
				}
				
			}, Date.class);
			BeanUtils.populate(bean, params);
		} catch (Exception e) {
			throw  new RuntimeException(e);
		}
	}
}
