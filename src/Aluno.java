
import java.util.HashSet;
import java.util.Set;

public class Aluno  implements java.io.Serializable {


	
     private String alunoMatricula;
     private String alunoNome;
     private Set<?> notas = new HashSet();

    public Aluno() {
    }

	
    public Aluno(String alunoMatricula, String alunoNome) {
        this.alunoMatricula = alunoMatricula;
        this.alunoNome = alunoNome;
    }
    public Aluno(String alunoMatricula, String alunoNome, Set<?> notas) {
       this.alunoMatricula = alunoMatricula;
       this.alunoNome = alunoNome;
       this.notas = notas;
    }
   
    public String getAlunoMatricula() {
        return this.alunoMatricula;
    }
    
    public void setAlunoMatricula(String alunoMatricula) {
        this.alunoMatricula = alunoMatricula;
    }
    public String getAlunoNome() {
        return this.alunoNome;
    }
    
    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }
    public Set<?> getNotas() {
        return this.notas;
    }
    
    public void setNotas(Set<?> notas) {
        this.notas = notas;
    }

}


