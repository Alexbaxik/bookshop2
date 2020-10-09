package com.company.bookshop.web.screens.archive;

import com.company.bookshop.entity.Archive;
import com.haulmont.cuba.gui.screen.*;

@UiController("bookshop_Archive.browse2")
@UiDescriptor("archive-browse2.xml")
@LookupComponent("archivesTable")
@LoadDataBeforeShow
public class ArchiveBrowse2 extends StandardLookup<Archive> {
}