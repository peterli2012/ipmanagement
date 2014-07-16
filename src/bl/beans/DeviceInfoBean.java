package bl.beans;

public class DeviceInfoBean extends Bean {
    private int devtype;
    private int devmodel;
    private int poolid;
    private int rack;
    private int slot;
    private int userid;
    private int project;
    private String comments;
    
    public int getDevtype() {
        return devtype;
    }

    public void setDevtype(int devtype) {
        this.devtype = devtype;
    }

    public int getDevmodel() {
        return devmodel;
    }

    public void setDevmodel(int devmodel) {
        this.devmodel = devmodel;
    }

    public int getPoolid() {
        return poolid;
    }

    public void setPoolid(int poolid) {
        this.poolid = poolid;
    }

    public int getRack() {
        return rack;
    }

    public void setRack(int rack) {
        this.rack = rack;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
