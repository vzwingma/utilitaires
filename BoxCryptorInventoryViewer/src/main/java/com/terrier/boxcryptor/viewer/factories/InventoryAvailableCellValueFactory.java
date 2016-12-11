/**
 * 
 */
package com.terrier.boxcryptor.viewer.factories;

import com.terrier.boxcryptor.viewer.enums.InventoryCellColumnEnum;
import com.terrier.boxcryptor.viewer.enums.InventoryFileStatutEnum;
import com.terrier.utilities.automation.bundles.boxcryptor.objects.AbstractBCInventaireStructure;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.util.Callback;

/**
 * Factory of cell of uncrypted file value
 * @author vzwingma
 *
 */
public class InventoryAvailableCellValueFactory implements Callback<TreeTableColumn.CellDataFeatures<AbstractBCInventaireStructure, InventoryFileStatutEnum>, ObservableValue<InventoryFileStatutEnum>> {

	// Show uncrypted value ?
	private InventoryCellColumnEnum cellType;

	/**
	 * Constructor
	 * @param uncryptedValue Show uncrypted value ?
	 */
	public InventoryAvailableCellValueFactory(InventoryCellColumnEnum cellType){
		this.cellType = cellType;
	}


	/* (non-Javadoc)
	 * @see javafx.util.Callback#call(java.lang.Object)
	 */
	@Override
	public ObservableValue<InventoryFileStatutEnum> call(CellDataFeatures<AbstractBCInventaireStructure, InventoryFileStatutEnum> param) {

		ReadOnlyObjectWrapper<InventoryFileStatutEnum> valeurCell = null;
		switch (cellType) {
		case STATUT_FICHIER_CHIFFRE:
			valeurCell = new ReadOnlyObjectWrapper<InventoryFileStatutEnum>(param.getValue().getValue().getStatutFichierChiffre());
			break;
		case STATUT_FICHIER_CLAIR:
			valeurCell = new ReadOnlyObjectWrapper<InventoryFileStatutEnum>(param.getValue().getValue().getStatutFichierClair());
			break;			
		default:
			valeurCell = new ReadOnlyObjectWrapper<InventoryFileStatutEnum>(InventoryFileStatutEnum.INCONNU);
		}
		return valeurCell;
	}

}
