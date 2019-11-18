
public class Nota  implements java.io.Serializable {


     private Integer codigoDaNota;
     private Aluno aluno;
     private float nota;

    public Nota() {
    }

    public Nota(Aluno aluno, float nota) {
       this.aluno = aluno;
       this.nota = nota;
    }
   
    public Integer getCodigoDaNota() {
        return this.codigoDaNota;
    }
    
    public void setCodigoDaNota (Integer codigoDaNota) {
        this.codigoDaNota = codigoDaNota;
    }
    public Aluno getAluno() {
        return this.aluno;
    }
    
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    public float getNota() {
        return this.nota;
    }
    
    public void setNota(float nota) {
        this.nota = nota;
    }

}


