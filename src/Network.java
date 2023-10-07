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
        users.add(user);
    }

    public void createPost(Post post) {
        posts.add(post);
    }

    public void removeUser(User user) {
        users.remove(user);
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

}
