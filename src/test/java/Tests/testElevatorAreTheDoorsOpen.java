package Tests;

import elevator.ElevatorFloors;
import models.Elevator.Elevator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class testElevatorAreTheDoorsOpen {
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void testElevatorAreTheDoorsOpen(boolean doorstatus) {
        ElevatorFloors elevatorFloors = new ElevatorFloors(-1, 5);
        Elevator elevator = new Elevator(1, elevatorFloors, doorstatus);
        elevator.moveElevatorToTheFloor(3);
        int expectedResult = 1;
        int actualResult = elevator.getCurrentFloor();
        Assert.assertEquals("Лифт едет с открытой дверью", expectedResult, actualResult);
    }
}
