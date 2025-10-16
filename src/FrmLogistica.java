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
 
    private JTextField txtNumero;
    private JTextField txtCliente;
    private JTextField txtPeso;
    private JTextField txtDistanciaKm;
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
            @Override
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
        btnQuitarEnvio.setToolTipText("Quitar Envío");
        
        btnQuitarEnvio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnQuitarEnvioClick();
            }
        });
        tbLogistica.add(btnQuitarEnvio);

        
        JPanel pnlEnvios = new JPanel();
        pnlEnvios.setLayout(new BoxLayout(pnlEnvios, BoxLayout.Y_AXIS));

        pnlEditarEnvio = new JPanel();
        pnlEditarEnvio.setPreferredSize(new Dimension(pnlEditarEnvio.getWidth(), 100));
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

        JLabel lblDistancia = new JLabel("Distancia en Km");
        lblDistancia.setBounds(220, 40, 100, 25);
        pnlEditarEnvio.add(lblDistancia);

        txtDistanciaKm = new JTextField();
        txtDistanciaKm.setBounds(320, 40, 100, 25);
        pnlEditarEnvio.add(txtDistanciaKm);

        JButton btnGuardarEnvio = new JButton("Guardar");
        btnGuardarEnvio.setBounds(220, 70, 100, 25);
        btnGuardarEnvio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnGuardarEnvioClick();
            }
        });
        pnlEditarEnvio.add(btnGuardarEnvio);

        JButton btnCancelarEnvio = new JButton("Cancelar");
        btnCancelarEnvio.setBounds(320, 70, 100, 25);
        btnCancelarEnvio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnCancelarEnvioClick();
            }
        });
        pnlEditarEnvio.add(btnCancelarEnvio);

        pnlEditarEnvio.setVisible(false);

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
        int filaSeleccionada = tblLogistica.getSelectedRow();
        
        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Por favor seleccione un envío para eliminar", 
                "Error", 
                javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirmacion = javax.swing.JOptionPane.showConfirmDialog(this, 
            "¿Está seguro de que desea eliminar este envío?", 
            "Confirmar eliminación", 
            javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
            try {
                EnvioServicio.eliminar(filaSeleccionada);
                
                EnvioServicio.mostrar(tblLogistica);
                
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Envío eliminado exitosamente", 
                    "Éxito", 
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Error al eliminar el envío: " + e.getMessage(), 
                    "Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void btnGuardarEnvioClick() {
        try {
            if (txtNumero.getText().trim().isEmpty() || 
                txtCliente.getText().trim().isEmpty() || 
                txtPeso.getText().trim().isEmpty() || 
                txtDistanciaKm.getText().trim().isEmpty()) {
                
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Por favor complete todos los campos", 
                    "Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return; 
            }

            String codigo = txtNumero.getText().trim();           
            String cliente = txtCliente.getText().trim();
            double peso = Double.parseDouble(txtPeso.getText().trim());        
            double distancia = Double.parseDouble(txtDistanciaKm.getText().trim());
            TipoEnvio tipo = (TipoEnvio) cmbTipoEnvio.getSelectedItem();       

            if (!validarCliente(cliente)) {
                String mensajeError = obtenerMensajeErrorCliente(cliente);
                javax.swing.JOptionPane.showMessageDialog(this, 
                    mensajeError, 
                    "Error en nombre del cliente", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return; 
            }

            if (peso <= 0 || distancia <= 0) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "El peso y la distancia deben ser valores positivos", 
                    "Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return; 
            }

            EnvioServicio.agregar(tipo, codigo, cliente, peso, distancia);
            
            EnvioServicio.mostrar(tblLogistica);
            
            limpiarFormulario();
            pnlEditarEnvio.setVisible(false);
            
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Envío agregado exitosamente", 
                "Éxito", 
                javax.swing.JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Por favor ingrese valores numéricos válidos para peso y distancia", 
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Error al guardar el envío: " + e.getMessage(), 
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnCancelarEnvioClick() {
        limpiarFormulario();                                   
        pnlEditarEnvio.setVisible(false);                      
    }
    
    private boolean validarCliente(String cliente) {
        if (cliente == null || cliente.trim().isEmpty()) {
            return false;
        }
        
        if (cliente.trim().length() < 1 || cliente.trim().length() > 100) {
            return false;
        }
        
        if (!cliente.equals(cliente.trim())) {
            return false;
        }
        
        if (!cliente.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s\\.\\-']+$")) {
            return false;
        }
        
        if (cliente.contains("  ")) {
            return false;
        }
        
        String[] partes = cliente.trim().split("\\s+");
        
        for (String parte : partes) {
            if (parte.length() < 1) {
                return false;
            }
            if (!parte.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ]+$")) {
                return false;
            }
        }
        
        return true;
    }
    
    private String obtenerMensajeErrorCliente(String cliente) {
        if (cliente == null || cliente.trim().isEmpty()) {
            return "El nombre del cliente no puede estar vacío";
        }
        
        if (cliente.trim().length() < 1) {
            return "El nombre del cliente debe tener al menos 1 carácter";
        }
        
        if (cliente.trim().length() > 100) {
            return "El nombre del cliente no puede tener más de 100 caracteres";
        }
        
        if (!cliente.equals(cliente.trim())) {
            return "El nombre del cliente no puede empezar o terminar con espacios";
        }
        
        if (cliente.contains("  ")) {
            return "El nombre del cliente no puede tener múltiples espacios consecutivos";
        }
        
        if (!cliente.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s\\.\\-']+$")) {
            return "El nombre del cliente solo puede contener letras, espacios, puntos, guiones y apostrofes";
        }
        
        String[] partes = cliente.trim().split("\\s+");
        
        for (String parte : partes) {
            if (parte.length() < 1) {
                return "Cada parte del nombre debe tener al menos 1 carácter";
            }
            if (!parte.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ]+$")) {
                return "Cada parte del nombre solo puede contener letras";
            }
        }
        
        return "Formato de nombre inválido";
    }
    
    private void limpiarFormulario() {
        txtNumero.setText("");
        txtCliente.setText("");
        txtPeso.setText("");
        txtDistanciaKm.setText("");
        cmbTipoEnvio.setSelectedIndex(0);
    }

}