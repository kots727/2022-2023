
package org.firstinspires.ftc.teamcode.turret;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Turret
{

    DcMotor turretMotor;
    public Turret.State state;
    public enum State
    {
        IDLE, MOVING
    }

    public Turret(HardwareMap hardwareMap)
    {
        turretMotor = hardwareMap.get(DcMotor.class, "hturret");
        turretMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        turretMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void update()
    {
        switch(state)
        {
            case MOVING:

            case IDLE:
                turretMotor.setTargetPosition(0);
                turretMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        }
    }

    public Turret.State getState() {
        return this.state;
    }
    public double rpos(){
        return turretMotor.getCurrentPosition();
    }
    public double ltarg(){
        return turretMotor.getTargetPosition();
    }
public void zero(){
    turretMotor.setTargetPosition(0);
    turretMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    turretMotor.setPower(1);
}
    public void setState(Turret.State state)
    {
        this.state = state;
        update();
    }


}
