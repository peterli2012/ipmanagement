/**
 * 
 */
package actions;

import java.util.List;

import bl.beans.UserBean;
import bl.beans.UserGroupBean;
import bl.mysqlbus.UserBusiness;
import bl.mysqlbus.UserGroupBusiness;

import com.opensymphony.xwork2.ActionContext;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vo.table.TableHeaderVo;
import vo.table.TableInitVo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pli
 * @since $Date:2014-07-15$
 */
public class UserGroupAction extends BaseTableAction<UserGroupBusiness> {
    private static Logger log = LoggerFactory.getLogger(UserGroupAction.class);
    private UserGroupBean userGroup;

    public UserGroupBean getUser() {
        return userGroup;
    }

    public void setUser(UserGroupBean UserGroup) {
        this.userGroup = userGroup;
    }

    /**
   * 
   */
    private static final long serialVersionUID = -5222876000116738224L;

    @Override
    public TableInitVo getTableInit() {
        TableInitVo init = new TableInitVo();
        init.getAoColumns().add(new TableHeaderVo("name", "Group Name").enableSearch());
        return init;
    }

    @Override
    public String save() throws Exception {
        if (userGroup.getId() == 0) {
            getBusiness().createLeaf(userGroup);
        } else {
            UserGroupBean origUser = (UserGroupBean) getBusiness().getLeaf(String.valueOf(userGroup.getId())).getResponseData();
            BeanUtils.copyProperties(origUser, userGroup);
            getBusiness().updateLeaf(origUser, origUser);
        }
        return SUCCESS;
    }

    @Override
    public String edit() throws Exception {
        userGroup = (UserGroupBean) getBusiness().getLeaf(getId()).getResponseData();
        return SUCCESS;
    }

    @Override
    public String delete() throws Exception {
        if (getIds() != null) {
            for (String id : getIds()) {
                getBusiness().deleteLeaf(id);
            }
        }
        return SUCCESS;
    }

    @Override
    public String getActionPrex() {
        return getRequest().getContextPath() + "/usergroup";
    }
}
