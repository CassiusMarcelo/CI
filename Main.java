import java.io.IOException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception {
        GerenciadorLivros gerLivros = GerenciadorLivros.getInstance();
        gerLivros.lerDados();
        //Incluir livros na biblioteca
        if(gerLivros.size()==0) {
            Livro liv1 = new Livro("Como fazer sentido e bater o martelo", 2017, "Alexandre Aolchique");
            Livro liv2 = new Livro("Código Limpo", 2001, "Tio Bob");
            Livro liv3 = new Livro("Basquete 101", 2010, "Hortência Marcari");


            gerLivros.addLivro(liv1);
            gerLivros.addLivro(liv2);
            gerLivros.addLivro(liv3);
            gerLivros.gravarDados(); // gravar dados num arquivo .txt
            gerLivros.removeAll(); //esvazia a lista para não haver duplicidades
        }



        //Executando pela primeira vez para adicionar os livros para a biblioteca.
        //Após a primeira execução o programa gravará um arquivo, sendo assim, não é mais necessário adicionar os livros na biblioteca.
        // o sistena caregará automaticamente.
        //O sistema também salvará as alterações feitas na biblioteca.

        Scanner in = new Scanner(System.in);
        System.out.println("Olá. Favor informar seu nome e sobrenome.");
        String nome = in.nextLine();
        int opcao;
        if(gerLivros.size()==0) gerLivros.lerDados();
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
                    gerLivros.gravarDados();

                    break;

                case 2:
                    System.out.println("Selecione o livro que você deseja devolver através da numeração.\n" + gerLivros.listarLivros());
                    opint = in.nextInt();
                    boolean devLivros = gerLivros.devolverLivro(opint);
                    if(devLivros==true) System.out.println("Devolução feita com sucesso");
                    gerLivros.gravarDados();

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
                    gerLivros.gravarDados();
                    break;
            }


        } while (opcao!=0);
        System.out.println("Obrigado por utilizar nossos serviços!");

    }
}
