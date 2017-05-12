package cn.com.hq.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.com.hq.entity.Account;
import cn.com.hq.service.UserService;
import cn.com.hq.serviceimpl.UserServiceimpl;
import cn.com.hq.serviceimpl.XssServiceImpl;
import cn.com.hq.util.JsonUtils;
import cn.com.hq.util.PropertiesUtils;

public class MessageAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceimpl();
	
	public static void main(String[] args) {
		System.out.println(XssServiceImpl.escapeHtmlForString("{\"name\":\"a&amp;#x5c;1\",\"age\":0}"));
	}
	public String execute() throws Exception {
		return "success";
	}
	public UserService getUserService() {
		return userService;
	}

	public String onMassage(){
		return "success";
	}


}
