package com.company.transportationmanagement.web.screens.planin;

import com.company.transportationmanagement.entity.Planin;
import com.company.transportationmanagement.enums.Status;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("transportmanagement_Planin.browse")
@UiDescriptor("planin-browse.xml")
@LoadDataBeforeShow
public class PlaninBrowse extends Screen {
    @Inject
    private CollectionLoader<Planin> planinDl;

    @Subscribe
    public void onInit(InitEvent event) {
        planinDl.setParameter("planned", Status.PLANNED);
        planinDl.setParameter("registered", Status.REGISTERED);
    }


}