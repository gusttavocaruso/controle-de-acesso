package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;

import java.util.ArrayList;

public class Report {

  /**
   * Relatório.
   */
  public String idadesCluster(ArrayList<Short> idades) {

    int menores = 0;
    int adultas = 0;
    int oldSchool = 0;

    for (short idade : idades) {
      if (idade < 18) {
        menores += 1;
      } else if (idade >= 18 && idade < 50) {
        adultas += 1;
      } else {
        oldSchool += 1;
      }
    }

    float idadesSize = menores + adultas + oldSchool;
    DecimalFormat decimal = new DecimalFormat("#0.0#%");

    String menoresPercent = decimal.format((menores / idadesSize) * 1).replace(',', '.');
    String adultasPercent = decimal.format((adultas / idadesSize) * 1).replace(',', '.');
    String oldSchoolPercent = decimal.format((oldSchool / idadesSize) * 1).replace(',', '.');

    int idadesSizeTotal = Math.round(idadesSize);

    String relatorioLog = "---- Quantidade ----\n"
        + "menores: " + menores + "\n"
        + "adultas: " + adultas + "\n"
        + "maiores que 50: " + oldSchool + "\n"
        + "\n--- Percentual ----\n"
        + "menores: " + menoresPercent + "\n"
        + "adultas: " + adultasPercent + "\n"
        + "maiores que 50: " + oldSchoolPercent + "\n"
        + "\nTOTAL: " + idadesSizeTotal;

    return relatorioLog;

  }

}
