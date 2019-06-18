package email.app.com.appcourses;

public class Courses{
    private String objet;
    private boolean important;
    private String quantite;

    public Courses(){}

    public Courses(String objet, boolean important, String quantite) {
        this.objet = objet;
        this.important = important;
        this.quantite = quantite;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }
}
