package rostislav.postspring.mappers;

import rostislav.postspring.models.Post;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
    public Post getPost(int id);

    public Post[] getAllPosts();

    public int addPost(Post post);

    public int updatePost(Post post);

    public int deletePost(int id);
}
