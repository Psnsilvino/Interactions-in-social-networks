import java.util.ArrayList;
import java.util.List;

public class Post {
    private int id;
    private User author;
    private String content;
    private List<User> likes;
    private List<Comment> comments;

    public Post(int id, User author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.likes = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public void addLike(User user) {
        likes.add(user);

        user.addInteraction(Action.Like, this.author, 1);
    }

    public void addComment(User user, String text) {
        Comment comment = new Comment(user, text);
        comments.add(comment);

        user.addInteraction(Action.Comment, this.author, 2);
    }

    public int getId() {
        return this.id;
    }

    public User getAuthor() {
        return this.author;
    }

    public String getContent() {
        return this.content;
    }
}
