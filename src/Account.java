import java.util.List;
import java.util.ArrayList;

public abstract class Account {
    protected List<User> follows;
    protected List<User> followers;
    protected List<Post> posts;
    protected List<Hobby> hobbies;
    protected List<Message> sentMessages;
    protected List<Message> receivedMessages;

    public Account(){
        this.follows = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.hobbies = new ArrayList<>();
        this.sentMessages = new ArrayList<>();
        this.receivedMessages = new ArrayList<>();
    }

    public boolean verifyFollows(User targetUser) {
        for (User user : follows) {
            if (targetUser == user) {
                return true;
            }
        }
        return false;
    }

    public void follow(User followingUser, User followedUser) {
        if (!verifyFollows(followedUser)) {
            followingUser.follows.add(followedUser);
            followedUser.followers.add(followingUser);

            Interaction followInteraction = new Interaction(Action.Follow, followingUser, followedUser);
            followingUser.addInteraction(followInteraction);
        }
        else {
            System.out.println("Usuario ja seguido");
        }
    }

    public void unfollow(User unfollowingUser, User unfollowedUser) {
        if (verifyFollows(unfollowedUser)) {
            unfollowingUser.follows.remove(unfollowedUser);
            unfollowedUser.followers.remove(unfollowingUser);

            Interaction unfollowInteraction = unfollowingUser.findInteraction(Action.Follow, unfollowedUser);
            unfollowingUser.removeInteraction(unfollowInteraction);
        }
        else {
            System.out.println("Usuario nao encontrado");
        }
    }
}
