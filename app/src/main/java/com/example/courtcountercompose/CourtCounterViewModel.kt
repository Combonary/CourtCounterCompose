package com.example.courtcountercompose

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CourtCounterViewModel: ViewModel() {
    private var _scoreA: MutableStateFlow<Int> = MutableStateFlow(0)
    private var _scoreB: MutableStateFlow<Int> = MutableStateFlow(0)
    val scoreA: StateFlow<Int>
        get() = _scoreA
    val scoreB: StateFlow<Int>
        get() = _scoreB

    fun countShot(id: Char) {
        if (id == 'A') {
            _scoreA.value += 2
        } else {
            _scoreB.value += 2
        }
    }

    fun countThreePointShot(id: Char) {
        if (id == 'A') {
            _scoreA.value += 3
        } else {
            _scoreB.value += 3
        }
    }

    fun resetGame() {
        _scoreA.value = 0
        _scoreB.value = 0
    }
}