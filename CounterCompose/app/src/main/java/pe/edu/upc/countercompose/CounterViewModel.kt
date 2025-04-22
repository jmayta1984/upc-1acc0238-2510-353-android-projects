package pe.edu.upc.countercompose

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CounterViewModel : ViewModel() {
    private var _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count

    fun increment(){
        _count.value ++
    }
}