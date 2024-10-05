package patronDao;

import java.util.Objects;

public class Alumno {
    private String nome;
    private String  email;
    private Integer idade;

    public static void main(String[] args) {

    }

    public Alumno(Integer idade, String email, String nome) {
        this.idade = idade;
        this.email = email;
        this.nome = nome;
    }

    public Alumno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Alumno alumno)) return false;
        return Objects.equals(nome, alumno.getNome());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Email: " + email;
    }
}
