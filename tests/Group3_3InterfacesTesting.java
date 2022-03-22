package tests;

import vehicle.FordFrivolous;
import bcatest.BCATestScenario;
public class Group3_3InterfacesTesting extends BCATestScenario {
    public int runTest() {
        FordFrivolous f = new FordFrivolous();
        
        assertThrows(IllegalArgumentException.class, () -> {f.driveAutonomously(-1);}, "Cannot drive a negative amount.");

        assertEquals(f.getMileage(), 0, .1, "Get mileage should be 0");

        f.driveAutonomously(30);
        
        assertEquals(f.getMileage(), 30, .1, "Get mileage should be 60");
        
        assertEquals(f.getFuelLevel(), 17.458, .1, "Get mileage should be 17.458");
        
        assertEquals(f.getRemainingRange(), 412, .1, "Get remaining range should be 442");

        assertThrows(IllegalArgumentException.class, () -> {f.driveAutonomously(413);}, "Car should not be able to drive 413 miles.");

        assertTrue(f.canFly(137), "Car should be able to fly 137 miles");
        
        assertFalse(f.canFly(138), "Car should not be able to fly 138 miles.");
        
        assertFalse(f.canFly(139), "Car should not be able to fly 139 miles.");
        
        assertThrows(IllegalArgumentException.class, () -> {f.canFly(-1);}, "Car should not be able to fly -1 miles.");

        f.fly(30);
        
        assertEquals(f.getFuelLevel(), 13.644, .1, "Get fuel level should be 13.644");
        
        assertEquals(f.getRemainingRange(), 322, .1, "Get remaining range should be 322");

        assertFalse(f.canFly(108), "Car should not be able to fly 108 miles");
        
        f.fly(107.3);
        
        assertEquals(f.getRemainingRange(), 0, .11, "Remaining range should be 0");
        
        assertEquals(f.getFuelLevel(), 0, .11, "Fuel level should be 0");

        return getFailedCount();
    }
}
