public class User {
    private String username;
    private String password;
    String[][] accounts = {{"Test","1234"}};

    public void user(String username, String password){
        this.username = username;
        this.password = password;
    }

    public boolean passwordCheck(){
        if(username.equals(accounts[0][0]) && password.equals(accounts[0][1]))
            return true;
        else
            return false;
    }
}
