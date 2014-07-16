package bl.beans;

public class IpTagBean extends Bean {
    private Integer tag;
    private String ip;
    private Integer subnet;
    private String comments;

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getSubnet() {
        return subnet;
    }

    public void setSubnet(Integer subnet) {
        this.subnet = subnet;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
