package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import bl.beans.UserBean;

public class MysqlHibernateDao {
    public static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);
            // .
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static final ThreadLocal session = new ThreadLocal();

    public static Session currentSession() throws HibernateException {
        Session s = (Session) session.get();
        // Open a new Session, if this thread has none yet
        if (s == null) {
            s = sessionFactory.openSession();
            // Store it in the ThreadLocal variable
            session.set(s);
        }
        return s;
    }

    public static void closeSession() throws HibernateException {
        Session s = (Session) session.get();
        if (s != null)
            s.close();
        session.set(null);
    }

    public static void main(String[] args) {
        UserBean userBean = new UserBean();
        userBean.setName("peterli");
        System.out.println(UserBean.class.getSimpleName());
        Session session = MysqlHibernateDao.currentSession();
        Transaction tx = session.beginTransaction();
        session.save(userBean);
        tx.commit();
        List<UserBean> userBeans = MysqlHibernateDao.currentSession().createQuery("from UserBean").list();
        for (UserBean ub : userBeans) {
            System.out.println(ub.getName());
        }
    }

}
