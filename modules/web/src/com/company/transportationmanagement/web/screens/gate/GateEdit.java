package com.company.transportationmanagement.web.screens.gate;

import com.haulmont.cuba.gui.screen.*;
import com.company.transportationmanagement.entity.Gate;

@UiController("transportmanagement_Gate.edit")
@UiDescriptor("gate-edit.xml")
@EditedEntityContainer("gateDc")
@LoadDataBeforeShow
public class GateEdit extends StandardEditor<Gate> {
}