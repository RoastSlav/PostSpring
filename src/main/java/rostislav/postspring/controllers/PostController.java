package rostislav.postspring.controllers;

import rostislav.postspring.mappers.PostMapper;
import rostislav.postspring.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostMapper mapper;

    @GetMapping({"/", ""})
    public Post[] allPosts() {
        return mapper.getAllPosts();
    }

    @GetMapping("/{postId}")
    public Post getPost(@PathVariable Integer postId) {
        return mapper.getPost(postId);
    }

    @GetMapping("/{postId}/comments")
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
