import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        ArrayList<Pessoa> banco = new ArrayList<>();


        ArrayList<Pessoa> cache = new ArrayList<>();


        banco.add(new Pessoa(1, "Ana", 22));
        banco.add(new Pessoa(2, "Bruno", 30));
        banco.add(new Pessoa(3, "Carla", 25));
        banco.add(new Pessoa(4, "Diego", 41));
        banco.add(new Pessoa(5, "Eduarda", 19));
        banco.add(new Pessoa(6, "Felipe", 35));
        banco.add(new Pessoa(7, "Gabriela", 28));
        banco.add(new Pessoa(8, "Henrique", 50));
        banco.add(new Pessoa(9, "Isabela", 23));
        banco.add(new Pessoa(10, "Joao", 33));


        Scanner sc = new Scanner(System.in);

        int id = -1;


        while (id != 0) {

            IO.println("Digite o ID da pessoa (0 para sair): ");
            id = sc.nextInt();

            if (id != 0) {


                boolean achouNoCache = false;

                for (int i = 0; i < cache.size(); i++) {
                    if (cache.get(i).getId() == id) {
                        IO.println("Pessoa encontrada no cache: " + cache.get(i));
                        achouNoCache = true;
                    }
                }


                if (achouNoCache == false) {

                    boolean achouNoBanco = false;

                    for (int i = 0; i < banco.size(); i++) {
                        if (banco.get(i).getId() == id) {

                            achouNoBanco = true;


                            if (cache.size() == 10) {
                                IO.println("Cache cheio, removendo o mais antigo: " + cache.get(0));
                                cache.remove(0);
                            }

                            cache.add(banco.get(i));
                            IO.println("Pessoa buscada no banco e adicionada ao cache: " + banco.get(i));
                        }
                    }

                    if (achouNoBanco == false) {
                        IO.println("Pessoa nao encontrada no banco.");
                    }
                }

                IO.println();;
            }
        }

        IO.println("Programa encerrado.");
        sc.close();
    }
}
