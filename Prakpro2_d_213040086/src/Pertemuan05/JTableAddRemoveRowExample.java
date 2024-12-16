package Petemuan05;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTableAddRemoveRowExample {
    public static void main(String[] args) {
        // Membuat frame
        JFrame frame = new JFrame("JTable Add/Remove Row Example");

        // Nama kolom untuk tabel
        String[] columnNames = { "ID", "Name", "Age" };

        // Model tabel dengan 0 baris awal
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        // JScrollPane untuk JTable
        JScrollPane scrollPane = new JScrollPane(table);

        // Tombol untuk menambahkan baris
        JButton addButton = new JButton("Add Row");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Data baru untuk ditambahkan
                Object[] newRow = { model.getRowCount() + 1, "New Name", 20 };
                model.addRow(newRow);
            }
        });

        // Tombol untuk menghapus baris yang dipilih
        JButton removeButton = new JButton("Remove Row");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) { // Pastikan ada baris yang dipilih
                    model.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a row to remove.");
                }
            }
        });

        // Panel bawah untuk tombol
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        // Menambahkan komponen ke frame dengan BorderLayout
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER); // Tabel di bagian tengah
        frame.add(buttonPanel, BorderLayout.SOUTH); // Tombol di bagian bawah

        // Konfigurasi frame
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
