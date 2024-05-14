package com.example.lojavirtual;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MenuControl {
    private ImageButton opener;
    private Context mContext;
    private static Menu menu;

    public MenuControl(Context context, ImageButton button) {
        this.opener = button;
        this.mContext = context;
    }

    public void showMenu() {
        PopupMenu dropdown = new PopupMenu(this.mContext, this.opener);

        this.menu = dropdown.getMenu();

        dropdown.getMenuInflater().inflate(R.menu.main_menu, menu);
        dropdown.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_about:
                        Intent aboutIntent = new Intent(mContext, AboutActivity.class);
                        mContext.startActivity(aboutIntent);

                        // Close activity if not are the Main Activity
                        if (mContext.getClass().getSimpleName().equals("MainActivity")) {
                            return true;
                        } else {
                            ((Activity) mContext).finish();
                        }

                        return true;
                    case R.id.action_contact:
                        Intent contactIntent = new Intent(mContext, ContactActivity.class);
                        mContext.startActivities(new Intent[]{contactIntent});

                        // Close activity if not are the Main Activity
                        if (mContext.getClass().getSimpleName().equals("MainActivity")) {
                            return true;
                        } else {
                            ((Activity) mContext).finish();
                        }
                        return true;
                    default:
                        return true;
                }
            }
        });

        this.opener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropdown.show();
            }
        });
    }

    public void hideItem() {
        if (mContext.getClass().getSimpleName().equals("AboutActivity")) {
            // Hide
            this.menu.findItem(R.id.action_about).setVisible(false);

            // Show
            this.menu.findItem(R.id.action_contact).setVisible(true);
        } else if (mContext.getClass().getSimpleName().equals("ContactActivity")) {
            // Hide
            this.menu.findItem(R.id.action_contact).setVisible(false);

            // Show
            this.menu.findItem(R.id.action_about).setVisible(true);
        }
    }

}
