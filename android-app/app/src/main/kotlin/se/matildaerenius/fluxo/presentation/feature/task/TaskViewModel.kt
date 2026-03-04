package se.matildaerenius.fluxo.presentation.feature.task

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import se.matildaerenius.fluxo.domain.model.Task
import se.matildaerenius.fluxo.domain.usecase.task.TaskUseCases
import se.matildaerenius.fluxo.presentation.state.UiState
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow<UiState<List<Task>>>(UiState.Loading)
    val state = _state.asStateFlow()

    private val taskListId: String? = savedStateHandle["taskListId"]

    init {
        loadTasks()
    }

    fun loadTasks() {
        val id = taskListId ?: return
        viewModelScope.launch {
            _state.value = UiState.Loading
            try {
                val tasks = taskUseCases.getTasks(id)
                _state.value = UiState.Success(tasks)
            } catch (e: Exception) {
                _state.value = UiState.Error(e.localizedMessage ?: "Kunde inte ladda uppgifter")
            }
        }
    }
}