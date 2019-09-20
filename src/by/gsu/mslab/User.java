package by.gsu.mslab;

import java.io.Serializable;

public class User implements java.lang.Comparable<User> , Serializable {
    private String nickname;
    private String login;
    private String password;
    private String sex;
    private String lastVisit;
    private int commentsNum;

    public User(){
    }

    public User(String nickname, String login, String password,
                String sex, String lastVisit,int commentsNum){
        this.nickname = nickname;
        this.login = login;
        this.password = password;
        this.sex = sex;
        this.lastVisit = lastVisit;
        this.commentsNum = commentsNum;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(String lastVisit) {
        this.lastVisit = lastVisit;
    }

    public int getCommentsNum() {
        return commentsNum;
    }

    public void setCommentsNum(int commentsNum) {
        this.commentsNum = commentsNum;
    }

    @Override
    public String toString(){
        return nickname + ";" + login + ";" +
                password + ";" + sex + ";" +
                lastVisit + ";" + commentsNum;
    }
    @Override
    public int compareTo(User user) {
        int lenth = 0;
        if(this.nickname.length()>user.nickname.length()){
            lenth = user.nickname.length();
        }else{
            lenth = this.nickname.length();
        }
        if (this.nickname.charAt(0) != user.nickname.charAt(0)){
            return this.nickname.charAt(0) - user.nickname.charAt(0);
        }else{
            return this.nickname.charAt(1) - user.nickname.charAt(1);
        }
    }
}
