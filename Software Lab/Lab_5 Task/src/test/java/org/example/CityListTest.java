package org.example;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Test.*;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    City city = new City("Dhaka","Bangladesh");
    City city2 = new City("Khulna","Bangladesh");
    City city3 = new City("Tangail","Bangladesh");

    @Test
    public void testcount()
    {
        CityList cl = new CityList();
        cl.add(city);
        cl.add(city2);
        assertEquals(2,cl.Count());
    }


    @Test
    public void testdelete()
    {
        CityList cl = new CityList();
        cl.add(city);
        cl.add(city2);
        cl.add(city3);

        cl.delete(city2);
        assertEquals(2,cl.Count());

    }

    @Test
    public void testdeleteexception()
    {
        CityList cl = new CityList();
        cl.add(city);
        assertThrows(IllegalArgumentException.class,() -> {
            cl.delete(city3);
        });

    }


    @Test
    public void testsort()
    {
        CityList cl = new CityList();
        cl.add(city3);
        cl.add(city);
        cl.add(city2);

        List<City> sortedCities = cl.getCities();

        for (int i = 0; i < sortedCities.size() - 1; i++) {
            assertTrue(sortedCities.get(i).compareTo(sortedCities.get(i + 1)) <= 0);
        }
    }

}