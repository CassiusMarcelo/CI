import java.io.*;
import java.util.ArrayList;

public class GerenciadorLivros {
    private ArrayList<Livro> livros;

    private static GerenciadorLivros cad = null;

    public static GerenciadorLivros getInstance() throws IOException {
        if (cad == null) {
            cad = new GerenciadorLivros();
        }
        return cad;
    }

    private GerenciadorLivros() throws IOException {
        this.livros = new ArrayList<>();
    }

    public void removeAll(){
        livros.clear();
        }


    public int size(){
        int cont=0;
        for(Livro l : livros){
            cont ++;
        }
        return cont;
    }

    public void gravarDados() throws IOException {

        FileWriter arq = null;
        try {
            arq = new FileWriter(System.getProperty("user.dir")+"\\livraria.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter gravarArq = new PrintWriter(arq);

        for(Livro l : livros){
            gravarArq.print(l.getTitulo() + ";");
            gravarArq.print(l.getAno() + ";");
            gravarArq.print(l.getAutor() + ";");
            gravarArq.print(l.getStatus() + ";");
            if(l.getNomeEmp()=="") gravarArq.print("nulo" + ";");
            else gravarArq.print(l.getNomeEmp() + ";");
            gravarArq.println();
        }

        arq.close();
    }


    public void lerDados() throws FileNotFoundException {
        try {
            FileReader arq = new FileReader((System.getProperty("user.dir")+"\\livraria.txt"));
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            String[] dados = linha.split(";");


            String titulo = dados[0];
            int ano = Integer.parseInt(dados[1]);
            String autor = dados[2];
            String status = dados[3];
            String nomeEmp = dados[4];
            if (nomeEmp.equals("nulo")) nomeEmp = "";
            Livro liv = new Livro(titulo,ano,autor);
            liv.setStatus(status);
            liv.setNomeEmp(nomeEmp);
            this.addLivro(liv);


            while ((linha = lerArq.readLine()) != null) {
                dados = linha.split(";");
                titulo = dados[0];
                ano = Integer.parseInt(dados[1]);
                autor = dados[2];
                status = dados[3];
                nomeEmp = dados[4];
                if (nomeEmp.equals("nulo")) nomeEmp = "";
                liv = new Livro(titulo,ano,autor);
                liv.setStatus(status);
                liv.setNomeEmp(nomeEmp);
                this.addLivro(liv);
            }

            arq.close();
        } catch (IOException e) {
            System.out.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

       System.out.println();

    }



    public void addLivro(Livro umLivro){
        livros.add(umLivro);
    };

    public void removeLivro(Livro umLivro){
        livros.remove(umLivro);
    }

    public boolean doarLivro(Livro liv) {
        livros.add(liv);
        return true ;
    }

    public boolean retirarLivro(int opc, String umNome) throws Exception {
        String disp = "Disponível";
        String indisp = "Indisponível";
        Livro livIndex = livros.get(opc-1);
        if(opc<1 || opc>livros.size()) throw new Exception("Opção Inexistente. Refazer a operação.");
        if(livIndex.getStatus().equals(indisp)) throw new Exception("Livro indisponível para retirada. Refazer a operação.");
        livIndex.setStatus(indisp);
        livIndex.setNomeEmp(umNome);
        Livro aux = livIndex;
        livros.remove(livIndex);
        livros.add(0,aux);
        return true;
    }

    public boolean devolverLivro(int opc) throws Exception{
        String disp = "Disponível";
        String indisp = "Indisponível";
        Livro livIndex = livros.get(opc-1);
        if(opc<1 || opc>livros.size())  throw new Exception("Opção Inexistente. Refazer a operação."); ;
        if(livIndex.getStatus().equals(disp))  throw new Exception("O livro já está disponível em nossa biblioteca. Refazer a operação.");;
        livIndex.setStatus(disp);
        livIndex.setNomeEmp("");
        return true;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("\n");
        for(int i=0; i<livros.size();i++){
            if(livros.get(i) !=null) {
                res.append("Numero:" + String.format("%05d", i+1));
                res.append("\n" + livros.get(i).toString()+"\n");
            }
        }
        return res.toString();
    }

    public String listarLivros(){
        return this.toString();
    }
}
