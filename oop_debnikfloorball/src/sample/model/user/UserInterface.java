package sample.model.user;

public interface UserInterface {
    int getID();
    void setID(int ID);
    String getUsername();
    void setUsername(String username);
    String getPassword();
    void setPassword(String password);
    String getName();
    void setName(String name);
    String getSurname();
    void setSurname(String surname);
    int verify(String password);
}
