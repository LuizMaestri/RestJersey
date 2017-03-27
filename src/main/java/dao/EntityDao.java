package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author luiz
 * @since 26/03/17
 */
public abstract class EntityDao<T extends EntityMap> {

    private Class<T> clazz;
    private Session session;
    private Transaction transaction;

    protected EntityDao(){
        this.clazz = getEntityClass();

    }

    protected abstract Class<T> getEntityClass();

    private void openSession(){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
    }

    private void openTransaction(){
        this.openSession();
        transaction = session.beginTransaction();
    }

    private void closeTransaction(){
        session.flush();
        transaction.commit();
        session.close();
    }

    public T get(Long id){
        this.openTransaction();
        T entity = session.find(this.clazz, id);
        this.closeTransaction();
        return entity;
    }


    @SuppressWarnings("unchecked")
    public List<T> list(){
        this.openTransaction();
        Query query = session.createQuery("from " + clazz.getName());
        List<T> entities = (List<T>) query.list();
        this.closeTransaction();
        return entities;
    }

    public void save(T entity){
        this.openTransaction();
        session.saveOrUpdate(entity);
        this.closeTransaction();
    }

    public void delete(Long id){
        this.openTransaction();
        T entity = session.find(this.clazz, id);
        session.delete(entity);
        this.closeTransaction();
    }

}
