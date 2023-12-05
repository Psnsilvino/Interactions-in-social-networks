import java.util.List;
import java.util.ArrayList;

public abstract class Account {
    protected List<User> follows;
    protected List<User> followers;
    protected List<Message> sentMessages;
    protected List<Message> receivedMessages;

    public Account(){
        this.follows = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.sentMessages = new ArrayList<>();
        this.receivedMessages = new ArrayList<>();
    }

    public boolean isFollowing(User targetUser) {
        for (User user : follows) {
            if (user.equals(targetUser)) {
                return true;
            }
        }
        return false;
    }

    public void follow(User followingUser, User followedUser) {
        if (!isFollowing(followedUser)) {
            followingUser.follows.add(followedUser);
            followedUser.followers.add(followingUser);

            followingUser.addInteraction(Action.Follow, followedUser, 2);
        }
        else {
            System.out.println("Usuario ja seguido");
        }
    }

    public void unfollow(User unfollowingUser, User unfollowedUser) {
        if (isFollowing(unfollowedUser)) {
            unfollowingUser.follows.remove(unfollowedUser);
            unfollowedUser.followers.remove(unfollowingUser);

            Interaction unfollowInteraction = unfollowingUser.findInteraction(Action.Follow, unfollowedUser);
            unfollowingUser.removeInteraction(unfollowInteraction);
        }
        else {
            System.out.println("Usuario nao encontrado");
        }
    }

    public void sendMessage(User sender, User receiver, String content) {
        if (sender.isFollowing(receiver) && receiver.isFollowing(sender)) {
            Message newMessage = new Message(sender, receiver, content);
            sender.sentMessages.add(newMessage);
            receiver.receivedMessages.add(newMessage);

            sender.addInteraction(Action.Message, receiver, 3);
        }
        else {
            System.out.println("Nao é possivel enviar mensagem ao usuario");
        }
    }
}
