package rostislav.postspring.controllers;

import rostislav.postspring.mappers.PostMapper;
import rostislav.postspring.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController implements IPost{
    @Autowired
    PostMapper mapper;

    public Post[] allPosts() {
        return mapper.getAllPosts();
    }

    public Post getPost(@PathVariable Integer postId) {
        return mapper.getPost(postId);
    }

    public String getCommentsFromPost(@PathVariable Integer postId) {
        return "redirect:comments/" + postId;
    }

    public int addPost(Post post) {
        return mapper.addPost(post);
    }

    public int updatePost(Post post) {
        return mapper.updatePost(post);
    }

    public int deletePost(@PathVariable Integer id) {
        return mapper.deletePost(id);
    }
}
