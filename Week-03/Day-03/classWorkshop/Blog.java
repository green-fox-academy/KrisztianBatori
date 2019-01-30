package classWorkshop;

import java.util.ArrayList;
import java.util.List;

public class Blog {
    List<BlogPost> blogPosts;

    public Blog(ArrayList<BlogPost> blogPosts) {
        this.blogPosts = blogPosts;
    }

    public void delete(int postNumber) {
        blogPosts.remove(blogPosts.get(postNumber));
    }

    public void update(int postNumber, BlogPost blogpost) {
        blogPosts.set(blogPosts.indexOf(blogPosts.get(postNumber)), blogpost);
    }
}
