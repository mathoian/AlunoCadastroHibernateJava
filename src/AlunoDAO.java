
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class AlunoDAO {

    public AlunoDAO() {
    }
    
    String addAluno(Aluno aluno, Nota notaAluno1, Nota notaAluno2, Nota notaAluno3){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            session.save(aluno);

            session.save(notaAluno1);

            session.save(notaAluno2);

            session.save(notaAluno3);

            session.getTransaction().commit();
            session.close();
            return "Aluno adicionado com sucesso";
        } catch (HibernateException e) {
            e.printStackTrace();
            session.close();
            return "Ocorreu um erro salvar aluno";
        }
    }
    
    String removerAluno(String matricula){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Aluno aluno = (Aluno) session.get(Aluno.class,matricula);

            if (aluno != null) {
                session.beginTransaction();
                session.delete(aluno);
                session.getTransaction().commit();
                session.close();
                return "Aluno(a) " +aluno.getAlunoNome()+ " Oh yeah! Aluno(a) removido(a) com sucesso ";
            } else {
                session.close();
                return "Matricula não encontrada. =/";
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            session.close();
            return "Erro ao remover Aluno";
        }
    }
    
    String consultarMedia(String matricula){
        Session session = HibernateUtil.getSessionFactory().openSession();
        float media = 0;

        try {
            Aluno aluno = (Aluno) session.get(Aluno.class, matricula);
            if (aluno != null) {
                Set<Nota> notas = (Set<Nota>) aluno.getNotas();
                for(Nota nota : notas){
                    media += nota.getNota();
                }
                media = media/notas.size();
                session.close();
                return "A média do aluno " + aluno.getAlunoNome() + " é: " + media;
            } else {   
                session.close();
                return "Matricula não encontrada.";
            }

        } catch (HibernateException e) {
            e.printStackTrace(); 
            session.close();
            return "Ocorreu um erro consulta média";
        }
    }
    
}
