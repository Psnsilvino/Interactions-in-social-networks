import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<User> users;
    private List<Post> posts;

    public Network() {
        this.users = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public void registerUser(User user) {
        this.users.add(user);
    }

    public void createPost(Post post) {
        this.posts.add(post);
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }

    public int getUsersSize() {
        return this.users.size();
    }
    
    public int getPostsSize() {
        return this.posts.size();
    }

    public void printPosts() {
        for (Post post : this.posts) {
            System.out.println("Autor: " + post.getAuthor().getUsername());
            System.out.println("Conteúdo: " + post.getContent());
            System.out.println();
        }
    }

    public void printUsers() {
        for (User user : this.users) {
            System.out.println("Username: " + user.getUsername());
            System.out.println();
        }
    }

    public User findUser(int userID) {
        User foundUser;
        for (User u : users) {
            int verifiedUsername = u.getId();
            if (verifiedUsername == userID) {
                foundUser = u;
                return foundUser;
            }
        }
        return null;
    }

    public Post findPost(int postId) {
        Post foundPost;
        for (Post p : posts) {
            if (p.getId() == postId) {
                foundPost = p;
                return foundPost;
            }
        }
        return null;
    }
}
