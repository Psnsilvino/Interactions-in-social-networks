import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class User extends Account{
    private int userID;
    private String username;
    private List<Interaction> interactions;
    private HashMap<User, Integer> interactionLevels;

    public User(int id, String username) {
        super();
        this.userID = id;
        this.username = username;
        this.interactions = new ArrayList<>();
        this.interactionLevels = new HashMap<User, Integer>();
    }

    public int getId() {
        return this.userID;
    }

    public String getUsername() {
        return this.username;
    }

    public void addInteraction(Interaction interaction) {
        this.interactions.add(interaction);
    }

    public void removeInteraction(Interaction interaction) {
        this.interactions.remove(interaction);
    }

    public Interaction findInteraction(Action action, User otherUser) {
        for (Interaction interaction : interactions) {
            if (interaction.getAction() == action && interaction.getUser1() == this && interaction.getUser2() == otherUser) {
                return interaction;
            }
        }
        return null;
    }
        
}
