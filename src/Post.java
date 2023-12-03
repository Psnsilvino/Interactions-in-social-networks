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

        Interaction likeInteraction = new Interaction(Action.Like, user, this.author, 1);
        user.addInteraction(likeInteraction);
    }

    public void addComment(User user, String text) {
        Comment comment = new Comment(user, text);
        comments.add(comment);

        Interaction commentInteraction = new Interaction(Action.Comment, user, this.author, 2);
        user.addInteraction(commentInteraction);
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
