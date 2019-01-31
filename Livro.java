public class Livro {
    private String titulo;
    private int ano;
    private String autor;
    private String status;
    private String nomeEmp;

    public Livro(String umTit, int umAno, String umAut){
        titulo = umTit;
        ano = umAno;
        autor = umAut;
        status = "Disponível";
        nomeEmp = "";
    }

    public int getAno() {
        return ano;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getStatus() {
        return status;
    }

    public String getNomeEmp() {
        return nomeEmp;
    }

    public void setStatus(String stat){ status = stat;}
    public void setNomeEmp (String nome){ nomeEmp = nome;}


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Titulo: " + getTitulo());
        res.append("\nAutor: " + getAutor());
        res.append("\nAno: " + getAno());
        res.append("\nStatus: " + getStatus());
        res.append("\nEmprestado para: " + getNomeEmp() + "\n");
        return res.toString();
    }
}
