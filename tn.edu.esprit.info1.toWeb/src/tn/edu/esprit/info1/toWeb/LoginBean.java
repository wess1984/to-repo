package tn.edu.esprit.info1.toWeb;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
	private String login = "";
	private String pwd ="";
	private boolean loggedIn = false;
	private Boolean error=false;
	
	public LoginBean() {
		
	}
	
	public String doLogin() {
		String log = "";
		if (login.equalsIgnoreCase("admin") & (pwd.equalsIgnoreCase("admin"))) {
			log = "ok";
			loggedIn=true;
			return "/index.xhtml?faces-redirect=true";
		} else {
			log = "ko";
			error =true;
		}
		System.out.println(log);
		return log;
	}

	public String getLogin() {
		System.out.println("***************"+login);
		error= false;
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
	
	 public String logout(){
	      FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	      return "/index.xhtml?faces-redirect=true";
	   }

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

}
