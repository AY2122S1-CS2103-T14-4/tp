package seedu.address.ui;

import java.util.logging.Logger;

import javafx.beans.property.IntegerProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;

/**
 * Panel containing the list of persons.
 */
public class PersonDetailedPanel extends UiPart<Region> {
    private static final String FXML = "PersonDetailedPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(PersonListPanel.class);

    @FXML
    private ListView<Person> personListView;
    private IntegerProperty personIndex;
    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public PersonDetailedPanel(ObservableList<Person> personList, IntegerProperty index) {
        super(FXML);
        personListView.setItems(personList);
        personListView.setCellFactory(listView -> new PersonListViewCell());
        personIndex = index;
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class PersonListViewCell extends ListCell<Person> {
        @Override
        protected void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);
            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new PersonCard(person, personIndex.getValue()).getRoot());
            }
        }
    }

}
