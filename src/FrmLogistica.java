import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

import modelos.TipoEnvio;
import servicios.EnvioServicio;

public class FrmLogistica extends JFrame {

    private JPanel pnlEditarEnvio;
    private JTextField txtNumero, txtCliente, txtPeso, txtDistanciaKm;
    private JComboBox cmbTipoEnvio;
    private JTable tblLogistica;

    private JLabel lblPeso, lblDistanciaKm;

    public FrmLogistica() {
        setSize(900, 600);
        setTitle("Operador Logístico");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JToolBar tbLogistica = new JToolBar();

        JButton btnAgregarEnvio = new JButton();
        ImageIcon iconAgregar = new ImageIcon(
                new ImageIcon(getClass().getResource("/iconos/agregarEnvio.png"))
                        .getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH));
        btnAgregarEnvio.setIcon(iconAgregar);
        btnAgregarEnvio.setToolTipText("Agregar Envío");
        btnAgregarEnvio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAgregarEnvioClick();
            }
        });
        tbLogistica.add(btnAgregarEnvio);

        JButton btnQuitarEnvio = new JButton();
        ImageIcon iconQuitar = new ImageIcon(
                new ImageIcon(getClass().getResource("/iconos/quitarEnvio.png"))
                .getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH));
        btnQuitarEnvio.setIcon(iconQuitar);        
        btnQuitarEnvio.setToolTipText("Quitar Cuenta");
        btnQuitarEnvio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnQuitarEnvioClick();
            }
        });
        tbLogistica.add(btnQuitarEnvio);

        JPanel pnlEnvios = new JPanel();
        pnlEnvios.setLayout(new BoxLayout(pnlEnvios, BoxLayout.Y_AXIS));

        pnlEditarEnvio = new JPanel();
        pnlEditarEnvio.setPreferredSize(new Dimension(pnlEditarEnvio.getWidth(), 100)); // Altura fija de 100px
        pnlEditarEnvio.setLayout(null);

        JLabel lblNumero = new JLabel("Número");
        lblNumero.setBounds(10, 10, 100, 25);
        pnlEditarEnvio.add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(110, 10, 100, 25);
        pnlEditarEnvio.add(txtNumero);

        JLabel lblCliente = new JLabel("Cliente");
        lblCliente.setBounds(10, 40, 100, 25);
        pnlEditarEnvio.add(lblCliente);

        txtCliente = new JTextField();
        txtCliente.setBounds(110, 40, 100, 25);
        pnlEditarEnvio.add(txtCliente);

        lblPeso = new JLabel("Peso");
        lblPeso.setBounds(10, 70, 100, 25);
        pnlEditarEnvio.add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(110, 70, 100, 25);
        pnlEditarEnvio.add(txtPeso);

        JLabel lblTipo = new JLabel("Tipo");
        lblTipo.setBounds(220, 10, 100, 25);
        pnlEditarEnvio.add(lblTipo);

        cmbTipoEnvio = new JComboBox(TipoEnvio.values());
        cmbTipoEnvio.setBounds(280, 10, 100, 25);

        pnlEditarEnvio.add(cmbTipoEnvio);

        cmbTipoEnvio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        lblDistanciaKm = new JLabel("Distancia en Km");
        lblDistanciaKm.setBounds(220, 40, 100, 25);
        pnlEditarEnvio.add(lblDistanciaKm);

        txtDistanciaKm = new JTextField();
        txtDistanciaKm.setBounds(320, 40, 100, 25);
        pnlEditarEnvio.add(txtDistanciaKm);

        JButton btnGuardarEnvio = new JButton("Guardar");
        btnGuardarEnvio.setBounds(220, 70, 100, 25);
        btnGuardarEnvio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnGuardarEnvioClick();
            }
        });
        pnlEditarEnvio.add(btnGuardarEnvio);

        JButton btnCancelarEnvio = new JButton("Cancelar");
        btnCancelarEnvio.setBounds(320, 70, 100, 25);
        btnCancelarEnvio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCancelarEnvioClick();
            }
        });
        pnlEditarEnvio.add(btnCancelarEnvio);

        pnlEditarEnvio.setVisible(false);

        // Tabla
        tblLogistica = new JTable();
        EnvioServicio.mostrar(tblLogistica);
        JScrollPane spListaEnvios = new JScrollPane(tblLogistica);

        pnlEnvios.add(pnlEditarEnvio);
        pnlEnvios.add(spListaEnvios);

        JScrollPane spEnvios = new JScrollPane(pnlEnvios);
        spEnvios.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        getContentPane().add(tbLogistica, BorderLayout.NORTH);
        add(pnlEnvios, BorderLayout.CENTER);

    }

    private void btnAgregarEnvioClick() {
        pnlEditarEnvio.setVisible(true);

    }

    private void btnQuitarEnvioClick() {

    }

    private void btnGuardarEnvioClick() {

    }

    private void btnCancelarEnvioClick() {
        pnlEditarEnvio.setVisible(false);

    }

}
