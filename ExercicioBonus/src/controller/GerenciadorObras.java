package controller;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.ObraDeArte;

public abstract class GerenciadorObras {

    private static final String ARQUIVO = "obras.txt";
    


    public static void salvarObra(ObraDeArte obra) throws IOException {

        try (FileWriter fw = new FileWriter(ARQUIVO, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(obra + "\n");

        }

    }

    public static ArrayList<ObraDeArte> listarObras() throws IOException, Exception {

        ArrayList<ObraDeArte> listaObras = new ArrayList<>();

        try (FileReader fr = new FileReader(ARQUIVO);
             BufferedReader br = new BufferedReader(fr)) {

                String linha;
                while ((linha = br.readLine()) != null) {
                    
                    ObraDeArte obra = ObraDeArte.fromString(linha);
                    listaObras.add(obra);
                }
        } 

        if (listaObras.isEmpty()) {
            throw new Exception("\nNão há obras de arte cadastradas!");
        }

        return listaObras;

    }

    public static ObraDeArte buscarObra(String titulo) throws Exception {

        ArrayList<ObraDeArte> listaObras = listarObras();
    
        for (ObraDeArte tempObra : listaObras) {
    
            if (tempObra.getTitulo().equalsIgnoreCase(titulo)) { // torna  a busca case-insensitive, ou seja, ignora minúsculas e maiúsculas
                return tempObra;
            }
        }
    
        throw new Exception("\nObra de arte com o título " + titulo + " não localizado!");
    
    }
    

    public static void apagarObra(String titulo) throws Exception {

    ArrayList<ObraDeArte> listaObras = listarObras();       

    boolean encontrou = false;
    for (ObraDeArte temp : listaObras) {

        if (temp.getTitulo().equalsIgnoreCase(titulo)) { // torna  a busca case-insensitive, ou seja, ignora minúsculas e maiúsculas
            listaObras.remove(temp);
            encontrou = true;
            break;
        }
    }

    if (!encontrou) {
        throw new Exception("\nObra de arte com o título " + titulo + " não localizada!");
    }

        // sobrescrever arquivo com array list atualizado:
        try (FileWriter fw = new FileWriter(ARQUIVO);
        BufferedWriter bw = new BufferedWriter(fw)) {

            for (ObraDeArte o : listaObras) {

                bw.write(o + "\n");
            }
        }
    }

    public static void atualizarObra(String titulo, String novoTitulo, String novoArtista, int novoAnoCriacao, String novoTipoObra, String novoLocal) throws Exception {
        ArrayList<ObraDeArte> listaObras = listarObras();

        ObraDeArte obraAtualizada = null;
        boolean encontrou = false;
        for (ObraDeArte temp : listaObras) {
            if (temp.getTitulo().equalsIgnoreCase(titulo)) {
                obraAtualizada = temp;
                listaObras.remove(temp);
                encontrou = true;
                break;
            }
        }

        if (!encontrou) {
            throw new Exception("\nObra de arte com o título " + titulo + " não localizada!");
        }

        // Atualiza os atributos da obra de arte
        if (!novoTitulo.isEmpty()) {
            obraAtualizada.setTitulo(novoTitulo);
        }

        if (!novoArtista.isEmpty()) {
            obraAtualizada.setArtista(novoArtista);
        }

        if (novoAnoCriacao != 0) {
            obraAtualizada.setAnoCriacao(novoAnoCriacao);
        }

        if (!novoTipoObra.isEmpty()) {
            obraAtualizada.setTipoObra(novoTipoObra);
        }

        if (!novoLocal.isEmpty()) {
            obraAtualizada.setLocal(novoLocal);
        }

        // Adiciona a obra de arte atualizada de volta à lista
        listaObras.add(obraAtualizada);

        // Salva a lista atualizada de volta ao armazenamento
        try (FileWriter fw = new FileWriter(ARQUIVO);
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (ObraDeArte o : listaObras) {
                bw.write(o.toString() + "\n");
            }
        }
    }
    
}