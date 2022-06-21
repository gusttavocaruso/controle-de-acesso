package com.trybe.acc.java.controledeacesso;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

  /**
   * Método principal.
   */
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    Report report = new Report();
    ArrayList<Short> idades = new ArrayList<Short>();

    boolean systemOn = true;
    short opcao;
    short idade;

    menuInicial();
    opcao = scan.nextShort();

    while (systemOn) {

      if (opcao != 1 && opcao != 2) {
        System.out.println("Entre com uma opção válida!");
        menuInicial();
        opcao = scan.nextShort();
      } else if (opcao == 1) {
        System.out.println("Entre com a idade:");
        idade = scan.nextShort();

        idadeReturn(idade);
        idades.add(idade);

        menuInicial();
        opcao = scan.nextShort();
      } else {
        String relatorioLog = report.idadesCluster(idades);
        System.out.println(relatorioLog);

        systemOn = false;
      }

    }

    scan.close();

  }

  static void menuInicial() {

    String menu = ("Entre com o número correspondente à opção desejada:\n"
        + "1 - Acessar o estabelecimento \n2 - Finalizar sistema e mostrar relatório");

    System.out.println(menu);

  }

  static void idadeReturn(short idade) {

    if (idade < 18) {
      System.out.println("Pessoa cliente menor de idade, catraca liberada!");
    } else if (idade >= 18 && idade <= 50) {
      System.out.println("Pessoa adulta, catraca liberada!");
    } else {
      System.out.println("Pessoa adulta maior de 50, catraca liberada!");
    }

  }

}
