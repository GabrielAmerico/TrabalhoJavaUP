package view;

import Controller.MateriaPrimaController;
import dal.conexaoList;
import interfaces.PadraoView;
import java.util.Scanner;
import model.MateriaPrima;

public class MateriaPrimaView implements PadraoView {

    private static Scanner scan = new Scanner(System.in);

    public void menu() {
        System.out.println(" 5 - Adicionar  Materia Prima:");
        System.out.println(" 6 - Ver Todas as Materias Primas:");
        System.out.println(" 7 - Pesquisar Materia Prima:");
        System.out.println(" 8 - Excluir Materia Prima:");
        System.out.println("");
    }

    public void adicionar() {
        String nomeMateria;
        System.out.println("Cadastrando Materia Prima ...");
        System.out.println("");
        System.out.print("Informe o nome da Materia Prima:");
        nomeMateria = scan.nextLine();

        boolean retorno = MateriaPrimaController.adicionar(nomeMateria);

        if (retorno) {
            System.out.println("----------------------------------------");
            System.out.println("Matéria Prima " + nomeMateria + " adicionado com sucesso");
            System.out.println("----------------------------------------");
        } else {
            System.out.println("----------------------------------------");
            System.out.println("Falha ao adicionar a Matéria Prima");
            System.out.println("----------------------------------------");
        }
    }

    public void listarTodos() {
        for (MateriaPrima matP : conexaoList.getMateriaPrima()) {
            System.out.println("");
            System.out.println("----------------------------------------");
            System.out.println("Código: " + matP.getCodigo());
            System.out.println("Nome Materia Prima: " + matP.getNome());
            System.out.println("----------------------------------------");

        }
    }

    public void buscar() {
        String nomeMat;
        MateriaPrima matP;

        nomeMat = buscarNome();

        matP = MateriaPrimaController.buscar(nomeMat);

        if (matP != null) {
            System.out.println("----------------------------------------");
            System.out.println("Código: " + matP.getCodigo());
            System.out.println("Nome Materia Prima: " + matP.getNome());
            System.out.println("----------------------------------------");
           
        } else {
            System.out.println("----------------------------------------");
            System.out.println("Matéria Prima não encontrada!");
            System.out.println("----------------------------------------");
            
        }
    }

    public String buscarNome() {
        String nomeMat;

        System.out.println("");
        System.out.print("Informe o nome da Matéria Prima:");
        nomeMat = scan.nextLine();

        return nomeMat;
    }

    public void excluir() {
        String nomeMat;
        boolean retorno;

        nomeMat = buscarNome();

        retorno = MateriaPrimaController.excluir(nomeMat);
        if (retorno) {
            System.out.println("----------------------------------------");
            System.out.println("Materia Prima excluida com sucesso");
            System.out.println("----------------------------------------");

        } else {
            System.out.println("----------------------------------------");
            System.out.println("Materia Prima não encontrada");
            System.out.println("----------------------------------------");
        }
    }
}
