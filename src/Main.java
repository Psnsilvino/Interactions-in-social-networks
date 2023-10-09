public class Main {
    public static void main(String[] args) {
        Network network = new Network();
        
        new InitialLoad(network).chargeData();
        new NetworkController(network).run();
    }
}
