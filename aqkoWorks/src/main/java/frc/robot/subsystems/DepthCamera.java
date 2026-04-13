package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DepthCamera extends SubsystemBase {

    public DepthCamera() {
        // Инициализация камеры
        initCamera();
    }

    /**
     * Инициализация USB-камеры и настройка видеопотока.
     */
    private void initCamera() {
        // Настройка камеры через CameraServer
        // Индекс 0 — первая камера, если у тебя их несколько, можешь изменить индекс
        var camera = CameraServer.getInstance().startAutomaticCapture(0); 
        
        // Устанавливаем разрешение камеры
        camera.setResolution(640, 480);
        // Устанавливаем частоту кадров
        camera.setFPS(30);

        // Начинаем поток с камеры
        CameraServer.getInstance().startAutomaticCapture(camera);
    }

    @Override
    public void periodic() {
        // Выводим на SmartDashboard статус камеры
        SmartDashboard.putString("Camera Status", "Camera is active and streaming.");
    }
}
