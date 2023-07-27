public class Employee {
    private final int id;
    private final String name;
    private final String email;
    private final String address;
    Employee(){
        this.id = 0;
        this.name = this.email = this.address = "";
    }

    Employee(int id, String name, String email, String address){
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }


}
