package Hospital;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PacienteForm extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nomeField, idadeField, sexoField, observacoesField;
    private JButton saveButton, deleteButton;
    private PacienteDAO pacienteDAO;
    private Mode mode;

    public enum Mode { ADD, EDIT, DELETE }

    public PacienteForm(Mode mode, PacienteDAO pacienteDAO2) {
        this.setMode(mode);
        pacienteDAO = new PacienteDAO();

        setTitle(mode == Mode.EDIT ? "Editar Paciente" : mode == Mode.DELETE ? "Excluir Paciente" : "Adicionar Paciente");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 10, 80, 25);
        panel.add(nomeLabel);

        nomeField = new JTextField(20);
        nomeField.setBounds(100, 10, 160, 25);
        panel.add(nomeField);

        JLabel idadeLabel = new JLabel("Idade:");
        idadeLabel.setBounds(10, 40, 80, 25);
        panel.add(idadeLabel);

        idadeField = new JTextField(20);
        idadeField.setBounds(100, 40, 160, 25);
        panel.add(idadeField);

        JLabel sexoLabel = new JLabel("Sexo:");
        sexoLabel.setBounds(10, 70, 80, 25);
        panel.add(sexoLabel);

        sexoField = new JTextField(20);
        sexoField.setBounds(100, 70, 160, 25);
        panel.add(sexoField);

        JLabel observacoesLabel = new JLabel("Observações:");
        observacoesLabel.setBounds(10, 100, 80, 25);
        panel.add(observacoesLabel);

        observacoesField = new JTextField(20);
        observacoesField.setBounds(100, 100, 160, 25);
        panel.add(observacoesField);

        saveButton = new JButton(mode == Mode.EDIT ? "Salvar" : "Adicionar");
        saveButton.setBounds(10, 150, 120, 25);
        panel.add(saveButton);

        if (mode == Mode.DELETE) {
            deleteButton = new JButton("Excluir");
            deleteButton.setBounds(140, 150, 120, 25);
            panel.add(deleteButton);
        }

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Paciente paciente = new Paciente(
                        nomeField.getText(),
                        Integer.parseInt(idadeField.getText()),
                        sexoField.getText(),
                        observacoesField.getText()
                );

                if (mode == Mode.EDIT) {
                    pacienteDAO.editarPaciente(paciente);
                } else if (mode == Mode.ADD) {
                    pacienteDAO.adicionarPaciente(paciente);
                }
                dispose();
            }
        });

        if (mode == Mode.DELETE) {
            deleteButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    pacienteDAO.excluirPaciente(nomeField.getText());
                    dispose();
                }
            });
        }

        add(panel);
        setVisible(true);
    }

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}
}
