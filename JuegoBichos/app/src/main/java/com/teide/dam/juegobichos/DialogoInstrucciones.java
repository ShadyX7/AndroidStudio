package com.teide.dam.juegobichos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Victor on 21/01/2016.
 */
public class DialogoInstrucciones extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setMessage("Ganar puntos: Tocar orugas para acumular puntos." +
                "\nFin del juego: El juego terminará cuando acumules mas de 15 orugas en pantalla." +
        "\nRegresar al menu: Pulsar BACK TO HOME." +
                "\nSalir del juego: Pulsar QUIT o EXIT GAME.")
                .setTitle("INSTRUCCIONES DE USO.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        return builder.create();
    }
}
