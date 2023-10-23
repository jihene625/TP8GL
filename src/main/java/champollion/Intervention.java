
package champollion;

import java.util.Date;


public class Intervention {
    private Date debut;
    private int duree;
    private boolean annulee = false;
    private int heureDebut;
    private TypeIntervention type;
    private Salle salle;
    private UE ue;
    private Enseignant enseignant;

    public Intervention(Date debut, int duree, int heureDebut, TypeIntervention type, Salle salle, UE ue, Enseignant enseignant) {
        this.debut = debut;
        this.duree = duree;
        this.heureDebut = heureDebut;
        this.type = type;
        this.salle = salle;
        this.ue = ue;
        this.enseignant = enseignant;
    }

    public int getDuree() {
        return duree;
    }

    public UE getUe() {
        return ue;
    }

    public TypeIntervention getType() {
        return type;
    }
   
}
