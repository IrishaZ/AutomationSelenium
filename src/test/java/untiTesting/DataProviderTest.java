package untiTesting;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tickets.PlaneTickets;

public class DataProviderTest {
    @DataProvider(name = "Tickets")
    public Object[][] getData(){
        return new Object[][]{
                {1,0.0},
                {2,0.0},
                {3,500.0},
                {10,500.0},
                {12,500.0},
                {13,1000.0},
                {25,1000.0},
                {65,1000.0},
                {66,800.0},
                {70,800.0}
        };

    }
    @Test(dataProvider = "Tickets")
    public void ticket_infant_freeTicket(int age, double expectedPrice){
        PlaneTickets passenger = new PlaneTickets(age,1000);
        double actualResult = passenger.calculate();
        Assert.assertEquals(actualResult,expectedPrice);
    }
}
