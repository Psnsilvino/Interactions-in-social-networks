public class Main {
    public static void main(String[] args) {
        Network network = new Network();

        User jorge = new User(0, "jorgemastegamebr");
        User mylon = new User(1, "Mylonzete");
        User carlos = new User(2, "ApenasFelino");

        network.registerUser(jorge);
        network.registerUser(mylon);
        network.registerUser(carlos);

        jorge.follow(jorge, carlos);
        jorge.unfollow(jorge, carlos);

        Post cria = new Post(0, jorge, "Ou tu é cria ou tu esfria");
        Post filme = new Post(1, mylon, "Foguete nao da re");

        network.createPost(cria);
        network.createPost(filme);

        network.printPosts();

        filme.addLike(carlos);
        cria.addComment(carlos, "Sujo");
    }
}
