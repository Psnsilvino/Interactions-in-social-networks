
public class InitialLoad {
    private Network network;

    public InitialLoad(Network network) {
        this.network = network;
    }

    public void chargeData(){
        User jorge = new User(network.getUsersSize(), "jorgemastegamebr");
        this.network.registerUser(jorge);

        User mylon = new User(network.getUsersSize(), "Mylonzete");
        this.network.registerUser(mylon);

        User carlos = new User(network.getUsersSize(), "ApenasFelino");
        this.network.registerUser(carlos);

        User vechi = new User(network.getUsersSize(), "Vechi");
        this.network.registerUser(vechi);


        Post cria = new Post(network.getPostsSize(), jorge, "Ou tu é cria ou tu esfria");
        this.network.createPost(cria);

        Post filme = new Post(network.getPostsSize(), mylon, "Foguete nao da re");
        this.network.createPost(filme);

        filme.addLike(carlos);
        cria.addComment(carlos, "Sujo");
    }

}

