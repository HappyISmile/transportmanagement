package com.company.transportationmanagement.web.screens.client;

import com.haulmont.cuba.gui.screen.*;
import com.company.transportationmanagement.entity.Client;

@UiController("transportmanagement_Client.browse")
@UiDescriptor("client-browse.xml")
@LookupComponent("clientsTable")
@LoadDataBeforeShow
public class ClientBrowse extends StandardLookup<Client> {
}