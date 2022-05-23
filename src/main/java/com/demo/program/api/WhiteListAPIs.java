package com.demo.program.api;

import java.util.ArrayList;
import java.util.List;

public class WhiteListAPIs {

    public static void main(String[] args) {

        String adminLogin = "/user/auth/admin/login";
        System.out.println("Admin is whitelisted: " + isWhitelistedApi(adminLogin));

        String userLogin = "/user/auth/user/login";
        System.out.println("User is whitelisted: " + isWhitelistedApi(userLogin));

        String blogIdApi = "/blog/100";
        System.out.println("Blog with Id whitelisted: " + isWhitelistedApi(blogIdApi));

        String commentIdApi = "/blog/comments/555";
        System.out.println("Comment with Id is whitelisted: " + isWhitelistedApi(commentIdApi));

        String userIdApi = "/user/123";
        System.out.println("User with Id is whitelisted: " + isWhitelistedApi(userIdApi));

    }


    private static final List<String> WHITELISTED_APIS = new ArrayList<String>() {
        {
            this.add("/user/auth/admin/login");
            this.add("/user/auth/user/login");
            this.add("/blog/comments");
            this.add("/blog/comments/{id}");
            this.add("/blog/{id}");
        }
    };


    public static boolean isWhitelistedApi(String uri) {

        String[] uriParts = uri.split("/");
        for (String whiteListedApis : WHITELISTED_APIS) {
            String[] whiteListedParts = whiteListedApis.split("/");

            if (uriParts.length != whiteListedParts.length)
                continue;

            for (int i = 1; i < uriParts.length; i++) {
                if (i == uriParts.length - 1) {
                    if ((whiteListedParts[i].startsWith("{") && whiteListedParts[i].endsWith("}"))
                            || whiteListedParts[i].equals(uriParts[i])) {
                        return true;
                    } else {
                        break;
                    }
                } else if (whiteListedParts[i].startsWith("{") && whiteListedParts[i].endsWith("}")) {
                    continue;
                } else if (!whiteListedParts[i].equals(uriParts[i])) {
                    break;
                }
            }
        }
        return false;
    }
}



//        ---------------------------------------------------------------
//        Output
//        ---------------------------------------------------------------
//        Admin is whitelisted: true
//        User is whitelisted: true
//        Blog with Id whitelisted: true
//        Comment with Id is whitelisted: true
//        Comment with Id is whitelisted: false