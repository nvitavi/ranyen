package com.ranyen.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.ranyen.model.Picture;

@RunWith(SpringRunner.class)
public class PictureRepositoryTest extends BaseTestSetup {

	@Test
	public void testGetPicture() {
		// assert the same picture retrieved is the one added
		assertThat(picture.getUri()).isEqualTo(retrievedPicture.getUri());
	}
	
	@Test
	public void testJoinPictureWithLocation() {
		// test join with location
		assertThat(retrievedPicture.getLocation().getCity()).isEqualTo(bamenda.getCity());
	}
	
	@Test
	public void testUpdatePicture() {
		// update picture
		retrievedPicture.setUri("/new/place");
		Picture updatedPicture = pictureRepository.save(retrievedPicture);

		// assert the same picture was updated
		assertThat(retrievedPicture.getUri()).isEqualTo(updatedPicture.getUri());
	}
	
	@Test
	public void testDeletePicture() {
		// delete picture
		pictureRepository.delete(retrievedPicture);

		// assert picture was deleted
		Optional<Picture> deletedPicture = pictureRepository.findById(pictureId);
		assertThat(deletedPicture.isPresent()).isFalse();
	}
}
