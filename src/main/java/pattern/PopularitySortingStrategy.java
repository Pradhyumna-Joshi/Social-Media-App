package pattern;

import java.util.List;

import com.entities.Post;
import com.service.DAO;

public class PopularitySortingStrategy implements StrategyPattern {

	public List<Post> sort(List<Post> posts) {
		String query = "from Post p ORDER BY  p.likes DESC";

		DAO dao = new DAO();
		List<Post> list = dao.getAll(query);
		return list;
	}

}
