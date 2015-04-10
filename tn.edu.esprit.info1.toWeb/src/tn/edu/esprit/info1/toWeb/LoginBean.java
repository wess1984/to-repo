package tn.edu.esprit.info1.toWeb;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
	private String login = "";
	private String pwd ="";
	private boolean loggedIn = false;

	public String doLogin() {
		String log = "";
		if (login.equalsIgnoreCase("a") & (pwd.equalsIgnoreCase("a"))) {
			log = "ok";
			loggedIn=true;

		} else {
			log = "ko";
		}
		System.out.println(log);
		return log;
	}

	public String getLogin() {
		System.out.println("***************"+login);
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
