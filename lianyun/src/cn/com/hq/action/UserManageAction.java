package cn.com.hq.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.com.hq.entity.Account;
import cn.com.hq.service.UserService;
import cn.com.hq.serviceimpl.UserServiceimpl;
import cn.com.hq.util.JsonUtils;
import cn.com.hq.util.StringUtil;

import com.opensymphony.xwork2.ActionSupport;

public class UserManageAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceimpl();
	HttpServletRequest reguest= super.getRequest();
	public String execute() throws Exception {
		return "success";
	}

	public UserService getUserService() {
		return userService;
	}
	public void isPhoneChange(){
		String accountStr = reguest.getParameter("account");
		if(!StringUtil.isEmpty(accountStr)){
			Account a = JsonUtils.fromJson(accountStr, Account.class);
			//如果用户不存在，则添加新用户
			List<Account> accountList = userService.queryAccountById(a.getAccountid());
			if(accountList.size() > 0){
				Account account = accountList.get(0);
				if(account.getPhone()!=null && !account.getPhone().equals(a.getPhone())){
					account.setPhone(a.getPhone());
					userService.updateAccount(account);
				}
			}
		}
	}
	
	public void getAccountInfo(){
		String accountId = reguest.getParameter("accountId");
		if(!StringUtil.isEmpty(accountId)){
			//如果用户不存在，则添加新用户
			List<Account> accountList = userService.queryAccountById(accountId);
			if(accountList.size() > 0){
				Account account = accountList.get(0);
				responseWriter("{\"success\":true,\"account\":"+JsonUtils.toJson(account)+"}");
			}else{
				responseWriter("{\"success\":false,\"message\":\"result is null\"}");
			}
		}
	}

}
