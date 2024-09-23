import main.kotlin.Student

fun main() {
    val student1 = Student(
        "Спиридонов",
        "Данил",
        "Александрович",
        "+79887564587",
        "@streleckiio",
        "streleckiio@example.com",
        "https://github.com/SoldDA"
    )

    val student2 = Student(
        "Иванова",
        "Виктория",
        "Александровна"
    )

    println(student1.toString())
    student2.setContacts("86543212451")
    println(student2.toString())

    println("Проверка:")
    println("Студент 1 валидация: ${student1.validate()}")
    println("Студент 2 валидация: ${student2.validate()}")
}
