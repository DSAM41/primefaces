package test;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
//import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@ManagedBean
@ViewScoped
public class User implements Serializable {
	HttpSession hs = Util.getSession();

	private List<User_test> uses;

//	@Inject
//    private UserService service;

	@PostConstruct
	public void init() {
		if (hs.getAttribute("list") == null) {
			System.out.println("list==null");
			uses = UserService.getUsers();
			hs.setAttribute("list", uses);
		} else {
			System.out.println("list!=null");
		}
	}

	public List<User_test> getUsers() {
		System.out.println("list");
		uses = (List<User_test>) hs.getAttribute("list");
		return uses;
	}

//	public void setService(UserService service) {
//        this.service = service;
//    }
}
