import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {




    // This actionListener is for the gas button only
    // TODO: Create more for each component as necessary
        gasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.gas(gasAmount);
        }

    });
        brakeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.brake(gasAmount);
        }

    });
        startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.startEngine();
        }

    });
        stopButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.stopEngine();
        }

    });
        turboOffButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.turboOff();
        }

    });
        turboOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.turboOn();
        }

    });
        liftBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.raisePlatform();
        }

    });
        lowerBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.lowerPlatform();
        }

    });
}
