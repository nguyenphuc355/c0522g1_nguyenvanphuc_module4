package the_song_validation.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class TheSongDto implements Validator {

    private int id;
    @NotBlank(message = "Không được để trống")
    @Size(max = 800, message = "không được quá 800 ký tự !!")
    @Pattern(regexp = "[a-zA-Z0-9 ]+", message = "không được chứa các ký tự đặc biệt")
    private String nameSong;

    @NotBlank(message = "không được để trống !!")
    @Size(max = 300, message = "không được quá 300 kí tự")
    @Pattern(regexp = "[a-zA-Z0-9 ]+", message = "không được chứa các ký tự đặc biệt")
    private String singerName;

    @NotBlank(message = "Không được để trống")
    @Size(max = 1000, message = "không được quá 1000 ký tự !!")
    @Pattern(regexp = "[a-zA-Z0-9 ,]+", message = "không được chứa các ký tự đặc biệt")
    private String categoryName;

    public TheSongDto() {
    }

    public TheSongDto(int id, String nameSong, String singerName, String categoryName) {
        this.id = id;
        this.nameSong = nameSong;
        this.singerName = singerName;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
