package BJSSAPI.resources;

public class resources {

    public static String getSingleUserData(){
        String res = "/api/users/2";
        return res;
    }

    public static String postCreateUser(){
        String res = "/api/users";
        return res;
    }

    public static String putUpdateUser(){
        String res = "/api/users/2";
        return res;
    }

    public static String patchUpdateUser(){
        String res = "/api/users/2";
        return res;
    }

    public static String deleteUser(){
        String res = "/api/users/3";
        return res;
    }
}
