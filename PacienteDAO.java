package Hospital;

import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    private List<Paciente> pacientes;

    public PacienteDAO() {
        pacientes = new ArrayList<>();
    }

    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void editarPaciente(Paciente paciente) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getNome().equals(paciente.getNome())) {
                pacientes.set(i, paciente);
                break;
            }
        }
    }

    public void excluirPaciente(String nome) {
        pacientes.removeIf(p -> p.getNome().equals(nome));
    }

    public List<Paciente> listarPacientes() {
        return new ArrayList<>(pacientes);
    }

    public List<Paciente> pesquisarPacientesPorNome(String nome) {
        List<Paciente> resultado = new ArrayList<>();
        for (Paciente p : pacientes) {
            if (p.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}
