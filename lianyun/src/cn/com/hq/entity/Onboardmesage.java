package cn.com.hq.entity;

public class Onboardmesage {

	public Onboardmesage() {
	}

	private String id;
	private String accountname;
	private String accountphone;
	private String appointtime;
	private String onboardtime;
	private String onboardaddress;
	private String appointstatus;
	private String onboardstatus;

	public Onboardmesage(String id,String accountname,String accountphone, String accountid, String onboardtime,
			String appointtime, String onboardaddress, String appointstatus,
			String onboardstatus) {
		super();
		this.id = id;
		this.accountname = accountname;
		this.accountphone = accountphone;
		this.onboardtime = onboardtime;
		this.appointtime = appointtime;
		this.onboardaddress = onboardaddress;
		this.appointstatus = appointstatus;
		this.onboardstatus = onboardstatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public String getAccountphone() {
		return accountphone;
	}

	public void setAccountphone(String accountphone) {
		this.accountphone = accountphone;
	}

	public String getOnboardtime() {
		return onboardtime;
	}

	public void setOnboardtime(String onboardtime) {
		this.onboardtime = onboardtime;
	}

	public String getOnboardaddress() {
		return onboardaddress;
	}

	public void setOnboardaddress(String onboardaddress) {
		this.onboardaddress = onboardaddress;
	}

	public String getAppointtime() {
		return appointtime;
	}

	public void setAppointtime(String appointtime) {
		this.appointtime = appointtime;
	}

	public String getAppointstatus() {
		return appointstatus;
	}

	public void setAppointstatus(String appointstatus) {
		this.appointstatus = appointstatus;
	}

	public String getOnboardstatus() {
		return onboardstatus;
	}

	public void setOnboardstatus(String onboardstatus) {
		this.onboardstatus = onboardstatus;
	}

	@Override
	public String toString() {
		return "id=" + id + "accountname=" + accountname + "accountphone=" + accountphone + "onboardtime="
				+ onboardtime.toString() + "onboardaddress=" + onboardaddress;
	}

}
