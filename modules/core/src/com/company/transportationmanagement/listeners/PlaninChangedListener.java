package com.company.transportationmanagement.listeners;

import com.company.transportationmanagement.audit.AuditEvent;
import com.company.transportationmanagement.entity.Planin;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.View;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.inject.Inject;

@Component("transportmanagement_PlaninChangedListener")
public class PlaninChangedListener {

    @Inject
    private DataManager dataManager;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommit(EntityChangedEvent<Planin, UUID> event) {
        if(event.getChanges().isChanged("condition") ||
        event.getChanges().isChanged("status")){
            Optional<Planin> planingObject = dataManager.load(Planin.class)
                    .id(event.getEntityId().getValue())
                    .view(View.LOCAL)
                    .optional();

            AuditEvent auditEvent = new AuditEvent();
            auditEvent.setRegistrationNumber(planingObject.get().getRegistrationNumber());
            auditEvent.setNumberTC(planingObject.get().getNumberTC());
            auditEvent.setStatus(planingObject.get().getStatus().getId().intValue());
            auditEvent.setCondition(planingObject.get().getCondition().getId().intValue());
            auditEvent.setCreateDate(LocalDateTime.now());

            dataManager.commit(auditEvent);
        }
    }
}