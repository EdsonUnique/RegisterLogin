package web.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BusinessSovle;
import service.impl.BusinessSovleImp;
import utils.Encoder;
import utils.Params2bean;

import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.sun.org.apache.commons.beanutils.ConvertUtils;
import com.sun.org.apache.commons.beanutils.Converter;
import com.sun.org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import domain.User;
import exception.UserExistsException;

import formBean.RegisterBean;
/**
 * 处理用户提交过来的表单数据
 * @author Edson121
 *
 */
public class DoRegister extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//解决乱码
		
		//检验表单数据是否合法
		Map params=request.getParameterMap();//获取参数map
		RegisterBean registerBean=new RegisterBean();
		User user=new User();
		Params2bean.copy(registerBean, params);
		
		boolean valid=registerBean.checkForm();
		
		//注册成功则将用户信息加入数据库，否则跳转到错误页面
		if(valid){
			BusinessSovle service=new BusinessSovleImp();
			try {
				Params2bean.copy(user, params);
				user.setId(generateId());//产生id
				service.register(user);
				request.getRequestDispatcher("/WEB-INF/jsp/yesRegister.jsp").forward(request, response);
			} catch (UserExistsException e) {//用户已存在错误
				registerBean.getError().put("uname", "用户名已存在");
				request.setAttribute("form", registerBean.getError());
				request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);//用户已存在异常
			}catch(Exception e){//其它未知错误
				e.printStackTrace();
				request.setAttribute("message", "服务器出现未知错误");
				request.getRequestDispatcher("/WEB-INF/errorPage/messageError.jsp").forward(request, response);
			}
		}else{//注册失败，跳转到注册页面，显示注册失败的原因:表单验证失败
			request.setAttribute("form", registerBean.getError());
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp")
			.forward(request, response);
		}
		
		
		
	}

	/**
	 * 给用户设置唯一ID
	 * @return ID
	 */
	private String generateId() {
		
		return UUID.randomUUID().toString();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
