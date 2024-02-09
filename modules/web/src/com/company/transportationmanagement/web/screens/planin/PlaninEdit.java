package com.company.transportationmanagement.web.screens.planin;

import com.haulmont.cuba.gui.screen.*;
import com.company.transportationmanagement.entity.Planin;

@UiController("transportmanagement_Planin.edit")
@UiDescriptor("planin-edit.xml")
@EditedEntityContainer("planinDc")
@LoadDataBeforeShow
public class PlaninEdit extends StandardEditor<Planin> {
}