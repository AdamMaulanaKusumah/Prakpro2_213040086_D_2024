package petemuan06;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookManagementSystem extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;

    public BookManagementSystem() {
        // Pengaturan JFrame
        setTitle("Book Management System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Membuat JMenuBar dan JMenu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem inputFormMenuItem = new JMenuItem("Input Book Data");
        menu.add(inputFormMenuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Membuat tabel untuk menampilkan data
        String[] columnNames = {"Judul Buku", "Pengarang", "Jenis Buku", "Tahun Buku", "Rating"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);

        // Event untuk membuka form input
        inputFormMenuItem.addActionListener(e -> openInputForm());

        // Menambahkan komponen ke frame utama
        add(tableScrollPane, BorderLayout.CENTER);
    }

    // Method untuk membuka form input
    private void openInputForm() {
        JDialog inputFormDialog = new JDialog(this, "Input Book Data", true);
        inputFormDialog.setSize(400, 400);
        inputFormDialog.setLocationRelativeTo(this);
        inputFormDialog.setLayout(new GridLayout(8, 2, 10, 10));

        // Komponen input
        JLabel titleLabel = new JLabel("judul Buku:");
        JTextField titleField = new JTextField();

        JLabel authorLabel = new JLabel("Pengarang:");
        JTextField authorField = new JTextField();

        JLabel genreLabel = new JLabel("Jenis Buku:");
        JComboBox<String> genreComboBox = new JComboBox<>(new String[]{"Novel", "Cerpen", "Science", "Biography"});

        JLabel yearLabel = new JLabel("Tahun Buku:");
        JSpinner yearSpinner = new JSpinner(new SpinnerNumberModel(2024, 1900, 2024, 1));

        JLabel ratingLabel = new JLabel("Rating:");
        JSlider ratingSlider = new JSlider(1, 10, 5);
        ratingSlider.setMajorTickSpacing(1);
        ratingSlider.setPaintTicks(true);
        ratingSlider.setPaintLabels(true);

        // Tombol Tambah Buku
        JButton addButton = new JButton("Tambah Buku");

        // Event Submit untuk menyimpan data ke JTable
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String author = authorField.getText();
                String genre = (String) genreComboBox.getSelectedItem();
                int year = (int) yearSpinner.getValue();
                int rating = ratingSlider.getValue();

                // Tambahkan data ke JTable
                tableModel.addRow(new Object[]{title, author, genre, year, rating});

                // Kosongkan field setelah submit
                titleField.setText("");
                authorField.setText("");
                genreComboBox.setSelectedIndex(0);
                yearSpinner.setValue(2023);
                ratingSlider.setValue(5);
            }
        });

        // Menambahkan komponen ke form
        inputFormDialog.add(titleLabel);
        inputFormDialog.add(titleField);
        inputFormDialog.add(authorLabel);
        inputFormDialog.add(authorField);
        inputFormDialog.add(genreLabel);
        inputFormDialog.add(genreComboBox);
        inputFormDialog.add(yearLabel);
        inputFormDialog.add(yearSpinner);
        inputFormDialog.add(ratingLabel);
        inputFormDialog.add(ratingSlider);
        inputFormDialog.add(new JLabel()); // Kosong untuk spasi
        inputFormDialog.add(addButton);

        inputFormDialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BookManagementSystem app = new BookManagementSystem();
            app.setVisible(true);
        });
    }
}
