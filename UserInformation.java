package co.shrey.fireapp;

/**
 * Created by shrey on 01-06-2018.
 */

public class UserInformation {
    private String name;
    private String address;
    private String age;

    public UserInformation() {

    }

    public UserInformation(String name, String address, String age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
