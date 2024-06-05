package Hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class InterfaceGrafica extends JFrame {
    private JButton addButton, editButton, deleteButton, listButton, searchButton, backButton;
    private PacienteDAO pacienteDAO;

    public InterfaceGrafica() {
        setTitle("Interface Gráfica");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        pacienteDAO = new PacienteDAO();

        addButton = new JButton("Adicionar Paciente");
        editButton = new JButton("Editar Paciente");
        deleteButton = new JButton("Excluir Paciente");
        listButton = new JButton("Listar Pacientes");
        searchButton = new JButton("Pesquisar Paciente");
        backButton = new JButton("Logout");

        add(addButton);
        add(editButton);
        add(deleteButton);
        add(listButton);
        add(searchButton);
        add(backButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PacienteForm(PacienteForm.Mode.ADD, pacienteDAO);
            }
        });

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PacienteForm(PacienteForm.Mode.EDIT, pacienteDAO);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PacienteForm(PacienteForm.Mode.DELETE, pacienteDAO);
            }
        });

        listButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ListaPacientes(pacienteDAO);
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PesquisaPaciente(pacienteDAO);
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login();
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InterfaceGrafica::new);
    }
}
