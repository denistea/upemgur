/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){ // Quand le document est complètement chargé

      var load = false; // aucun chargement de commentaire n'est en cours

      $(window).scroll(function(){ // On surveille l'évènement scroll

              /* Si l'élément offset est en bas de scroll, si aucun chargement 
              n'est en cours, si le nombre de commentaire affiché est supérieur 
              à 5 et si tout les commentaires ne sont pas affichés, alors on 
              lance la fonction. */
              console.log($(document).height() - $(window).height() - 10);
              console.log($(window).scrollTop());
              if(($(document).height() - $(window).height() - 10) <= $(window).scrollTop()){
                console.log("End Reached");
                jsf.ajax.reqi
              }

      });
});
