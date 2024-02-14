package com.company.transportationmanagement.web.screens.auditevent;

import com.haulmont.cuba.gui.screen.*;
import com.company.transportationmanagement.audit.AuditEvent;

@UiController("transportmanagement_AuditEvent.browse")
@UiDescriptor("audit-event-browse.xml")
@LookupComponent("auditEventsTable")
@LoadDataBeforeShow
public class AuditEventBrowse extends StandardLookup<AuditEvent> {
}