import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Cap02 {
    public static void main(String[] args) {

        System.out.println("1 --------------------------------");

        Usuario u1 = new Usuario("Paulo Silveira", 150);
        Usuario u2 = new Usuario("Rodrigo Turini", 120);
        Usuario u3 = new Usuario("Guilherme Silveira", 190);

        List<Usuario> usuarios = Arrays.asList(u1, u2, u3);

        for (Usuario u : usuarios) {
            System.out.println(u.getNome());
        }
        System.out.println("2 --------------------------------");

        Mostrador mostrador = new Mostrador();
        usuarios.forEach(mostrador);

        System.out.println("3 --------------------------------");
        // Em vez de criar uma classe Mostrador só pra isso, podemos fazer tudo de uma tacada só
        Consumer<Usuario> mostrador2 = new Consumer<Usuario>() {
            public void accept(Usuario usuario) {
                System.out.println(usuario.getNome());
            }
        };
        usuarios.forEach(mostrador2);

        System.out.println("4 --------------------------------");
        // Podemos reduzir um pouco mais esse código, evitando a criação da variável local mostrador:
        usuarios.forEach(
                new Consumer<Usuario>() {
                    public void accept(Usuario usuario) {
                        System.out.println(usuario.getNome());
                    }
                }
        );
        System.out.println("5 --------------------------------");
        // Lambda
        usuarios.forEach(u -> System.out.println(u.getNome()));

        usuarios.forEach(u -> u.tornaModerador());
    }
}
