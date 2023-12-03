import java.util.HashMap;

public class Menu {

    private NetworkController controller;

    public Menu(NetworkController controller) {
        this.controller = controller;
        
    }

    public void initialMenu() {
        System.out.println("Opcoes: ");
        System.out.println("1: Logar");
        System.out.println("0: Sair");
    }

    public void mainMenu() {
        System.out.println("Opcoes: ");
        System.out.println("1: User");
        System.out.println("2: Post");
        System.out.println("0: Sair");
    }

    public void userMenu() {
        System.out.println("1: Seguir usuario");
        System.out.println("2: Remover usuario");
        System.out.println("3: Enviar Mensagem");
        System.out.println("0: Voltar");
    }

}
