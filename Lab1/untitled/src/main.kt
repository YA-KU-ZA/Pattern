import main.kotlin.Student

fun main() {
    val student1 = Student(
        1,
        "Спиридонов",
        "Данил",
        "Александрович",
        "+79887564587",
        "@streleckiio",
        "streleckiio@example.com",
        "https://github.com/SoldDA"
    )

    val student2 = Student(
        2,
        "Иванова",
        "Виктория",
        null,
        null,
        null,
        null,
        null
    )

    val student3 = Student.createStudent(
        "ID" to 3,
        "Фамилия" to "Прокопенко",
        "Имя" to "Евегний",
        "Телефон" to "+76549872435",
        "git" to "https://github.com/YA-KU-ZA"
    )

    println(student1.toString())
    println(student2.toString())
    println(student3.toString())

    println("Проверка:")
    println("Студент 1 валидация: ${student1.validate()}")
    println("Студент 2 валидация: ${student2.validate()}")
    println("студент 3 валидация: ${student3.validate()}")

    student3.setContacts(email = "prorok@example.com")
    println("Обновление Студента 3: $student3")
}