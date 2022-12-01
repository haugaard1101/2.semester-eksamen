package com.example.bilabonnement.Model;

public class UserModel {

  private int userId;
  private String userName;
  private String userPassword;

  public UserModel(int userId, String userName, String userPassword) {
    this.userId = userId;
    this.userName = userName;
    this.userPassword = userPassword;
  }

  public UserModel() {

  }

  public UserModel(String userName,String userPassword){
    this.userName = userName;
    this.userPassword = userPassword;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  @Override
  public String toString() {
    return "UserModel{" +
        "userId=" + userId +
        ", userName='" + userName + '\'' +
        ", password='" + userPassword + '\'' +
        '}';
  }
}
