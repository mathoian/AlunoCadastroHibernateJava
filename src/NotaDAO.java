
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query ;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class NotaDAO {

    public NotaDAO() {
    }

    
    String mediaGeral(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        float media = 0;

        try {
        	CriteriaBuilder builder = session.getCriteriaBuilder();
        	CriteriaQuery<Nota> query = builder.createQuery(Nota.class);
        	Root<Nota> root = query.from(Nota.class);
        	query.select(root);
        	Query<Nota> q = session.createQuery(query);
        	List<Nota> Notaslist = q.getResultList();

            for(Nota nota : Notaslist){
                media += nota.getNota();
            }
            media = media/Notaslist.size();
            session.close();
            return "A média geral é: " + media;

        } catch (HibernateException e) {
            e.printStackTrace(); 
            session.close();
            return "Erro Não foi possivel gerar média";
        }
    }

}
