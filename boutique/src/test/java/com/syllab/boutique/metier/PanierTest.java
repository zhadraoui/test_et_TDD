package com.syllab.boutique.metier;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PanierTest {
  // Initialisation
  // - Usuel
  @Test
  void initialisation_panierVide() {
    var p = new Panier();

    assertEquals(true, p.estVide());
    assertEquals(0, p.getPrixTotal());
    assertEquals(false, p.getLignes().iterator().hasNext());
  }
  // - Extrême (aucun)
  // - Erreur (aucun)

  // Ajouter
  // - Usuel
  @Test
  void ajouter_1Produit() {
    // Arrange
    var p = new Produit("AT12", "Ciment", 2);
    var panier = new Panier();

    // Act
    panier.ajouter(p, 3);

    // Assertion
    assertEquals(6, panier.getPrixTotal());
    assertEquals(false, panier.estVide());
  }

  @Test
  void ajouter_2ProduitsDifferents() {
    var p1 = new Produit("P1", "L1", 2);
    var p2 = new Produit("P2", "L2", 5);
    var panier = new Panier();

    panier.ajouter(p1, 3);
    panier.ajouter(p2, 1);

    assertEquals(11, panier.getPrixTotal());
    assertEquals(false, panier.estVide());
  }

  @Test
  void ajouter_1Produit2fois_AdditionneLesQuantites() {
    var p1 = new Produit("P1", "L1", 2);
    var panier = new Panier();

    panier.ajouter(p1, 3);
    panier.ajouter(p1, 1);

    assertEquals(8, panier.getPrixTotal());
    assertEquals(false, panier.estVide());
  }

  // - Extreme (aucun)
  // - Erreur
  @Test
  void ajouter_quantite0_leveIllegalArgumentException() {
    var p1 = new Produit("P1", "L1", 2);
    var panier = new Panier();

    panier.ajouter(p1, 0);
  }

  @Test
  void ajouter_quantiteNegative_leveIllegalArgumentException() {
    var p1 = new Produit("P1", "L1", 2);
    var panier = new Panier();

    panier.ajouter(p1, -3);
  }

  @Test
  void ajouter_produitNull_leveNullPointerException() {
    var panier = new Panier();

    panier.ajouter(null, 2);
  }

  // Diminuer
  // - Usuel
  @Test
  void diminuer_produitEnQuantite2OuPlus() {
    var p = new Produit("P1", "L1", 2);
    var panier = new Panier();

    panier.ajouter(p, 3);

    panier.diminuer(p);

    assertEquals(4, panier.getPrixTotal());
    assertEquals(false, panier.estVide());
  }

  // - Extreme
  @Test
  void diminuer_dernierProduitEnQuantite1_panierVide() {
    var p = new Produit("P1", "L1", 2);
    var panier = new Panier();

    panier.ajouter(p, 1);

    panier.diminuer(p);

    assertEquals(0, panier.getPrixTotal());
    assertEquals(true, panier.estVide());
  }

  @Test
  void diminuer_avantDernierProduitEnQuantite1_retireLeProduit() {
    var p1 = new Produit("P1", "L1", 2);
    var p2 = new Produit("P2", "L2", 5);
    var panier = new Panier();

    panier.ajouter(p1, 3);
    panier.ajouter(p2, 1);

    panier.diminuer(p2);

    assertEquals(6, panier.getPrixTotal());
    assertEquals(false, panier.estVide());
  }

  // - Erreur
  @Test
  void diminuer_produitAbsentDuPanier_leveIllegalArgumentException() {
    var p1 = new Produit("P1", "L1", 2);
    var p2 = new Produit("P2", "L2", 5);
    var panier = new Panier();

    panier.ajouter(p1, 3);

    panier.diminuer(p2);
  }
}