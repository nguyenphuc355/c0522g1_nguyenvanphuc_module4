package dictionary.model;

public class Dictionary {
    private String english;
    private String vietNamEse;

    public Dictionary() {
    }

    public Dictionary(String english, String vietNamEse) {
        this.english = english;
        this.vietNamEse = vietNamEse;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getVietNamEse() {
        return vietNamEse;
    }

    public void setVietNamEse(String vietNamEse) {
        this.vietNamEse = vietNamEse;
    }

}
