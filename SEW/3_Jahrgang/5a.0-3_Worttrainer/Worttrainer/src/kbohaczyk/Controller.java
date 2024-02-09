package kbohaczyk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Das ist die Controller Klasse
 * @author Kacper Bohaczyk
 * @version 07/01/2023
 */
public class Controller implements ActionListener {
    private WortTrainer model;
    private TrainerPanel view;

    private WortTrainerSpeichern sper;

    public Controller(WortTrainer model ) throws MalformedURLException {
        this.model = model;
        this.view = new TrainerPanel(this, model);
        this.sper = new WortTrainerSpeichern(model);
    }

    public WortTrainer getModel() {
        return model;
    }

    public TrainerPanel getView() {
        return view;
    }

    /**
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String com = e.getActionCommand();

        switch(com){
            case "zurücksetzen":
                this.view.zurücksetzen();
                break;

            case "Wort hinzufügen":
                this.model.getWortListe().addWort(new WortEintrag(view.getText(), model.WortAktuell().getURL()));
                break;

            case "Speichern":
                try {
                    sper.speichern();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                break;

            case "Laden":
                try {
                    sper.laden();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                break;

            default:

                String wort = view.getJText();
                boolean gleich = this.model.checkIgnoreCase(wort);
                if (gleich) {
                    view.ifRichtig();
                } else {view.ifFalsch();}
                model.WortZufall();
                try {
                    this.view.update(model.WortAktuell().getURL());
                } catch (MalformedURLException ex) {
                    System.err.println("Haram URL");
                }

                break;

        }
    }

}
