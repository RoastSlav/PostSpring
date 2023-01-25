package rostislav.postspring;

import Mappers.PostMapper;
import Models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    PostMapper mapper;

    @GetMapping("/")
    public Post[] allPosts() {
        return mapper.getAllPosts();
    }

    @GetMapping("/posts/{postId}")
    public Post getPost(@PathVariable Integer postId) {
        return mapper.getPost(postId);
    }

    @GetMapping("/posts/{postId}/comments")
    public String getCommentsFromPost(@PathVariable Integer postId) {
        return "redirect:comments/" + postId;
    }

    @PostMapping("/")
    public int addPost(Post post) {
        return mapper.addPost(post);
    }

    @PutMapping("/")
    public int updatePost(Post post) {
        return mapper.updatePost(post);
    }

    @DeleteMapping("/{id}")
    public int deletePost(@PathVariable Integer id) {
        return mapper.deletePost(id);
    }
}
