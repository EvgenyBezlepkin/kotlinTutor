package kotlinLang// ТИПЫ ФУНКЦИЙ
// 1 локальные функции. Например, функции, вложенные в другие функции

// 2 Функции-элементы - это функции, объявленные внутри классов или объектов

// 3 обобщенные функции. Функции могут иметь обобщённые параметры, которые задаются
// треугольными скобками и помещаются перед именем функции

// 4 встроенные функции. Модификатор inline влияет и на функцию, и на лямбду,
// переданную ей: они обе будут встроены в место вызова.

// 5 функции-расширения. Для того, чтобы объявить функцию-расширение, нам нужно
// указать в качестве префикса расширяемый тип, то есть тип, который мы расширяем.
// пример : fun MutableList<Int>.swap(index1: Int, index2: Int)

// 6 высокоуровневые функциии лямбды

// 7 функции с хвостовой рекурсией


// ВОЗВРАЩАЕМЫЕ ТИПЫ
// Возвращаемый тип Unit (аналог void, но не псевдотип, а тип),
// нужем для более полной реализации обобщений (?)

// Возвращаемый тип Nothing
// говорит что функция гарантированно не выполнится успешно (заглушка)


// ПРОЧЕЕ
// при компиляции функции, объявленные на уровне становятся статическими
// функциями некоторого класса с именем пакета


fun main(args: Array<String>) {


    // АНОНИМНЫЕ ФУНКЦИИ
    //Анонимные функции неявно возвращают результат выполнения последней инструкции
    // в теле функции, позволяя отбросить return.
    // в jvm представляются как экземпляры объектов (расход памяти)
    // имеет ссылки на переменные, объявленные в области видимости, где создается она сама


    // пример немедленновызывающейся анонимной функции
    println({ "SelfInvoked function" }())

    // полная декларация анонимной функции
    val a: (String) -> String = { it -> "hello $it" }
    // анонимная функция с автоматическим определением возвращаемого типа
    val b = { it:String -> "hello $it" }

    println(a("Mathue"))
    println(b("Mathue"))

    // передача лямбды как параметра в функцию
    runSimulation({ k: String -> "Hello, $k" }, 2)


    // передача ссылдки на функцию
    fun refFunc(k:String) = "Hello, $k"
    runSimulation(::refFunc, 2)


    // если при вызове функции мы используем именованые аргументы,
    // то можем передавать их не по порядку
    println(namedArgs(b = 5,
            a = 6))

    // вызов с параметрами по умолчанию
    println(namedArgs())
    //kotlinLang.shouldReturnAString()

}


// функция, принимающая лямбду как параметр
// ключевое слово INLINE встраивает функцию и лямбду в место вызова
inline fun runSimulation(greeting: (String) -> String, value:Int) {
    var i = value;
    while (i > 0) {
        println(greeting("Yuri"))
        i--
    }
}

// в таком случае компилятор может сам вывести возвращаемый тип
fun namedArgs(a: Int = 0, b: Int = 1) = a - b

// функция с заглушкой
fun shouldReturnAString(): String {
    TODO("implement the string building functionality here to return kotlinLang.a string")
}


