import java.io.IOException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception {
        Livro liv1 = new Livro("Como fazer sentido e bater o martelo",2017,"Alexandre Aolchique");
        Livro liv2 = new Livro("Código Limpo",2001,"Tio Bob");
        Livro liv3 = new Livro("Basquete 101",2010, "Hortência Marcari");

        liv3.setStatus("Indisponível");
        liv3.setNomeEmp("João Pedro");




        //System.out.print(gerLivros.listarLivros());  // testando inclusão dos três primeiros livros.

        GerenciadorLivros gerLivros = GerenciadorLivros.getInstance();

        gerLivros.addLivro(liv1);
        gerLivros.addLivro(liv2);
        gerLivros.addLivro(liv3);
        // teste funcionalidade : retirar livro
        gerLivros.retirarLivro(2,"Maria Antônia");
        //System.out.print(gerLivros.listarLivros());

        // teste funcionalidade : devolver um livro.
        gerLivros.devolverLivro(3);
        //System.out.print(gerLivros.listarLivros());

        // teste funcionalidade : doar um livro.
        Livro liv4 = new Livro("Novo Livro",
                            2000,
                            "Inês");
        gerLivros.doarLivro(liv4);
        //System.out.print(gerLivros.listarLivros());


        gerLivros.gravarDados();
        //gerLivros.lerDados(); //carregar arquivo com alterações feitas nos primeiros testes.

        Scanner in = new Scanner(System.in);
        System.out.println("Olá. Favor informar seu nome e sobrenome.");
        String nome = in.nextLine();

        int opcao = 1;
        do {
            System.out.print(gerLivros.listarLivros());
            System.out.print(nome + "Seja bem-vindo(a) a nossa biblioteca virtual." +
                    "\nO que você gostaria de fazer?" +
                    "\nSelecione entre as opções abaixo (entre 1 e 3)" +
                    "\n\n-> 1 - Retirar um livro." +
                    "\n\n-> 2 - Devolver um livro." +
                    "\n\n-> 3 - Doar um livro." +
                    "\n\n-> 0 - Sair");
            opcao = in.nextInt();
            int opint;
            switch (opcao){
                case 1:
                    System.out.println("Selecione o livro que você deseja retirar através da numeração.\n" + gerLivros.listarLivros());
                    opint = in.nextInt();
                    boolean retLivros = gerLivros.retirarLivro(opint,nome);
                    if (retLivros==true) System.out.println("Livro retirado com sucesso.");
                    break;

                case 2:
                    System.out.println("Selecione o livro que você deseja devolver através da numeração.\n" + gerLivros.listarLivros());
                    opint = in.nextInt();
                    boolean devLivros = gerLivros.devolverLivro(opint);
                    if(devLivros==true) System.out.println("Devolução feita com sucesso");
                    break;

                case 3:
                    System.out.println("Ótimo!" +
                            "\nFavor inserir os dados do livro." +
                            "\nAno: ");
                    int ano = in.nextInt();
                    System.out.println("\nTitulo: ");
                    in.nextLine();
                    String titulo = in.nextLine();
                    System.out.println("\nAutor:");
                    String autor = in.nextLine();
                    Livro l = new Livro (titulo,ano,autor);
                    gerLivros.doarLivro(l);
                    break;
            }


        } while (opcao!=0);

        System.out.println("Obrigado por utilizar nossos serviços!");

    }
}
