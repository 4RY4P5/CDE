package com.cognizant.favoritesService.dao;

import org.springframework.stereotype.Component;

import com.cognizant.favoritesService.exception.FavoritesEmptyException;
import com.cognizant.favoritesService.model.Favorites;



@Component
public interface FavoritesDao {

	void addToFavorites(int userId, int movieId);
	Favorites getAllFavorites(int userId) throws FavoritesEmptyException;	
	void removeFavMovie(int userId, int movieId) throws FavoritesEmptyException;

}
