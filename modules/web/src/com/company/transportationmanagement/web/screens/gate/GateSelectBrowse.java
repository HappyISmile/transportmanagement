package com.company.transportationmanagement.web.screens.gate;

import com.company.transportationmanagement.entity.Planin;
import com.company.transportationmanagement.enums.Condition;
import com.company.transportationmanagement.enums.Status;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.transportationmanagement.entity.Gate;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.LocalTime;

@UiController("transportmanagement_Gate_Select.browse")
@UiDescriptor("gate-select-browse.xml")
@LookupComponent("gatesTable")
@LoadDataBeforeShow
public class GateSelectBrowse extends StandardLookup<Gate> {

    Planin planin;
    @Inject
    private GroupTable<Gate> gatesTable;
    @Inject
    private DataManager dataManager;
    @Inject
    private CollectionLoader<Gate> gatesDl;

    @Subscribe
    public void onInit(InitEvent event) {
        ScreenOptions options = event.getOptions();
        MapScreenOptions mapScreenOptions = (MapScreenOptions) event.getOptions();
        planin = (Planin) mapScreenOptions.getParams().get("planinSelect");

        gatesDl.setParameter("date", LocalTime.now());
//        if (options instanceof GateSelectBrowse) {
//            String message = ((FancyMessageOptions) options).getMessage();
//            messageLabel.setValue(message);
//        }
    }

    @Subscribe("lookupSelectAction")
    public void onLookupSelectActionClick(Button.ClickEvent event) {
        planin.setStatus(Status.ON_THE_FORTS);
        planin.setCondition(Condition.GATE_ASSIGNED);//yет такого состояния "Ворота назначены"
        planin.setGateSettingDate(LocalDateTime.now());
        planin.setGates(gatesTable.getSingleSelected().getNumberGate());

        dataManager.commit(planin);
        close(StandardOutcome.COMMIT);
    }


    
    
    
}