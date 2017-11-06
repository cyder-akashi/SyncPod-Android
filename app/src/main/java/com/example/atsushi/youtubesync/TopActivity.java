package com.example.atsushi.youtubesync;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by atsushi on 2017/11/03.
 */

public class TopActivity extends AppCompatActivity {
    private final int CREATE_ROOM_REQUEST_CODE = 200;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        Toolbar toolbar = (Toolbar) findViewById(R.id.top_tool_bar);
        toolbar.setLogo(R.drawable.toolbar_logo);

        findViewById(R.id.join_room_card)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog();
                    }
                });

        findViewById(R.id.create_room_card)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent varIntent =
                                new Intent(TopActivity.this, CreateRoomActivity.class);
                        startActivityForResult(varIntent, CREATE_ROOM_REQUEST_CODE);
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK && intent != null) {
            if (requestCode == CREATE_ROOM_REQUEST_CODE) {
            }
        }
    }

    private void showDialog() {
        if (dialog == null) {
            LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
            final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.join_room_dialog, (ViewGroup)findViewById(R.id.join_room_dialog_root));

            dialog = new AlertDialog.Builder(TopActivity.this)
                    .setTitle(R.string.join_room)
                    .setView(layout)
                    .setPositiveButton(R.string.send_button, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            EditText input = (EditText) layout.getFocusedChild();
                            joinRoom(input.getText().toString());
                        }
                    })
                    .setNegativeButton(R.string.cancel_button, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                        }
                    })
                    .show();
        }
        dialog.show();
    }

    private void joinRoom(String roomKey) {
        Intent varIntent =
                new Intent(TopActivity.this, RoomActivity.class);
        varIntent.putExtra("room_key", roomKey);
        startActivity(varIntent);
    }
}
