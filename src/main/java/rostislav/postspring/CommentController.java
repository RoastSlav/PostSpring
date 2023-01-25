package rostislav.postspring;

import Mappers.CommentMapper;
import Models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    @Autowired
    CommentMapper mapper;

    @GetMapping("/{postId}")
    public Comment[] getCommentsFromPost(@PathVariable Integer postId) {
        return mapper.getComment(postId);
    }
}
