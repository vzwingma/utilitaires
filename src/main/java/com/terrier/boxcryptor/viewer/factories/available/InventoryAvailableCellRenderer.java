/**
 * 
 */
package com.terrier.boxcryptor.viewer.factories.available;

import com.terrier.boxcryptor.viewer.BCInventoryViewer;
import com.terrier.boxcryptor.viewer.enums.InventoryFileStatutObject;
import com.terrier.utilities.automation.bundles.boxcryptor.objects.AbstractBCInventaireStructure;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.TreeTableCell;
import javafx.scene.image.ImageView;

/**
 * @author vzwingma
 *
 */
public class InventoryAvailableCellRenderer implements ObservableValue<Node>  {


	private final TreeTableCell<AbstractBCInventaireStructure, InventoryFileStatutObject> cell;

	/**
	 * renderer d'icone
	 * @param cell
	 */
	public InventoryAvailableCellRenderer(final TreeTableCell<AbstractBCInventaireStructure, InventoryFileStatutObject> cell){
		this.cell = cell;
	}


	/**
	 * @see javafx.beans.value.ObservableValue#removeListener(javafx.beans.value.ChangeListener)
	 */
	@Override
	public void removeListener(ChangeListener<? super Node> listener) {
		// Rien à faire
	}

	/* (non-Javadoc)
	 * @see javafx.beans.value.ObservableValue#getValue()
	 */
	@Override
	public Node getValue() {
		ImageView livePerformIcon = null;
		if(cell.itemProperty().get() != null){
			String imagePath = cell.itemProperty().get().getIcon();
			livePerformIcon = new ImageView(BCInventoryViewer.class.getResource(imagePath).toExternalForm());
			livePerformIcon.setFitHeight(20);
			livePerformIcon.setFitWidth(20);
		}
		return livePerformIcon;
	}

	/* (non-Javadoc)
	 * @see javafx.beans.Observable#addListener(javafx.beans.InvalidationListener)
	 */
	@Override
	public void addListener(InvalidationListener listener) {
		// Rien à faire
	}

	/* (non-Javadoc)
	 * @see javafx.beans.Observable#removeListener(javafx.beans.InvalidationListener)
	 */
	@Override
	public void removeListener(InvalidationListener listener) {
		// Rien à faire
	}


	/* (non-Javadoc)
	 * @see javafx.beans.value.ObservableValue#addListener(javafx.beans.value.ChangeListener)
	 */
	@Override
	public void addListener(ChangeListener<? super Node> listener) {
		// Rien à faire
	}
}
