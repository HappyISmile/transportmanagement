package com.company.transportationmanagement.web.screens.planin;

import com.company.transportationmanagement.entity.Gate;
import com.company.transportationmanagement.entity.Planin;
import com.company.transportationmanagement.enums.Condition;
import com.company.transportationmanagement.enums.Status;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@UiController("transportmanagement_Planin.browse")
@UiDescriptor("planin-browse.xml")
@LoadDataBeforeShow
public class PlaninBrowse extends Screen {
    @Inject
    private CollectionLoader<Planin> planinDl;
    @Inject
    private VBoxLayout plannedTab;
    @Inject
    private DataGrid<Planin> planinGrid;
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private Notifications notifications;
    @Inject
    private CollectionLoader<Planin> gateDl;
    @Inject
    private CollectionContainer<Planin> planinDc;
    @Inject
    private TabSheet tabScheet;
    @Inject
    private CollectionContainer<Planin> gateDc;
    @Inject
    private Timer myTimer;
    @Inject
    private DataGrid<Planin> gateGrid;
    @Inject
    private DataManager dataManager;

    @Subscribe
    public void onInit(InitEvent event) {
        planinDl.setParameter("planned", Status.PLANNED);
        planinDl.setParameter("registered", Status.REGISTERED);
        gateDl.setParameter("onTheForts", Status.ON_THE_FORTS);
        gateDl.setParameter("gateAssigned", Condition.GATE_ASSIGNED);
    }

    @Subscribe("myTimer")
    private void onTimer(Timer.TimerActionEvent event) {
        loadTabSheetCount();

        planinDl.load();
        gateDl.load();
    }

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        loadTabSheetCount();
    }

    private void loadTabSheetCount(){
        tabScheet.getTab("plannedTab").setCaption(String.format("Запланированы (%d)",planinDc.getItems().size()));
        tabScheet.getTab("atTheGateTab").setCaption(String.format("На воротах (%d)",gateDc.getItems().size()));
    }

    @Subscribe("regBtn")
    public void onRegBtnClick(Button.ClickEvent event) {
        if(planinGrid.getSingleSelected()!=null && planinGrid.getSingleSelected().getRegistrationDate()==null){
            screenBuilders.editor(Planin.class, this)
                    .editEntity(planinGrid.getSingleSelected())
                    .build()
                    .show();
            planinDl.load();
        }else if(planinGrid.getSingleSelected()==null ) {
            notifications.create().withCaption("Запись не выбрана").show();
        }else{
            notifications.create().withCaption("Поставщик уже зарегистрирован").show();
        }
    }

    @Subscribe("assignGateBtn")
    public void onAssignGateBtnClick(Button.ClickEvent event) {
        if(planinGrid.getSingleSelected() == null){
            notifications.create().withCaption("Запись не выбрана").show();
        }else if(!planinGrid.getSingleSelected().getStatus().equals(Status.REGISTERED)){
            notifications.create(Notifications.NotificationType.ERROR).withCaption("Ворота не могут быть назначены").show();
        }else if(planinGrid.getSingleSelected().getStatus().equals(Status.REGISTERED)){
            screenBuilders.lookup(Gate.class,this)
                    .withScreenId("transportmanagement_Gate_Select.browse")
                    .withLaunchMode(OpenMode.DIALOG)
                    .withOptions(new MapScreenOptions(ParamsMap.of("planinSelect", planinGrid.getSingleSelected())))
                    .build()
                    .show();

            planinDl.load();
        }
    }

    @Install(to = "gateGrid.provider", subject = "columnGenerator")
    private String gateGridProviderColumnGenerator(DataGrid.ColumnGeneratorEvent<Planin> event) {
        String providerNameJoin = event.getItem().getProvider()
                .stream()
                .map(e->e.getName())
                .collect(Collectors.joining(", "));
        return providerNameJoin;
    }

    @Install(to = "gateGrid.timeResult", subject = "columnGenerator")
    private String gateGridTimeResultColumnGenerator(DataGrid.ColumnGeneratorEvent<Planin> event) {
        LocalDateTime gateSettingDate = event.getItem().getGateSettingDate();
        LocalDateTime departureDate = event.getItem().getDepartureDate();
        if(gateSettingDate!=null && departureDate!=null){
            Period diff = Period.between(gateSettingDate.toLocalDate(), departureDate.toLocalDate());
            Duration duration = Duration.between(gateSettingDate.toLocalTime(), departureDate.toLocalTime());
            String dateResult = "дней: " + String.valueOf(diff.getDays()) + " " + "минут: " + duration.toMinutes();
            return dateResult;
        }
        return "";
    }

    @Subscribe("gateLoadBtn")
    public void onGateLoadBtnClick(Button.ClickEvent event) {
        if(gateGrid.getSingleSelected() == null){
            gateGrid.getSingleSelected().setStatus(Status.DEPARTURE_ALLOWED);
            gateGrid.getSingleSelected().setCondition(Condition.DEPARTURE_ALLOWED);
            gateGrid.getSingleSelected().setDepartureAllowedDate(LocalDateTime.now());

            dataManager.commit(gateGrid.getSingleSelected());

            loadTabSheetCount();
        }
    }
}