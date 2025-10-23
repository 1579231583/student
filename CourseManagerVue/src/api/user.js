import { post, pureGet } from "../common/ajax";
//axios get post put delete 
export const login = (username, password, userType) =>
  post("/user/login", {
    username: username,
    password: password,
    userType: userType
  });


 //"/user/" 
export const getLoginStatus = () => pureGet("/user/login/status");

export const logout = () => pureGet("/user/logout");
