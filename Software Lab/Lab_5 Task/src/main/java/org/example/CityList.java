package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represents a list of City objects.
 * It provides methods to add, delete, count and get a sorted list of cities.
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city The city to be added.
     * @throws IllegalArgumentException If the city already exists in the list.
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return A sorted list of cities.
     */
    public List<City> getCities() {
        List<City> cityList = cities;
        Collections.sort(cityList);
        return cityList;
    }

    /**
     * Deletes a city from the list.
     * @param city The city to be deleted.
     * @throws IllegalArgumentException If the city does not exist in the list.
     */
    public void delete(City city)
    {
        int flag=0;
        for (City cc:

                cities ) {
            if(cc==city){
                cities.remove(city) ;  flag=1;break;
            }

        }
        if(flag==0)throw new IllegalArgumentException();
    }
    /**
     * Returns the count of cities in the list.
     * @return The count of cities.
     */
    public int Count()
    {
        return cities.size();
    }

}