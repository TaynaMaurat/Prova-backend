Package com.tayna.shared.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("shareds")
public class shared {
    
    @Id
    private String id ;
    private String nome ;
    private String genero ;
    private String cantor;
    private String album;
    private Integer lancamento;
  
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getCantor() {
        return cantor;
    }
    public void setCantor(String cantor) {
        this.cantor = cantor;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public Integer getLancamento() {
        return lancamento;
    }
    public void setLancamento(Integer lancamento) {
        this.lancamento = lancamento;
    }

    