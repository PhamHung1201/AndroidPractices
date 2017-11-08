package vn.hungpham.app.bluetoothexample

class StateViewContext: State {
    private lateinit var state: State

    override fun changeView() {
        state.changeView()
    }

    fun changeView(s: State){
        state = s
        changeView()
    }
}