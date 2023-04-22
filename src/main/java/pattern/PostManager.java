package pattern;

import java.util.List;

import com.entities.Post;


public class PostManager{
	
	private StrategyPattern strategy;
	
	private List<Post> posts ;
	
	public void setSortingStrategy(StrategyPattern strategy) {
		
		this.strategy = strategy;
	}
	
	public List<Post> getPosts(){
		
		return posts;
	}
	
	public void sortPosts() {	
		if(strategy!=null) {
			posts = strategy.sort(posts);
		}	
	}
	
		
}