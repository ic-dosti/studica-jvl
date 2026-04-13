package frc.robot.subsystems;

import com.studica.frc.Lidar;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LidarTest extends SubsystemBase {
    // Lidar Library
    private Lidar lidar;

    // Lidar Scan Data Storage class
    private Lidar.ScanData scanData;

    // Shuffleboard Tab for Lidar
    private final ShuffleboardTab lidarTab;

    // Data entries on Shuffleboard for multiple angles
    private final NetworkTableEntry angleEntry0;
    private final NetworkTableEntry distanceEntry0;

    private final NetworkTableEntry angleEntry45;
    private final NetworkTableEntry distanceEntry45;

    private final NetworkTableEntry angleEntry90;
    private final NetworkTableEntry distanceEntry90;

    private final NetworkTableEntry angleEntry135;
    private final NetworkTableEntry distanceEntry135;

    private final NetworkTableEntry angleEntry180;
    private final NetworkTableEntry distanceEntry180;

    private final NetworkTableEntry angleEntry225;
    private final NetworkTableEntry distanceEntry225;

    private final NetworkTableEntry angleEntry270;
    private final NetworkTableEntry distanceEntry270;

    private final NetworkTableEntry angleEntry315;
    private final NetworkTableEntry distanceEntry315;

    public LidarTest() {
        // Инициализация лидара
        lidar = new Lidar(Lidar.Port.kUSB2);

        // Создаем вкладку для отображения данных на Shuffleboard
        lidarTab = Shuffleboard.getTab("Lidar Data");

        // Добавляем данные на Shuffleboard для каждого из углов
        angleEntry0 = lidarTab.add("Angle at 0°", 0.0).getEntry();
        distanceEntry0 = lidarTab.add("Distance at 0° (mm)", 0.0).getEntry();

        angleEntry45 = lidarTab.add("Angle at 45°", 0.0).getEntry();
        distanceEntry45 = lidarTab.add("Distance at 45° (mm)", 0.0).getEntry();

        angleEntry90 = lidarTab.add("Angle at 90°", 0.0).getEntry();
        distanceEntry90 = lidarTab.add("Distance at 90° (mm)", 0.0).getEntry();

        angleEntry135 = lidarTab.add("Angle at 135°", 0.0).getEntry();
        distanceEntry135 = lidarTab.add("Distance at 135° (mm)", 0.0).getEntry();

        angleEntry180 = lidarTab.add("Angle at 180°", 0.0).getEntry();
        distanceEntry180 = lidarTab.add("Distance at 180° (mm)", 0.0).getEntry();

        angleEntry225 = lidarTab.add("Angle at 225°", 0.0).getEntry();
        distanceEntry225 = lidarTab.add("Distance at 225° (mm)", 0.0).getEntry();

        angleEntry270 = lidarTab.add("Angle at 270°", 0.0).getEntry();
        distanceEntry270 = lidarTab.add("Distance at 270° (mm)", 0.0).getEntry();

        angleEntry315 = lidarTab.add("Angle at 315°", 0.0).getEntry();
        distanceEntry315 = lidarTab.add("Distance at 315° (mm)", 0.0).getEntry();

        // Add a graph widget for showing the graphical data
        lidarTab.add("Lidar Data Graph", 0.0).withWidget("Graph").withPosition(0, 5).withSize(5, 5);
    }

    @Override
    public void periodic() {
        // Получаем данные от лидара
        scanData = lidar.getData();

        // Проверяем, если данные корректны
        if (scanData != null && scanData.angle.length >= 360 && scanData.distance.length >= 360) {
            // Обновляем данные на Shuffleboard для каждого из углов
            angleEntry0.setDouble(scanData.angle[0]);
            distanceEntry0.setDouble(scanData.distance[0]);

            angleEntry45.setDouble(scanData.angle[45]);
            distanceEntry45.setDouble(scanData.distance[45]);

            angleEntry90.setDouble(scanData.angle[90]);
            distanceEntry90.setDouble(scanData.distance[90]);

            angleEntry135.setDouble(scanData.angle[135]);
            distanceEntry135.setDouble(scanData.distance[135]);

            angleEntry180.setDouble(scanData.angle[180]);
            distanceEntry180.setDouble(scanData.distance[180]);

            angleEntry225.setDouble(scanData.angle[225]);
            distanceEntry225.setDouble(scanData.distance[225]);

            angleEntry270.setDouble(scanData.angle[270]);
            distanceEntry270.setDouble(scanData.distance[270]);

            angleEntry315.setDouble(scanData.angle[315]);
            distanceEntry315.setDouble(scanData.distance[315]);
        }
    }

    public void startScan() {
        lidar.start();
    }

    public void stopScan() {
        lidar.stop();
    }
}
