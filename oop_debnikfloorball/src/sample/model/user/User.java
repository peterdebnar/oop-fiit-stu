package sample.model.user;

import sample.database.UserDatabase;

public abstract class User implements UserInterface{
    UserDatabase userDatabase;
    protected int ID;
    protected static int nextID = 1000;
    protected String username;
    protected String password;
    protected String name;
    protected String surname;

    public int getID(){
        return this.ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return this.surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public int verify(String password){
        if(this.password.equals(password)){
            return 1;
        }
        return 0;
    }
}
