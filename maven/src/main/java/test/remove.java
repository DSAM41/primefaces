package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@ViewScoped
public class remove {
	HttpSession hs = Util.getSession();

	public void remove_data(User_test actor) throws IOException {

		List<User_test> list = new ArrayList<User_test>();

		List<User_test> numbers = (List<User_test>) hs.getAttribute("list");

		for (User_test anews : numbers) {
			if (anews.getId() == actor.getId()) {
				System.out.println(actor.getId());
			} else {
				list.add(anews);
			}
		}
		hs.setAttribute("list", list);
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().redirect("/maven/showdata.xhtml");
	}
}
