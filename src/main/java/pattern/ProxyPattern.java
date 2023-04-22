package pattern;

import java.util.List;

import org.springframework.core.type.filter.AbstractClassTestingTypeFilter;
import org.springframework.ui.Model;

import com.entities.Post;
import com.entities.PostInterface;
import com.entities.User;
import com.service.DAO;

// proxy pattern : Structural pattern

public class ProxyPattern {

	DAO dao = new DAO();

	public ProxyPattern() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean userPreprocess(User u, String type, Model m) {

		if (type == "login") {

			if (u.getEmail().isEmpty() || u.getPassword().isEmpty()) {
				m.addAttribute("status", "Email/Password cannot be empty");
				return false;
			} else {
				// query to database;
				if (dao.fetchUser(u)) {
					m.addAttribute("status", "Successfully LoggedIn");
					return true;

				} else {
					m.addAttribute("status", "Incorrect Email/Password");
					return false;
				}

			}

		} else {

			if (u.getUsername().isEmpty() || u.getEmail().isEmpty() || u.getPassword().isEmpty()) {
				m.addAttribute("status", "Username/Email/Password cannot be empty");
				return false;
			} else {
				// query to database;

				dao.saveUser(u);
				m.addAttribute("status", "Successfully SignedIn");
				return true;
			}
		}
	}

	public void postPreprocess(PostInterface p, Model m) {

		dao.savePost(p);
		m.addAttribute("status", "Successfully posted");

	}

}
