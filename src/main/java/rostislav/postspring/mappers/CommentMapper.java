package rostislav.postspring.mappers;

import rostislav.postspring.models.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
    public Comment[] getComment(int id);

    public Comment getAllComments();

    public int addComment(Comment comment);

    public int updateComment(Comment comment);

    public int deleteComment(int id);
}
