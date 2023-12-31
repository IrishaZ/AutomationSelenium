package helper;
import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "createSP_OneRule")
    public Object[][] provideData() {
        return new Object[][]{
//       {"Album", "is", "Unknown Album", "SELECT * FROM songs s JOIN albums a ON s.album_id =a.id WHERE a.name=\"Unknown Album\""},
           {"Album", "contains", "Unknown", "SELECT * FROM songs s JOIN albums a ON s.album_id =a.id WHERE a.name LIKE \"%Unknown%\""},
           {"Album", "is not", "Unknown Album", "SELECT * FROM songs s JOIN albums a ON s.album_id =a.id WHERE a.name!=\"Unknown Album\""},
           {"Album", "does not contain","Album","SELECT * FROM songs s JOIN albums a ON s.album_id =a.id WHERE a.name NOT LIKE(\"%Album%\")"},
           {"Album", "begins with", "m", "SELECT * FROM songs s JOIN albums a ON s.album_id =a.id WHERE a.name LIKE(\"m%\")"},
           {"Album", "ends with", "m", "SELECT * FROM songs s JOIN albums a ON s.album_id =a.id WHERE a.name LIKE(\"%m\")"},
//      {"Title", "is", "Reactor","SELECT * from dbkoel.songs s WHERE s.title=\"Reactor\""},
           {"Title", "contains", "Take","SELECT * from dbkoel.songs s WHERE s.title LIKE \"%Take%\""},
           {"Title", "is not", "Reactor","SELECT * from dbkoel.songs s WHERE s.title!=\"Reactor\""},
           {"Title", "does not contain", "pluto","SELECT * from dbkoel.songs s WHERE s.title NOT LIKE(\"%pluto%\")"},
           {"Title", "begins with", "t","SELECT * from dbkoel.songs s WHERE s.title LIKE (\"t%\")"},
           {"Title", "ends with", "t","SELECT * from dbkoel.songs s WHERE s.title LIKE (\"%t\")"}
        };
    }
    @DataProvider(name = "createSP_OneRule_DefaultValues")
    public Object[][] provideDataDefault() {
        return new Object[][]{
                {"Pluto", "SELECT * FROM dbkoel.songs s WHERE s.title=\"Pluto\""},
        };

    }
    @DataProvider(name = "invalidCredentialsFrontEnd")
    public Object[][] invalidCredentialsFrontEnd() {
        return new Object[][]{
//                {"irina.zhukova@testpro.io", "te$t$tudent84"},
                {"", "te$t$tudent84"},
                {"irina.zhukova@testpro.","te$t$tudent84"},
                {"irina.zhukovatestproio", "te$t$tudent84"},
                {"irina.zhukova@testpro.io", ""}
        };
    }
        @DataProvider(name = "invalidCredentialsBackEnd")
        public Object[][] invalidCredentialsBackEnd() {
            return new Object[][]{
//                {"irina.zhukova@testpro.io", "te$t$tudent84"},
                    {"irina.zhukova@testproio","te$t$tudent84"},
                    {"irina.zhukova@testpro.io","password"},
            };
    }

}
