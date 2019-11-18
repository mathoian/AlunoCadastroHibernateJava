
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

   public static final SessionFactory session = buildSession();

    private static SessionFactory buildSession() {
	        try {
	            Configuration cfg = new Configuration();
	            cfg.configure("hibernate.cfg.xml");
	            return cfg.buildSessionFactory();

	        } catch (Throwable b) {

	            System.out.println("Erro em  hibernateUtil \n" + b);
	            throw new ExceptionInInitializerError();
	        }
    }
    
    public static SessionFactory getSessionFactory() {
        return session;
    }
    
        public static void shutdown() {
        getSessionFactory().close();
    }
}