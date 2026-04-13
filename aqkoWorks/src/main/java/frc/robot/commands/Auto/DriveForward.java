package frc.robot.commands.Auto;

import com.studica.frc.ServoContinuous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Training;

/**
 * An example command that uses an example subsystem.
 */
public class DriveForward extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Training m_train;
  private static int state;
  private static long time;
  private static double Right;
  private static double Left ;
  private static double Back ;
  private static double Lift ;
  private static double getSonicRight ;
  


  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveForward(Training subsystem) {
    m_train = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

public void execute()
    {

        
        if (m_train.getSonicLeft()>= 50)
        {
          Right = (-1);
          Left = (1);
          // Back = (1);
          // Lift = (-1);

        }
        else 
        {
          Right = (1);
          Left = (1);
          // Back = (0);
          // Lift = (0);
          // m_train.setServoHvat(1);
        }

        m_train.setRightMotorSpeed(Right);
        m_train.setLeftMotorSpeed(Left);
        m_train.setBackMotorSpeed(Back);
        m_train.setLiftMotorSpeed(Lift);
      }
    }
      
        


       


