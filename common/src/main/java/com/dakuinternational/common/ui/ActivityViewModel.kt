package com.dakuinternational.common.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dakuinternational.common.ui.base.SingleLiveEvent
import com.dakuinternational.common.ui.event.UiEvent

class ActivityViewModel: ViewModel() {

    private val _uiEvent = SingleLiveEvent<UiEvent>()
    val activityEvent: LiveData<UiEvent> get() = _uiEvent


}