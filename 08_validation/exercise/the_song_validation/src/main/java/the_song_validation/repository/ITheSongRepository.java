package the_song_validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import the_song_validation.model.TheSong;

@Repository
public interface ITheSongRepository extends JpaRepository<TheSong, Integer> {
    TheSong findById(int id);


}
