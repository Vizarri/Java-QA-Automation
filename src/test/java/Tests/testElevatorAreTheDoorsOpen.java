package Tests;

import elevator.ElevatorFloors;
import models.Elevator.Elevator;
import org.junit.Assert;
import org.junit.Test;

public class testElevatorAreTheDoorsOpen {
    @Test
    public void testElevatorAreTheDoorsOpen() {
        ElevatorFloors elevatorFloors = new ElevatorFloors(-1, 5);
        Elevator elevator = new Elevator(1, elevatorFloors, true);
        elevator.moveElevatorToTheFloor(3);
        int expectedResult = 1;
        int actualResult = elevator.getCurrentFloor();
        Assert.assertEquals("Лифт едет с открытой дверью", expectedResult, actualResult);
    }
}
