/**
 *
 */
package bl.mysqlbus;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bl.beans.UserBean;
import bl.beans.UserGroupBean;
import bl.common.BeanContext;
import dao.MysqlHibernateDao;

/**
 * @author pli
 * @since $Date:2014-07-16$
 */
public class UserBusiness extends MysqlBusiness<BeanContext, UserBean> {
    private static Logger log = LoggerFactory.getLogger(UserBusiness.class);

    public UserBusiness() {
        this.cls = UserBean.class;
    }

    public List<UserGroupBean> getUserGroupBeans() {
        Query query = MysqlHibernateDao.currentSession().createQuery("from " + UserGroupBean.class.getSimpleName());
        List<UserGroupBean> list = query.list();
        MysqlHibernateDao.closeSession();
        return list;
    }
}
