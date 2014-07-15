package bl.mysqlbus;

import bl.beans.UserBean;
import bl.common.*;
import vo.table.TableDataVo;
import vo.table.TableQueryVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.MysqlHibernateDao;

/**
 * Created by pli on 14-7-14.
 */
public class MysqlBusiness<F, L> implements BusinessInterface, TableBusinessInterface {
    protected Class<?> cls;

    @Override
    public BeanContext constructLeafBean() {
        return null;
    }

    @Override
    public BusinessResult createLeaf(BeanContext genLeafBean) {
        Session session = MysqlHibernateDao.currentSession();
        Transaction tx = session.beginTransaction();
        session.save(genLeafBean);
        tx.commit();
        MysqlHibernateDao.closeSession();
        // TODO deal with return value.
        return null;
    }

    @Override
    public BusinessResult getLeaf(String objectId) {
        Session session = MysqlHibernateDao.currentSession();
        Transaction tx = session.beginTransaction();
        String hql = "from " + this.cls.getSimpleName() + " as p where p.id=?";
        Query query = session.createQuery(hql);
        query.setLong(0, Long.valueOf(objectId));
        BusinessResult br = new BusinessResult();
        br.setResponseData(query.uniqueResult());
        tx.commit();
        MysqlHibernateDao.closeSession();
        return br;
    }

    @Override
    public BusinessResult getLeafByName(String name) {
        return null;
    }

    @Override
    public BusinessResult deleteLeaf(String objectId) {
        Session session = MysqlHibernateDao.currentSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete " + this.cls.getSimpleName() + " as p where p.id=?";
        Query query = session.createQuery(hql);
        query.setLong(0, Long.valueOf(objectId));
        query.executeUpdate();
        tx.commit();
        MysqlHibernateDao.closeSession();
        // TODO deal with return value.
        return null;
    }

    @Override
    public BusinessResult updateLeaf(BeanContext origBean, BeanContext newBean) {
        Session session = MysqlHibernateDao.currentSession();
        Transaction tx = session.beginTransaction();
        session.save(newBean);
        tx.commit();
        MysqlHibernateDao.closeSession();
        // TODO deal with return value.
        return null;
    }

    @Override
    public BusinessResult getAllLeaves() {
        Session session = MysqlHibernateDao.currentSession();
        String hql = "from " + this.cls.getSimpleName() + " as p";
        Query query = session.createQuery(hql);
        BusinessResult br = new BusinessResult();
        br.setResponseData(query.list());
        MysqlHibernateDao.closeSession();
        return br;
    }

    @Override
    public void deleteByCondition(Map filter) {

    }

    @Override
    public List queryDataByCondition(Map filter, Set sorted, SpecPaginationContext spc) {
        return null;
    }

    @Override
    public List queryDataByCondition(Map filter, Set sorted) {
        return null;
    }

    @Override
    public TableDataVo query(TableQueryVo queryParam) {
        TableDataVo dataTable = new TableDataVo();
        dataTable.setsEcho(queryParam.getSEcho());
        Query query = MysqlHibernateDao.currentSession().createQuery("from " + this.cls.getSimpleName());
        query.setFirstResult(queryParam.getIDisplayStart());
        query.setMaxResults(queryParam.getIDisplayLength());
        dataTable.setAaData(query.list());
        MysqlHibernateDao.closeSession();
        return dataTable;
    }

    @Override
    public long getCount(TableQueryVo queryParam) {
        Query query = MysqlHibernateDao.currentSession().createQuery("select count(*) from " + this.cls.getSimpleName());
        long result = ((Long) query.uniqueResult()).longValue();
        MysqlHibernateDao.closeSession();
        return result;
    }
}
