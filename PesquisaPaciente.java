package Hospital;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class PesquisaPaciente extends JFrame {
    private JTextField searchField;
    private JButton searchButton;
    private JList<String> resultList;
    private DefaultListModel<String> listModel;
    public PesquisaPaciente(PacienteDAO pacienteDAO) {
        setTitle("Pesquisar Paciente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel searchPanel = new JPanel(new FlowLayout());

        JLabel searchLabel = new JLabel("Nome do Paciente:");
        searchField = new JTextField(20);
        searchButton = new JButton("Pesquisar");

        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        listModel = new DefaultListModel<>();
        JScrollPane scrollPane = new JScrollPane();

        panel.add(searchPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = searchField.getText();
                List<Paciente> pacientes = pacienteDAO.pesquisarPacientesPorNome(nome);
                listModel.clear();
                for (Paciente p : pacientes) {
                    listModel.addElement(p.getNome() + " - " + p.getIdade() + " - " + p.getSexo() + " - " + p.getObservacoes());
                }
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        PacienteDAO pacienteDAO = new PacienteDAO();
        SwingUtilities.invokeLater(() -> new PesquisaPaciente(pacienteDAO));
    }

	public JList<String> getResultList() {
		return resultList;
	}

	public void setResultList(JList<String> resultList) {
		this.resultList = resultList;
	}
}
