
package org.firstinspires.ftc.teamcode.teamcode.turret;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Turret
{

    DcMotor turretMotor;
    public State state;
    public enum State
    {
        IDLE, MOVING
    }

    public Turret(HardwareMap hardwareMap)
    {
        turretMotor = hardwareMap.get(DcMotor.class, "hturret");
        setState(State.IDLE);
    }

    public void update()
    {
        switch(state)
        {
            case MOVING:

            case IDLE:


        }
    }

    public State getState() {
        return this.state;
    }


    public void setState(State state)
    {
        this.state = state;
        update();
    }


}
