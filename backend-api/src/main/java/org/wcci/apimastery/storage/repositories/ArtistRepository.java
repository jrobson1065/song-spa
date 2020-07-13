package org.wcci.apimastery.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.entities.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
}
