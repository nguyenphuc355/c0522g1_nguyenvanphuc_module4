package the_song_validation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import the_song_validation.model.TheSong;
import the_song_validation.repository.ITheSongRepository;
import the_song_validation.service.ITheSongService;

import java.util.List;

@Service
public class TheSongService implements ITheSongService {
    @Autowired
    private ITheSongRepository theSongRepository;

    @Override
    public List<TheSong> findAll() {
        return theSongRepository.findAll();
    }

    @Override
    public void save(TheSong theSong) {
        theSongRepository.save(theSong);
    }

    @Override
    public TheSong findById(int id) {
        return theSongRepository.findById(id);
    }

    @Override
    public void update(TheSong theSong) {
        theSongRepository.save(theSong);
    }
}
