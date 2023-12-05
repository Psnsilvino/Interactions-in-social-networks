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

    public void addInteraction(Action action, User otherUser, int value) {
        Interaction newInteraction = new Interaction(action, this, otherUser, value);
        this.interactions.add(newInteraction);
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

    public void getInteractionLevels(){
        for (Interaction i : this.interactions) {
            if (!(this.interactionLevels.containsKey(i.getUser2()))) {
                this.interactionLevels.put(i.getUser2(), i.getValue());
            }
            else {
                int oldValue = this.interactionLevels.get(i.getUser2());
                int newValue = i.getValue() + oldValue;
                this.interactionLevels.replace(i.getUser2(), newValue);
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        return false;
    }

        
}
