import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Ventana extends JFrame {
    private JButton button1;
    private JPanel panel1;

    private boolean ocupado;

    private void setImage(String ruta) {
        Image img = null;
        try {
            img = ImageIO.read(getClass().getResource(ruta));
            button1.setIcon(new ImageIcon(img));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Ventana() {
        setContentPane(panel1);

        ocupado = true;

        button1.setPreferredSize(new Dimension(400, 400));

        setImage("resources/carro.png");

        setSize(1000, 1000);
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ruta = "resources/carro.png";
                if(!ocupado) {
                    ruta = "resources/no-carro.png";
                }
                setImage(ruta);
                ocupado = !ocupado;
            }
        });
    }
}
