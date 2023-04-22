package pattern;

import java.util.List;

import com.entities.Post;


public interface StrategyPattern{
	
	public List<Post> sort(List<Post> posts);
	
}



