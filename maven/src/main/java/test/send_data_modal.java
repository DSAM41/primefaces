package test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@ViewScoped
public class send_data_modal {
	HttpSession hs = Util.getSession();
	private User_test user;
	
	@PostConstruct
	public void init() {
		user = new User_test();
	}
	
	public void save() {
		try{
			System.out.println(user.getId());
			List<User_test> list = new ArrayList<User_test>();
			List<User_test> numbers = (List<User_test>) hs.getAttribute("list");
			for (User_test anews : numbers) {
				if (anews.getId() == user.getId()) {
					anews.setFirstName(user.getFirstName());
					anews.setLastName(user.getLastName());
					anews.setEmail(user.getEmail());
				}
				list.add(anews);
			}
			//FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Sucesso", "Sucesso"));
		}catch (Exception e) {
			System.out.println("Erro");
			//FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro"));
		}
	}

	public User_test getUser() {
		return user;
	}

	public void setUser(User_test user) {
		this.user = user;
	}
}
