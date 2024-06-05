package Hospital;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;

    public Login() {
        setTitle("Login Administrativo");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Usuário:");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);

        userField = new JTextField(20);
        userField.setBounds(100, 10, 160, 25);
        panel.add(userField);

        JLabel passLabel = new JLabel("Senha:");
        passLabel.setBounds(10, 40, 80, 25);
        panel.add(passLabel);

        passField = new JPasswordField(20);
        passField.setBounds(100, 40, 160, 25);
        panel.add(passField);

        loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 250, 25);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = userField.getText();
                String password = new String(passField.getPassword());
                if (validarLogin(user, password)) {
                    new InterfaceGrafica();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");
                }
            }
        });
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }

    private boolean validarLogin(String user, String password) {
        return ("cirurgiao".equals(user) && "senha1".equals(password)) ||
               ("pediatra".equals(user) && "senha2".equals(password)) ||
               ("enfermeira".equals(user) && "senha3".equals(password));
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Login::new);
    }
}
