package com.company.transportationmanagement.web.screens.gate;

import com.haulmont.cuba.gui.screen.*;
import com.company.transportationmanagement.entity.Gate;

@UiController("transportmanagement_Gate.browse")
@UiDescriptor("gate-browse.xml")
@LookupComponent("gatesTable")
@LoadDataBeforeShow
public class GateBrowse extends StandardLookup<Gate> {
}