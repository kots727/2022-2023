package org.firstinspires.ftc.teamcode.Slides;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(group = "slides")
public class TestSlides extends LinearOpMode {
    Slides slide;
    @Override
    public void runOpMode() throws InterruptedException {

        slide = new Slides(hardwareMap);

        waitForStart();

        slide.update();


    }
}
