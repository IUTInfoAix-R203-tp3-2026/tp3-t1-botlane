package fr.univ_amu.iut.exercice4;

import java.util.ArrayList;

/// Kata 4 - Pagination.
///
/// Kata algorithmique avec beaucoup de cas limites. Idéal pour pratiquer la
/// **discipline TDD** : on active les tests dans l'ordre (du plus simple au plus
/// complexe) et on résiste à la tentation d'anticiper.
public class Pagination {

  private final int courant;
  private final int total;

  public Pagination(int courant, int total) {
    this.courant = courant;
    this.total = total;
  }

  /**
   * private int[] pageAAfficher() { if (total <= 7) { int[] result = new int[total]; for (int i =
   * 0; i < total; i = i + 1) { result[i] = i + 1; } return result; } else { if (courant < 3 ||
   * courant > total - 2) { int[] result = new int[4]; result[0] = 1; if (courant == 2) { result[1]
   * = courant; result[2] = courant + 1; } else { result[1] = courant - 1; result[2] = courant; }
   * result[3] = total; return result; } else { int[] result = new int[5]; result[0] = 1; result[1]
   * = courant - 1; result[2] = courant; result[3] = courant + 1; result[4] = total; return result;
   * } } }
   */
  private ArrayList<Integer> pageAAfficher() {
    ArrayList<Integer> result = new ArrayList<>();
    if (total <= 7) {
      for (int i = 0; i < total; i = i + 1) {
        result.add(i + 1);
      }
    } else {
      result.add(1);
      if (courant > 2) result.add(courant - 1);
      if (courant != 1 && courant != total) result.add(courant);
      if (courant < total - 1) result.add(courant + 1);
      result.add(total);
    }
    return result;
  }

  private String formatPage(int valeur) {
    if (valeur == courant) return "(" + valeur + ")";
    return String.valueOf(valeur);
  }

  private String separateurEntre(int valeur1, int valeur2) {
    if (valeur2 - valeur1 > 1) return " ... ";
    return " ";
  }

  /// Retourne la représentation textuelle de la barre de pagination.
  ///
  /// Format : pages séparées par des espaces, page courante entre parenthèses,
  /// `...` pour combler les trous quand il y a plus de 7 pages au total.
  public String afficher() {
    StringBuilder sortie = new StringBuilder();
    // TODO kata 4 : construire la chaîne de pagination selon les règles
    // du README. Activez les tests dans l'ordre, ils vous guident :
    // - d'abord le cas "total <= 7" (affichage complet)
    // - puis le cas "beaucoup de pages" avec gestion des ellipses
    ArrayList<Integer> pageAfficher = pageAAfficher();
    for (int i = 0; i < pageAfficher.size() - 1; i = i + 1) {
      sortie.append(formatPage(pageAfficher.get(i)));
      sortie.append(separateurEntre(pageAfficher.get(i), pageAfficher.get(i + 1)));
    }
    sortie.append(formatPage(pageAfficher.get(pageAfficher.size() - 1)));
    return sortie.toString();
  }
}
