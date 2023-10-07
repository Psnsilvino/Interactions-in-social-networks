public enum Action {
    Message(2),
    Follow(2),
    Like(1),
    Comment(3);

    int value;

    Action(int value) {
        this.value = value;
    }
}
