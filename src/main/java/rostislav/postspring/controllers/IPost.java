package rostislav.postspring.controllers;

import org.springframework.web.bind.annotation.*;
import rostislav.postspring.models.Post;

public interface IPost {

    @GetMapping({"/", ""})
    public Post[] allPosts();

    @GetMapping("/{postId}")
    public Post getPost(@PathVariable Integer postId);

    @GetMapping("/{postId}/comments")
    public String getCommentsFromPost(@PathVariable Integer postId);

    @PostMapping("/")
    public int addPost(Post post);

    @PutMapping("/")
    public int updatePost(Post post);

    @DeleteMapping("/{id}")
    public int deletePost(@PathVariable Integer id);
}
