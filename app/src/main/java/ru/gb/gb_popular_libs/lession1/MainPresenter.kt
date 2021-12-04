package ru.gb.gb_popular_libs.lession1

val COUNTER1=0
val COUNTER2=1
val COUNTER3=2

class MainPresenter(
    private val view: MainView,
    private val model: CountersModel = CountersModel()
) {

    //Архитектурная ошибка. В качестве практического задания - исправить
    fun counterClick(id: Int){
            val nextValue = model.next(id)
            view.setButtonText(id,nextValue.toString())
    }
}
