package me.carrent.pl;

import javax.swing.*;

public class Menu extends JFrame {
    public void menuFrame() {
        JFrame frame = new JFrame("Menu");
        LoginFrame loginFrame = new LoginFrame();

        frame.setSize(400, 500);
        frame.setLocation(960, 640);
        frame.setLayout(null);

        JButton carRegBtn = new JButton("Wypożycz samochód");
        carRegBtn.setBounds(100, 50, 200, 50);
        frame.add(carRegBtn);
        carRegBtn.addActionListener(e ->{
            CarAvaible carAvaible = new CarAvaible();
            carAvaible.carAvaibleFrame();
            frame.setVisible(false);
        });

        JButton returnCarBtn = new JButton("Zwróć samochód");
        returnCarBtn.setBounds(100,150,200,50);
        frame.add(returnCarBtn);

        JButton userProfileBtn = new JButton("Twój Profil");
        userProfileBtn.setBounds(100,250,200,50);
        frame.add(userProfileBtn);
        userProfileBtn.setEnabled(false);

        JButton exitButton = new JButton("Wyloguj");
        exitButton.setBounds(100,350,200,50);
        frame.add(exitButton);
        exitButton.addActionListener(e ->{
            frame.setVisible(false);
            loginFrame.loginFrame();
            JOptionPane.showMessageDialog(null,"Wylogowano! Zapraszamy ponownie :)");
        });




        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

}
