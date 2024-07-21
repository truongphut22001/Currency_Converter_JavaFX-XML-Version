package application;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class HistoryController {
	@FXML
	private ListView<String> historyListView;

	public void viewList(ObservableList<String> items) {
		historyListView.setItems(items);
	}
}
