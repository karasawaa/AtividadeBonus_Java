package model;

public class ObraDeArte {

    private String titulo;
    private String artista;
    private int anoCriacao;
    private String tipoObra;
    private String local;
    
    public ObraDeArte(String titulo, String artista, int anoCriacao, String tipoObra, String local) {
        this.titulo = titulo;
        this.artista = artista;
        this.anoCriacao = anoCriacao;
        this.tipoObra = tipoObra;
        this.local = local;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(int anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    public String getTipoObra() {
        return tipoObra;
    }

    public void setTipoObra(String tipoObra) {
        this.tipoObra = tipoObra;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return titulo + ", " + artista + ", " + anoCriacao + ", " + tipoObra + ", " + local;
    }

    public static ObraDeArte fromString(String linha) {

        String[] dadosObra = linha.split(", ");

        return new ObraDeArte(dadosObra[0], 
                              dadosObra[1], 
             Integer.parseInt(dadosObra[2]),
                              dadosObra[3],
                              dadosObra[4]);

    }
}
