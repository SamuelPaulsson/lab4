public class Controller {
    private final Modell modell;
    private final View frame;

    public Controller(Modell modell, View frame){
        this.modell = modell;
        this.frame = frame;
    }

    void gas(int amount)



    // This actionListener is for the gas button only
    // TODO: Create more for each component as necessary
        gasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            modell.gas(gasAmount);
        }

    });
        brakeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            modell.brake(gasAmount);
        }

    });
        startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            modell.startEngine();
        }

    });
        stopButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            modell.stopEngine();
        }

    });
        turboOffButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            modell.turboOff();
        }

    });
        turboOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            modell.turboOn();
        }

    });
        liftBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            modell.raisePlatform();
        }

    });
        lowerBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            modell.lowerPlatform();
        }

    });
}
