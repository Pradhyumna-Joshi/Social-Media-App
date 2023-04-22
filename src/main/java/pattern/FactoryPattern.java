package pattern;

import com.entities.Post;
import com.entities.PostImage;
import com.entities.PostInterface;

public class FactoryPattern {

	public FactoryPattern() {
		super();
		// TODO Auto-generated constructor stub
	}

	public  PostInterface getPostInstance(String s) {
		
		if(s == "text") {
			PostInterface post = new  Post();
			return post;
		}else {
			PostInterface post = new  PostImage();
			return post;
		}
	}
}
