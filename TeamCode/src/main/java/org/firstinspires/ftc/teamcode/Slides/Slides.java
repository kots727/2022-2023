package org.firstinspires.ftc.teamcode.Slides;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Slides {
    DcMotorEx slidesLeft;
    DcMotorEx slidesRight;

    //slides is 17.5 inches tall
    static final double HIGH = 932.885; //in inches, 33.5 - 17.5 (high junction height - slides height)
    static final double MID = 498.985; //in inches, 23.5 - 17.5 (mid junction height - slides height)
    static final double LOW = 65.085; //in inches, low junction is 13.5 inches

    public Slides.State state;
    public enum State{
        HIGH, MID, LOW, BOTTOM
    }
    public Slides(HardwareMap hardwareMap) {
        slidesLeft = hardwareMap.get(DcMotorEx.class, "s1");
        slidesRight = hardwareMap.get(DcMotorEx.class, "s2");
        slidesLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        slidesRight.setDirection(DcMotorSimple.Direction.REVERSE);
       slidesRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slidesLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slidesRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slidesLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
     //   setState(State.BOTTOM);
    }

    public void update(){
        switch(state) {
            case HIGH:
                slidesLeft.setTargetPosition((int) HIGH);
                slidesRight.setTargetPosition((int) HIGH);
                slidesRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                slidesLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                slidesLeft.setPower(1);
                slidesRight.setPower(1);
            case MID:
                slidesLeft.setTargetPosition((int) MID);
                slidesRight.setTargetPosition((int) MID);
                slidesRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                slidesLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                slidesLeft.setPower(1);
                slidesRight.setPower(1);
            case LOW:
                slidesLeft.setTargetPosition((int) LOW);
                slidesRight.setTargetPosition((int) LOW);
                slidesRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                slidesLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                slidesLeft.setPower(1);
                slidesRight.setPower(1);
            case BOTTOM:

                slidesLeft.setTargetPosition((int) 0);
                slidesRight.setTargetPosition((int) 0);
                slidesRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                slidesLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                slidesLeft.setPower(-1);
                slidesRight.setPower(-1);
        }
    }

    public Slides.State getState() {
        return state;
    }
    public void setState(Slides.State state){
        this.state = state;
        update();

    }
    public void up(){

    }
    public void mid(){

    }
    public void low(){

    }
    public void down(){
    }
    public void stop(){
    }
    public double lpos(){
        return slidesLeft.getCurrentPosition();
    }
    public double rpos(){
        return slidesRight.getCurrentPosition();
    }
    public double ltarg(){
        return slidesLeft.getTargetPosition();
    }
    public double rtarg(){
        return slidesRight.getTargetPosition();
    }

}
