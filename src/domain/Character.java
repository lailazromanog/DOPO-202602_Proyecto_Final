package domain;

public class Character {
    private String name;
    private String country;
    private Power power;
    private Appereance appereance;

    public Character(String name, String country, Power power, Appereance appereance) {
        this.name = name;
        this.country = country;
        this.power = power;
        this.appereance = new Appereance();
    }
    
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Power getPower() {
        return power;
    }

    public Appereance getAppereance() {
        return appereance;
    }
}
