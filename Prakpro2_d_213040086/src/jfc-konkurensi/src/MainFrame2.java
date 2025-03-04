import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Contoh Konkurensi di Swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLayout(new BorderLayout());

            JLabel statusLabel = new JLabel("Tekan tombol untuk mulai tugas berat", JLabel.CENTER);

            JButton startButton = new JButton("Mulai");

            JProgressBar progressBar = new JProgressBar(0, 100);
            progressBar.setValue(0);
            progressBar.setStringPainted(true);

            frame.add(statusLabel, BorderLayout.NORTH);
            frame.add(progressBar, BorderLayout.CENTER);
            frame.add(startButton, BorderLayout.SOUTH);

            startButton.addActionListener(e -> {
                startButton.setEnabled(false);
                statusLabel.setText("Proses berjalan...");

                // Buat SwingWorker untuk menangani tugas berat
                SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        // Simulasi tugas berat
                        for (int i = 0; i <= 100; i++) {
                            Thread.sleep(50); // Simulasi delay
                            publish(i); // Perbarui progres
                        }
                        return null;
                    }

                    @Override
                    protected void process(List<Integer> chunks) {
                        // Perbarui progress bar
                        int latestProgress = chunks.get(chunks.size() - 1);
                        progressBar.setValue(latestProgress);
                    }

                    @Override
                    protected void done() {
                        // Aksi setelah tugas selesai
                        startButton.setEnabled(true);
                        statusLabel.setText("Proses selesai!");
                    }
                };

                // Jalankan SwingWorker
                worker.execute();
            });

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
