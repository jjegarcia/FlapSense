package com.example.flapsense

interface StateMachineI {
    fun setState(targetState: State, block: (() -> Unit?)? = null)
    fun fetchState(): State
    fun saveState(newState: State)
}
