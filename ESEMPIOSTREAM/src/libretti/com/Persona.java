package libretti.com;

public class Persona {
    private String nome;
    private int eta;
    private  boolean sposato;
    public Persona(String nome,int eta,boolean sposato){
        setNome(nome);
        setEta(eta);
        setSposato(sposato);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    public boolean isSposato() {
        return sposato;
    }

    public void setSposato(boolean sposato) {
        this.sposato = sposato;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", eta=" + eta +
                ", sposato=" + sposato +
                '}';
    }
}
