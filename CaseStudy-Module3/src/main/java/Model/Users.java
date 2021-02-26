package Model;

public class Users {
    private int id;
    private String userName;
    private String passwordUser;
    private String fullName;
    private int statusUser;
    private boolean is_delete;

    public Users(int id, String userName, String fullName, int status, boolean is_delete) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.statusUser = status;
        this.is_delete = is_delete;
    }
    public Users(int id,String userName, String fullName, int status) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.statusUser = status;
    }

    public Users(int id, String userName, String fullName) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getStatusUser() {
        return statusUser;
    }

    public void setStatusUser(int statusUser) {
        this.statusUser = statusUser;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }
}
