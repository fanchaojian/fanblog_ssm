package com.fanchaojian.pojo;

/**
 * @author fanchaojian
 * @date 2021-4-19 - 15:37
 */
public class BlogAdmin {
    private Integer adminId;         /*主键 id*/
    private String username ;       /*用户名*/
    private String password ;       /*密码*/
    private String name ;           /*昵称*/
    private String job ;            /*职业*/
    private String email ;          /*邮箱*/
    private String place  ;          /*籍贯*/
    private String hobby ;          /*爱好*/
    private String motto ;          /*格言*/
    private String introUrl ;       /*简介地址*/
    private String gender ;         /*性别*/
    private String iconUrl ;        /*头像地址*/
    private String qqQrcode ;       /*QQ二维码*/
    private String wechatQrcode ;   /*微信二维码*/
    private String weboQrcode ;     /*微博二维码*/
    private String gghQrcode ;      /*公众号二维码*/
    private String githubUrl ;      /*github地址*/
    private Integer preOrder ; /*用于排序，用于随意切换网站所有*/

    private SiteInfo siteInfo;  /*管理员用户与站点信息是一对一的关系*/

    public BlogAdmin() {
    }

    public BlogAdmin(Integer adminId, String username, String password, String name, String job, String email, String place, String hobby, String motto, String introUrl, String gender, String iconUrl, String qqQrcode, String wechatQrcode, String weboQrcode, String gghQrcode, String githubUrl, Integer preOrder, SiteInfo siteInfo) {
        this.adminId = adminId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.job = job;
        this.email = email;
        this.place = place;
        this.hobby = hobby;
        this.motto = motto;
        this.introUrl = introUrl;
        this.gender = gender;
        this.iconUrl = iconUrl;
        this.qqQrcode = qqQrcode;
        this.wechatQrcode = wechatQrcode;
        this.weboQrcode = weboQrcode;
        this.gghQrcode = gghQrcode;
        this.githubUrl = githubUrl;
        this.preOrder = preOrder;
        this.siteInfo = siteInfo;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getIntroUrl() {
        return introUrl;
    }

    public void setIntroUrl(String introUrl) {
        this.introUrl = introUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getQqQrcode() {
        return qqQrcode;
    }

    public void setQqQrcode(String qqQrcode) {
        this.qqQrcode = qqQrcode;
    }

    public String getWechatQrcode() {
        return wechatQrcode;
    }

    public void setWechatQrcode(String wechatQrcode) {
        this.wechatQrcode = wechatQrcode;
    }

    public String getWeboQrcode() {
        return weboQrcode;
    }

    public void setWeboQrcode(String weboQrcode) {
        this.weboQrcode = weboQrcode;
    }

    public String getGghQrcode() {
        return gghQrcode;
    }

    public void setGghQrcode(String gghQrcode) {
        this.gghQrcode = gghQrcode;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public Integer getPreOrder() {
        return preOrder;
    }

    public void setPreOrder(Integer preOrder) {
        this.preOrder = preOrder;
    }

    public SiteInfo getSiteInfo() {
        return siteInfo;
    }

    public void setSiteInfo(SiteInfo siteInfo) {
        this.siteInfo = siteInfo;
    }

    @Override
    public String toString() {
        return "BlogAdmin{" +
                "adminId=" + adminId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", email='" + email + '\'' +
                ", place='" + place + '\'' +
                ", hobby='" + hobby + '\'' +
                ", motto='" + motto + '\'' +
                ", introUrl='" + introUrl + '\'' +
                ", gender='" + gender + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", qqQrcode='" + qqQrcode + '\'' +
                ", wechatQrcode='" + wechatQrcode + '\'' +
                ", weboQrcode='" + weboQrcode + '\'' +
                ", gghQrcode='" + gghQrcode + '\'' +
                ", githubUrl='" + githubUrl + '\'' +
                ", preOrder=" + preOrder +
                ", siteInfo=" + siteInfo +
                '}';
    }
}
