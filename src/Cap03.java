public class Cap03 {
    public static void main(String[] args) {

        System.out.println("1 -------------------");
        Runnable r1 = new Runnable() {
            public void run() {
                for (int i = 0; i <= 5; i++) {
                    System.out.println(i);
                }
            }
        };
        new Thread(r1).start();

        System.out.println("2 -------------------");
        Runnable r2 = () -> {
            for (int i = 0; i <= 5; i++) {
                System.out.println(i);
            }
        };
        new Thread(r2).start();

        System.out.println("3 -------------------");
        new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                System.out.println(i);
            }
        }).start();

        System.out.println("4 -------------------");
        Validador<String> validadorCEP = new Validador<String>() {
            public boolean valida(String valor) {
                return valor.matches("[0-9]{5}-[0-9]{3}");
            }
        };

        System.out.println("5 -------------------");
        Validador<String> validadorCEPComLambda =
                valor -> valor.matches("[0-9]{5}-[0-9]{3}");

        System.out.println("6 -------------------");
        Runnable o = () -> {
            System.out.println("O que sou eu? Que lambda?");
        };

        System.out.println(o);
        System.out.println(o.getClass());
    }
}
