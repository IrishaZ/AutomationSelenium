package testData;

import com.github.javafaker.Faker;
import enums.FirstDropdown;
import enums.SecondDropdown;
import org.testng.annotations.DataProvider;

public class TestData {
//    private Faker faker;
//
//    public TestData(Faker faker) {
//        this.faker = faker;
//    }

    @DataProvider(name = "createSP_OneRule")
    public Object[][] provideData() {
        return new Object[][]{
//      skip {"Album", "is", "Unknown Album", "SELECT * FROM songs s JOIN albums a ON s.album_id =a.id WHERE a.name=\"Unknown Album\""},
           {"Album", "contains", "Unknown", "SELECT * FROM songs s JOIN albums a ON s.album_id =a.id WHERE a.name LIKE \"%Unknown%\""},
           {"Album", "is not", "Unknown Album", "SELECT * FROM songs s JOIN albums a ON s.album_id =a.id WHERE a.name!=\"Unknown Album\""},
           {"Album", "does not contain","Album","SELECT * FROM songs s JOIN albums a ON s.album_id =a.id WHERE a.name NOT LIKE(\"%Album%\")"},
           {"Album", "begins with", "m", "SELECT * FROM songs s JOIN albums a ON s.album_id =a.id WHERE a.name LIKE(\"m%\")"},
           {"Album", "ends with", "m", "SELECT * FROM songs s JOIN albums a ON s.album_id =a.id WHERE a.name LIKE(\"%m\")"},
////      skip {"Title", "is", "Reactor","SELECT * from dbkoel.songs s WHERE s.title=\"Reactor\""},
           {"Title", "contains", "Take","SELECT * from dbkoel.songs s WHERE s.title LIKE \"%Take%\""},
           {"Title", "is not", "Reactor","SELECT * from dbkoel.songs s WHERE s.title!=\"Reactor\""},
           {"Title", "does not contain", "pluto","SELECT * from dbkoel.songs s WHERE s.title NOT LIKE(\"%pluto%\")"},
           {"Title", "begins with", "t","SELECT * from dbkoel.songs s WHERE s.title LIKE (\"t%\")"},
           {"Title", "ends with", "t","SELECT * from dbkoel.songs s WHERE s.title LIKE (\"%t\")"},

        };
    }
    @DataProvider(name = "createSP_OneRule_DefaultValues")
    public Object[][] provideDataDefault() {
        return new Object[][]{
                {"Pluto", "SELECT * FROM dbkoel.songs s WHERE s.title=\"Pluto\""},
        };

    }
}
