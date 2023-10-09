import java.util.Scanner;

public class NetworkController {
    private Scanner scanner;
    private Network network;
    private User loggedUser;
    private boolean exit;


    public NetworkController(Network network) {
        this.scanner = new Scanner(System.in);
        this.network = network;
        this.loggedUser = null;
        this.exit = false;
    }

    public void run(){
        while (!exit) {
            verifyUserLogin();
        }
    }

    private void verifyUserLogin() {
        if (this.loggedUser == null) {
            displayInitialOptions();
            executeInitialChoice();
        }
        else {
            displayUserOptions();
            executeUserChoice();
        }
    }

    private void displayInitialOptions() {

        System.out.println("Opcoes: ");
        System.out.println("1: Logar");
        System.out.println("0: Sair");
    }

    private void executeInitialChoice() {
        int option = this.scanner.nextInt();
        switch (option) {
            case 1:
                changeUser();
                break;
            case 0:
                System.exit(1);
            default:
                System.out.println("Opção inválida");
        }
    }

    private void displayUserOptions() {
        
        String menuText = String.format("Opcoes para %s:", this.loggedUser.getUsername());
        System.out.println(menuText);
        System.out.println("1: Seguir usuario");
        System.out.println("2: Remover usuario");
        System.out.println("3: Criar postagem");
        System.out.println("4: Curtir postagem");
        System.out.println("5: Comentar postagem");
        System.out.println("6: Enviar Mensagem");
        System.out.println("7: Alterar usuario ativo");
        System.out.println("0: Sair");
    }

    private void executeUserChoice() {
        int option = this.scanner.nextInt();
        switch (option) {
            case 1:
                follow();
                break;
            case 2:
                unfollow();
                break;
            case 3:
                createPost();
                break;
            case 4:
                like();
                break;
            case 5:
                comment();
                break;
            case 6:
                sendMessage();
                break;
            case 7:
                changeUser();
                break;
            case 0:
                System.exit(1);
            default:
                System.out.println("Opção inválida");
        }
    }

    private void follow() {
        System.out.println("Qual o id do usuario que vai deixar de seguir: ");
        int id = this.scanner.nextInt();
        User followed = network.findUser(id);
        this.loggedUser.follow(loggedUser, followed);
    }

    private void unfollow() {
        System.out.println("Qual o id do usuario que vai deixar de seguir: ");
        int id = this.scanner.nextInt();
        User unfollowed = network.findUser(id);
        this.loggedUser.unfollow(loggedUser, unfollowed);
    }

    private void createPost() {
        int postNumber = network.getPostsSize();
        System.out.println("Qual o conteudo da postagem: ");
        String content = this.scanner.nextLine();
        Post newPost = new Post(postNumber, loggedUser, content);
        network.createPost(newPost);
    }

    private void like() {
        System.out.println("Qual o id do post a ser curtido: ");
        int postId = this.scanner.nextInt();
        Post likedPost = network.findPost(postId);
        likedPost.addLike(loggedUser);
    }

    private void comment() {
        System.out.println("Qual o id do post a ser curtido: ");
        int postId = this.scanner.nextInt();
        Post commentedPost = network.findPost(postId);
        System.out.println("Qual o comentario que deseja ser adicionado: ");
        String text = this.scanner.nextLine();
        commentedPost.addComment(loggedUser, text);
    }

    private void sendMessage() {
        System.out.println("Qual o id do destinatario");
        int messagedId = this.scanner.nextInt();
        User messagedUser = network.findUser(messagedId);
        System.out.println("Qual o conteudo da mensagem: ");
        String content = this.scanner.nextLine();
        loggedUser.sendMessage(loggedUser, messagedUser, content);
    }

    private void changeUser() {
        System.out.println("Qual o id do usuario a ser logado: ");
        int userId = this.scanner.nextInt();
        User newUser = network.findUser(userId);
        this.loggedUser = newUser;
    }
}
