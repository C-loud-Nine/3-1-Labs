package org.example;

/**
 * This class represents a City with its name and province.
 * It implements Comparable interface to compare cities based on their names.
 */
public class City implements Comparable<City>{
    private String city;
    private String province;

    /**
     * Constructor to initialize a city with its name and province.
     * @param city The name of the city.
     * @param province The province where the city is located.
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Getter for the city name.
     * @return The name of the city.
     */
    String getCityName(){
        return this.city;
    }

    /**
     * Getter for the province name.
     * @return The name of the province.
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Compares this city with the specified city for order.
     * Returns a negative integer, zero, or a positive integer as this city is less than, equal to, or greater than the specified city.
     * @param city The city to be compared.
     * @return A negative integer, zero, or a positive integer as this city is less than, equal to, or greater than the specified city.
     */
    @Override
    public int compareTo(City city) {
        return this.city.compareTo(city.getCityName());
    }
}
