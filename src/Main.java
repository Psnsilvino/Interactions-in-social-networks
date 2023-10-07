public class Main {
    public static void main(String[] args) {
        Network network = new Network();

        User jorge = new User(0, "Jorge", "jorgemastegamebr", "mastercabral@email.com");
        User mylon = new User(1, "Mylon", "Mylonzete", "mylon@idl.com.br");
        User carlos = new User(2, "Carlos Felino", "ApenasFelino", "Carlos@Apenas.com");

        network.registerUser(jorge);
        network.registerUser(mylon);
        network.registerUser(carlos);

        Post cria = new Post(0, jorge, "Ou tu é cria ou tu esfria");
        Post filme = new Post(1, mylon, "Foguete nao da re");

        network.createPost(cria);
        network.createPost(filme);

        network.printPosts();

        filme.addLike(carlos);
        cria.addComment(carlos, "Sujo");
    }
}
