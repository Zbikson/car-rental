package me.carrent.pl;

import javax.swing.*;

public class CarAvaible extends JFrame {
    public void carAvaibleFrame() {
        JFrame frame = new JFrame("Wypożyczalnia samochodów J&M");
        JList<Cars> carsList = new JList<>();
        DefaultListModel<Cars> modelList = new DefaultListModel<>();

        JLabel label = new JLabel();
        JPanel panel = new JPanel();
        JSplitPane splitPane = new JSplitPane();

        Menu menu = new Menu();
        JButton backToLogin = new JButton("\uD83E\uDC14");
        backToLogin.setBounds(5,5,50,20);
        backToLogin.setFont(backToLogin.getFont().deriveFont(16.0f));
        backToLogin.addActionListener(e -> {
            menu.menuFrame();
            frame.setVisible(false);
        });
        frame.add(backToLogin);


        carsList.setModel(modelList);
        modelList.addElement(new Cars("Volkswagen", "Golf","DW123",2004, 2.0,"Diesel",115));
        modelList.addElement(new Cars("Audi", "A4","DW12345",2012, 2.5,"Benzyna",190));
        modelList.addElement(new Cars("Mercedes-Benz", "CLA","DW782F0",2018, 3.0,"Diesel",250));
        modelList.addElement(new Cars("Toyota", "Avensis","DW014AF",2011, 1.8,"Diesel",146));

        splitPane.setLeftComponent(panel);  //lewy panel
        frame.add(splitPane);
        splitPane.setRightComponent(new JScrollPane((carsList)));  //prway panel
        panel.add(label);

        frame.setSize(1000, 800);
        frame.setLocation(960, 640);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
