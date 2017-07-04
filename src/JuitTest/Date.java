package JuitTest;


import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;


public class Date {
	@Test
	public void testDate(){
		DateLocaleConverter converter=new DateLocaleConverter();
		String str="19we";
		converter.convert(str,"yyyy-MM-dd");
	}
}
