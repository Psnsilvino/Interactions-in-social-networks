import java.util.ArrayList;
import java.util.List;

public class User extends Person{
    private int userID;
    private String username;
    private List<User> follows;
    private List<User> followers;
    private List<Post> posts;
    private List<Hobby> hobbies;
    private List<Message> sentMessages;
    private List<Message> receivedMessages;
    private List<Interaction> interactions;

    public User(int id, String name, String username, String email) {
        super(name, email);
        this.userID = id;
        this.username = username;
        this.follows = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.hobbies = new ArrayList<>();
        this.sentMessages = new ArrayList<>();
        this.receivedMessages = new ArrayList<>();
        this.interactions = new ArrayList<>();
    }

    public boolean verifyFollows(User targetUser) {
        for (User user : follows) {
            if (targetUser == user) {
                return true;
            }
        }
        return false;
    }

    public void follow(User followedUser) {
        if (verifyFollows(followedUser)) {
            this.follows.add(followedUser);
            followedUser.followers.add(this);

            Interaction followInteraction = new Interaction(Action.Follow, this, followedUser);
            interactions.add(followInteraction);
        }
        else {
            System.out.println("Usuario ja seguido");
        }
    }

    public void unfollow(User unfollowedUser) {
        if (!verifyFollows(unfollowedUser)) {
            this.follows.remove(unfollowedUser);
            unfollowedUser.followers.remove(this);

            Interaction unfollowInteraction = new Interaction(Action.Follow, this, unfollowedUser);
            interactions.remove(unfollowInteraction);
        }
        else {
            System.out.println("Usuario nao encontrado");
        }
    }

    public void addHobby(String name, String description) {
        Hobby hobby = new Hobby(name, description);
        this.hobbies.add(hobby);
    }

    public void removeHobby(Hobby hobby) {
        this.hobbies.remove(hobby);
    }

    public void sendMessage(User receiver, String content) {
        Message message = new Message(this, receiver, content);
        this.sentMessages.add(message);
        receiver.receivedMessages.add(message);

        Interaction messageInteraction = new Interaction(Action.Message, this, receiver);
        this.interactions.add(messageInteraction);
    }

    public String getUsername() {
        return this.username;
    }

    public void addInteraction(Interaction interaction) {
        this.interactions.add(interaction);
    }
}
