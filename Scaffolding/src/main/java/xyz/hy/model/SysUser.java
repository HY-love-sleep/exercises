package xyz.hy.model;

import java.io.Serializable;
import java.util.Date;

public class SysUser implements Serializable {
    /**
     * 用户ID
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 部门ID
     *
     * @mbggenerated
     */
    private Long deptId;

    /**
     * 登录账号
     *
     * @mbggenerated
     */
    private String loginName;

    /**
     * 用户昵称
     *
     * @mbggenerated
     */
    private String userName;

    /**
     * 用户类型（00系统用户 01注册用户）
     *
     * @mbggenerated
     */
    private String userType;

    /**
     * 用户邮箱
     *
     * @mbggenerated
     */
    private String email;

    /**
     * 手机号码
     *
     * @mbggenerated
     */
    private String phonenumber;

    /**
     * 用户性别（0男 1女 2未知）
     *
     * @mbggenerated
     */
    private String sex;

    /**
     * 头像路径
     *
     * @mbggenerated
     */
    private String avatar;

    /**
     * 密码
     *
     * @mbggenerated
     */
    private String password;

    /**
     * 盐加密
     *
     * @mbggenerated
     */
    private String salt;

    /**
     * 帐号状态（0正常 1停用）
     *
     * @mbggenerated
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     *
     * @mbggenerated
     */
    private String delFlag;

    /**
     * 最后登录IP
     *
     * @mbggenerated
     */
    private String loginIp;

    /**
     * 最后登录时间
     *
     * @mbggenerated
     */
    private Date loginDate;

    /**
     * 密码最后更新时间
     *
     * @mbggenerated
     */
    private Date pwdUpdateDate;

    /**
     * 创建者
     *
     * @mbggenerated
     */
    private String createBy;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新者
     *
     * @mbggenerated
     */
    private String updateBy;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getPwdUpdateDate() {
        return pwdUpdateDate;
    }

    public void setPwdUpdateDate(Date pwdUpdateDate) {
        this.pwdUpdateDate = pwdUpdateDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", deptId=").append(deptId);
        sb.append(", loginName=").append(loginName);
        sb.append(", userName=").append(userName);
        sb.append(", userType=").append(userType);
        sb.append(", email=").append(email);
        sb.append(", phonenumber=").append(phonenumber);
        sb.append(", sex=").append(sex);
        sb.append(", avatar=").append(avatar);
        sb.append(", password=").append(password);
        sb.append(", salt=").append(salt);
        sb.append(", status=").append(status);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", loginIp=").append(loginIp);
        sb.append(", loginDate=").append(loginDate);
        sb.append(", pwdUpdateDate=").append(pwdUpdateDate);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}