package com.syllab.boutique.metier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class PanierTest {

  @Test
  void ajout_1produit() {

    // Arrange
    Produit produit = new Produit("AT12", "Ciment", 2);
    Panier panier = new Panier();

    // Action
    panier.ajouter(produit, 3);

    // Asseration 
    assertEquals(6, panier.getPrixTotal());

  }
}