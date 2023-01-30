package rostislav.postspring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rostislav.postspring.models.Comment;

public interface IComments {

    @GetMapping("/{postId}")
    public Comment[] getCommentsFromPost(@PathVariable Integer postId);
}
