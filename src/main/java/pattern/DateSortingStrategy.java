package pattern;

import java.util.List;

import com.entities.Post;
import com.service.DAO;
public class DateSortingStrategy implements StrategyPattern {

	public List<Post> sort(List<Post> posts) {
		// TODO Auto-generated method stub
		
		
		String query = "from Post p ORDER BY p.date";
		
		DAO dao = new DAO();
		List<Post> list = dao.getAll(query);
		return list;
	}

}
