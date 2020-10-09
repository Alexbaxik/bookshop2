package com.company.bookshop.web.screens.archive;

import com.company.bookshop.entity.Archive;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.FileUploadField;
import com.haulmont.cuba.gui.components.UploadField;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;

import javax.inject.Inject;
import java.io.File;

@UiController("bookshop_Archive.edit")
@UiDescriptor("archive-edit.xml")
@EditedEntityContainer("archiveDc")
@LoadDataBeforeShow
public class ArchiveEdit extends StandardEditor<Archive> {
    @Inject
    private FileUploadField upload;
    @Inject
    private DataManager dataManager;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private Notifications notifications;

    @Subscribe("upload")
    public void onUploadFieldFileUploadSucceed(FileUploadField.FileUploadSucceedEvent event) {
        File file = fileUploadingAPI.getFile(upload.getFileId());
        if (file != null) {
            notifications.create()
                    .withCaption("File is uploaded to temporary storage at " + file.getAbsolutePath())
                    .show();
        }

        FileDescriptor fd = upload.getFileDescriptor();
        try {
            assert fd != null;
            fileUploadingAPI.putFileIntoStorage(upload.getFileId(), fd);
        } catch ( FileStorageException e) {
            throw new RuntimeException("Error saving file to FileStorage", e);
        }
        dataManager.commit(fd);
        notifications.create()
                .withCaption("Uploaded file: " + upload.getFileName())
                .show();
    }
    @Subscribe("upload")
    public void onUploadFieldFileUploadError(UploadField.FileUploadErrorEvent event) {
        notifications.create()
                .withCaption("File upload error")
                .show();
    }
}
