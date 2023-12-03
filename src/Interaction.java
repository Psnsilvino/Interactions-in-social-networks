public class Interaction {
    
    private Action action;
    private User user1;
    private User user2;
    private int value;
    
    public Interaction(Action action, User user1, User user2, int value) {
        this.action = action;
        this.user1 = user1;
        this.user2 = user2;
        this.value = value;
    }

    public Action getAction() {
        return this.action;
    }
    
    public User getUser1() {
        return this.user1;
    }
    
    public User getUser2() {
        return this.user2;
    }

    public int getValue() {
        return this.value;
    }

}
