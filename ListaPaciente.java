package Hospital;

import Hospital.Paciente;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@SuppressWarnings("serial")
public class ListaPaciente extends JFrame {
    private Component pacientesList;
    @SuppressWarnings("unused")
	private PacienteDAO pacienteDAO;

    public ListaPaciente(PacienteDAO pacienteDAO) {
        this.pacienteDAO = pacienteDAO;

        setTitle("Lista de Pacientes");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        List<Paciente> pacientes = pacienteDAO.listarPacientes();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Paciente p : pacientes) {
            listModel.addElement(p.getNome() + " - " + p.getIdade() + " - " + p.getSexo() + " - " + p.getObservacoes());
        }

        pacientesList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(pacientesList);

        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}
