package rostislav.postspring.controllers;

import rostislav.postspring.models.Comment;
import rostislav.postspring.mappers.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentController implements IComments {
    @Autowired
    CommentMapper mapper;

    public Comment[] getCommentsFromPost(@PathVariable Integer postId) {
        return mapper.getComment(postId);
    }
}
