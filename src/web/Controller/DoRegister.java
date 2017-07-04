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
 * �����û��ύ�����ı�����
 * @author Edson121
 *
 */
public class DoRegister extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//�������
		
		//����������Ƿ�Ϸ�
		Map params=request.getParameterMap();//��ȡ����map
		RegisterBean registerBean=new RegisterBean();
		User user=new User();
		Params2bean.copy(registerBean, params);
		
		boolean valid=registerBean.checkForm();
		
		//ע��ɹ����û���Ϣ�������ݿ⣬������ת������ҳ��
		if(valid){
			BusinessSovle service=new BusinessSovleImp();
			try {
				Params2bean.copy(user, params);
				user.setId(generateId());//����id
				service.register(user);
				request.getRequestDispatcher("/WEB-INF/jsp/yesRegister.jsp").forward(request, response);
			} catch (UserExistsException e) {//�û��Ѵ��ڴ���
				registerBean.getError().put("uname", "�û����Ѵ���");
				request.setAttribute("form", registerBean.getError());
				request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);//�û��Ѵ����쳣
			}catch(Exception e){//����δ֪����
				e.printStackTrace();
				request.setAttribute("message", "����������δ֪����");
				request.getRequestDispatcher("/WEB-INF/errorPage/messageError.jsp").forward(request, response);
			}
		}else{//ע��ʧ�ܣ���ת��ע��ҳ�棬��ʾע��ʧ�ܵ�ԭ��:����֤ʧ��
			request.setAttribute("form", registerBean.getError());
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp")
			.forward(request, response);
		}
		
		
		
	}

	/**
	 * ���û�����ΨһID
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
