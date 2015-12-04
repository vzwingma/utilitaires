package com.terrier.boxcryptor.objects;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * Class of a directory in inventory
 * @author vzwingma
 *
 */
public class BCInventaireRepertoire extends AbstractBCInventaireStructure {


	/**
	 * Constructeur pour YML
	 */
	public BCInventaireRepertoire(){

	}
	
	/**
	 * Repertoire
	 * @param repertoireChiffre
	 * @param repertoireClair
	 */
	public BCInventaireRepertoire(String nomRepertoireChiffre, String nomRepertoireClair) {
		super(nomRepertoireChiffre, nomRepertoireClair);
	}

	/**
	 * Fichier dans le répertoire
	 */
	Map<String, BCInventaireFichier> mapInventaireFichiers = new HashMap<String, BCInventaireFichier>();
	
	/**
	 * Sous r�pertoires dans le r�pertoire
	 */
	Map<String, BCInventaireRepertoire> mapInventaireSousRepertoires = new HashMap<String, BCInventaireRepertoire>();
	

	/**
	 * Ajoute un sous répertoire au répertoire
	 * @param inventaireRepertoire
	 */
	public void addSSRepertoire(BCInventaireRepertoire inventaireRepertoire){
		this.mapInventaireSousRepertoires.put(inventaireRepertoire.getCleMap(), inventaireRepertoire);
	}
	
	/**
	 * Ajoute un fichier au répertoire
	 * @param fichierChiffre
	 */
	public void addFichier(BCInventaireFichier fichierChiffre){
		this.mapInventaireFichiers.put(fichierChiffre.getCleMap(), fichierChiffre);
	}
	
	/**
	 * Ajoute un répertoire au répertoire
	 * @param repertoireChiffre
	 */
	public BCInventaireRepertoire getBCInventaireSousRepertoire(Path repertoireChiffre, Path repertoireNonChiffre){
		
		String keySousRepertoire = getCleMap(repertoireNonChiffre.getFileName().toString());
		if(this.mapInventaireSousRepertoires.get(keySousRepertoire) == null){
			BCInventaireRepertoire ssRepertoire = new BCInventaireRepertoire(repertoireChiffre.getFileName().toString(), repertoireNonChiffre.getFileName().toString());
			this.mapInventaireSousRepertoires.put(ssRepertoire.getCleMap(), ssRepertoire);
		}
		return this.mapInventaireSousRepertoires.get(keySousRepertoire);
	}

	/**
	 * @return the mapInventaireFichiers
	 */
	public Map<String, BCInventaireFichier> getMapInventaireFichiers() {
		return mapInventaireFichiers;
	}

	/**
	 * @return the mapInventaireSousRepertoires
	 */
	public Map<String, BCInventaireRepertoire> getMapInventaireSousRepertoires() {
		return mapInventaireSousRepertoires;
	}

	/**
	 * @param mapInventaireFichiers the mapInventaireFichiers to set
	 */
	public void setMapInventaireFichiers(Map<String, BCInventaireFichier> mapInventaireFichiers) {
		this.mapInventaireFichiers = mapInventaireFichiers;
	}

	/**
	 * @param mapInventaireSousRepertoires the mapInventaireSousRepertoires to set
	 */
	public void setMapInventaireSousRepertoires(Map<String, BCInventaireRepertoire> mapInventaireSousRepertoires) {
		this.mapInventaireSousRepertoires = mapInventaireSousRepertoires;
	}
}
