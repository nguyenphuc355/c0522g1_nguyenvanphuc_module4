package the_song_validation.service;

import the_song_validation.model.TheSong;

import java.util.List;

public interface ITheSongService {
    List<TheSong> findAll();

    void save(TheSong theSong);

    TheSong findById(int id);

    void update(TheSong theSong);
}
