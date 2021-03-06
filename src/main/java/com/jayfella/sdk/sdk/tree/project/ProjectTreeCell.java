package com.jayfella.sdk.sdk.tree.project;

import javafx.scene.control.TreeCell;

import java.io.File;

public class ProjectTreeCell extends TreeCell<Object> {

    @Override
    public void updateItem(Object item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        } else {

            String text = "No Name";

            if (item instanceof File) {
                File file = (File) item;
                text = file.getName();
            }
            else if (item instanceof Class) {

                Class<?> itemClass = (Class<?>) item;
                text = itemClass.getSimpleName();
            }
            else if (item instanceof String) {
                String string = (String) item;
                text = string;
            }

            setText(text);

            setGraphic(getTreeItem().getGraphic());
            setContextMenu(((ProjectTreeItem) getTreeItem()).getMenu());
        }
    }
}
