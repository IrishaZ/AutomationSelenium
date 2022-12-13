package untiTesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import tickets.PlaneTickets;

public class UnitTest {
    @Test
    public void ticket_infant_freeTicket(){
        // Arrange
        PlaneTickets infant = new PlaneTickets(1,1000);

        // Act
        double actualResult = infant.calculate();

        // Assert
        Assert.assertEquals(actualResult,0.0);
    }
    @Test
    public void ticket_child_halfPrice(){
        PlaneTickets child = new PlaneTickets(8,1000);
        double actualResult = child.calculate();
        Assert.assertEquals(actualResult,500.0);
    }

    @Test
    public void ticket_adult_fullPrice(){
        PlaneTickets adult = new PlaneTickets(50,1000);
        double actualResult = adult.calculate();
        Assert.assertEquals(actualResult,1000.0);
    }

    @Test
    public void ticket_senior_80percent(){
        PlaneTickets senior = new PlaneTickets(70,1000);
        double actualResult = senior.calculate();
        Assert.assertEquals(actualResult,800.0);
    }
}
