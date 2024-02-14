package com.company.transportationmanagement.web.screens.planin;

import com.company.transportationmanagement.enums.Condition;
import com.company.transportationmanagement.enums.Status;
import com.haulmont.cuba.core.app.UniqueNumbersService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.screen.*;
import com.company.transportationmanagement.entity.Planin;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;

@UiController("transportmanagement_Planin.edit")
@UiDescriptor("planin-edit.xml")
@EditedEntityContainer("planinDc")
@LoadDataBeforeShow
public class PlaninEdit extends StandardEditor<Planin> {

    @Inject
    private UniqueNumbersService uniqueNumbers;
    @Inject
    private DataManager dataManager;

    @Subscribe
    public void onAfterCommitChanges(AfterCommitChangesEvent event) {
//        getEditedEntity().setRegistrationNumber(String.valueOf(uniqueNumbers.getNextNumber("registrationNumberId")));
//        dataManager.commit(getEditedEntity());
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        getEditedEntity().setRegistrationNumber(String.valueOf(uniqueNumbers.getNextNumber("registrationNumberId")));
        getEditedEntity().setStatus(Status.REGISTERED);
        getEditedEntity().setCondition(Condition.AWAITS);
        getEditedEntity().setRegistrationDate(LocalDateTime.now());
    }
    
    
}