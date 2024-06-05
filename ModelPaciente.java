package Hospital;

public class ModelPaciente {
    private String nome;
    private int idade;
    private String sexo;
    private String observacoes;

    public ModelPaciente(String nome, int idade, String sexo, String observacoes) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.observacoes = observacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
