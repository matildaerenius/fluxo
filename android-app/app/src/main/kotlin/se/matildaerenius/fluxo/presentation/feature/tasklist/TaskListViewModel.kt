package se.matildaerenius.fluxo.presentation.feature.tasklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import se.matildaerenius.fluxo.domain.model.TaskList
import se.matildaerenius.fluxo.domain.usecase.tasklist.TaskListUseCases
import se.matildaerenius.fluxo.presentation.state.UiState
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(
    private val taskListUseCases: TaskListUseCases
) : ViewModel() {

    private val _state = MutableStateFlow<UiState<List<TaskList>>>(UiState.Loading)
    val state = _state.asStateFlow()

    init {
        getTaskLists()
    }

    fun getTaskLists() {
        viewModelScope.launch {
            _state.value = UiState.Loading
            try {
                val lists = taskListUseCases.getTaskLists()
                _state.value = UiState.Success(lists)
            } catch (e: Exception) {
                _state.value = UiState.Error(e.localizedMessage ?: "Kunde inte hämta listor")
            }
        }
    }
}