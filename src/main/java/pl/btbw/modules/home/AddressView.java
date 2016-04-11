package pl.btbw.modules.home;

public class AddressView {

    public String city;
    public String country;
    public String zipCode;
    public int number;

    public AddressView(String city) {
        this.city = city;
    }

    public AddressView(String city, String country, String zipCode, int number) {
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
        this.number = number;
    }
}
