package com.company.transportationmanagement.web.screens.client;

import com.haulmont.cuba.gui.screen.*;
import com.company.transportationmanagement.entity.Client;

@UiController("transportmanagement_Client.edit")
@UiDescriptor("client-edit.xml")
@EditedEntityContainer("clientDc")
@LoadDataBeforeShow
public class ClientEdit extends StandardEditor<Client> {
}