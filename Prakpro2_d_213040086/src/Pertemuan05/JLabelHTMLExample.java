package Petemuan05;

import javax.swing.*;

public class JLabelHTMLExample {
    public static void main(String[] args) {
        // Membuat frame
        JFrame frame = new JFrame("JLabel HTML Example");

        // Membuat JLabel dengan teks HTML yang benar
        JLabel label = new JLabel("<html><b>Bold Text</b>, <i>Italic Text</i>, <u>Underlined Text</u></html>");

        // Menambahkan JLabel ke JFrame
        frame.add(label);

        // Konfigurasi frame
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
