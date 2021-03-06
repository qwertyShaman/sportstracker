package de.saring.exerciseviewer.gui

import de.saring.util.AppResources
import de.saring.util.unitcalc.FormatUtils
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.stage.Stage
import javafx.stage.Window

import java.util.Optional

/**
 * This is the GUI context of the ExerciseViewer sub-application. It contains helper methods
 * and resource access for all ExerciseViewer components.
 *
 * @author Stefan Saring
 */
interface EVContext {

    /**
     * Returns the primary stage (main window) of the application.
     */
    val primaryStage: Stage

    /**
     * Returns the provider of application text resources.
     */
    val resources: AppResources

    /**
     * Returns the format utils class for the current unit system.
     */
    val formatUtils: FormatUtils

    /**
     * Displays a modal message dialog of the passed type with the specified message title and message
     * for the specified parent window.
     *
     * @param parent the parent component of the message dialog
     * @param alertType the type of the message dialog
     * @param titleKey the resource key for the dialog title text
     * @param messageKey the resource key for the message text
     * @param arguments list of objects which needs to be inserted in the message text (optional)
     */
    fun showMessageDialog(parent: Window, alertType: Alert.AlertType, titleKey: String,
                          messageKey: String, vararg arguments: Any)

    /**
     * Displays a modal confirmation dialog for the specified parameters. By default the dialog
     * displays the OK and Cancel buttons, this can be changed by passing the ButtonTypes to be
     * shown (the default buttons are removed then).
     *
     * @param parent parent window of the input dialog
     * @param titleKey resource key for the dialog title
     * @param messageKey resource key for the dialog message
     * @param buttonTypes list of buttons to be displayed as confirmation options (optional)
     * @return an Optional that contains the result (selected button type) of the displayed dialog (use of optional for
     * Java compatibility)
     */
    fun showConfirmationDialog(parent: Window, titleKey: String, messageKey: String,
                               vararg buttonTypes: ButtonType): Optional<ButtonType>

    /**
     * Displays a modal text input dialog for the specified parameters.
     *
     * @param parent parent window of the input dialog
     * @param titleKey resource key for the dialog title
     * @param messageKey resource key for the dialog message
     * @param initialValue initial text value to be displayed
     * @return an Optional containing the entered String (can be empty text) or Optional.empty() when the user has
     * cancelled the dialog (use of optional for Java compatibility)
     */
    fun showTextInputDialog(parent: Window, titleKey: String, messageKey: String, initialValue: String): Optional<String>
}