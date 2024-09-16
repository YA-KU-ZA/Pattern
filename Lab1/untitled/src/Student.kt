package main.kotlin

class Student(
    val id: Int,
    var lastName: String,
    var firstName: String,
    var middleName: String? = null,
    var phone: String? = null,
    var telegram: String? = null,
    var email: String? = null,
    var git: String? = null
) {
    init {
        require(lastName.isNotBlank()) { "Фамилия должна быть указана" }
        require(firstName.isNotBlank()) { "Имя должно быть указано" }

        phone?.let { require(isValidPhone(it)) { "Неверный формат телефона" } }
        email?.let { require(isValidEmail(it)) { "Неверный формат почты" } }
        git?.let { require(isValidGit(it)) { "Неверный формат ссылки на Git" } }
    }

    companion object {
        fun isValidPhone(phone: String): Boolean {
            return phone.matches(Regex("^\\+?\\d{11}$"))
        }

        fun isValidEmail(email: String): Boolean {
            return email.matches(Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$"))
        }

        fun isValidGit(git: String): Boolean {
            return git.matches(Regex("^https://github\\.com/[a-zA-Z0-9_-]+/?\$"))
        }

        fun createStudent(vararg args: Pair<String, Any?>): Student {
            val map = args.toMap()
            return Student(
                id = map["ID"] as Int,
                lastName = map["Фамилия"] as String,
                firstName = map["Имя"] as String,
                middleName = map["Отчество"] as String?,
                phone = map["Телефон"] as String?,
                telegram = map["Телеграм"] as String?,
                email = map["email"] as String?,
                git = map["git"] as String?
            )
        }
    }

    override fun toString(): String {
        return "Студент(ID=$id, Фамилия='$lastName', Имя='$firstName', Отчество=$middleName, Телефон=$phone, Телеграм=$telegram, email=$email, git=$git)"
    }

    fun validate(): Boolean {
        return hasGit() && hasAnyContact()
    }

    private fun hasGit(): Boolean {
        return !git.isNullOrEmpty()
    }

    private fun hasAnyContact(): Boolean {
        return !phone.isNullOrEmpty() || !telegram.isNullOrEmpty() || !email.isNullOrEmpty()
    }

    fun setContacts(phone: String? = null, telegram: String? = null, email: String? = null) {
        this.phone = phone?.takeIf { isValidPhone(it) }
        this.telegram = telegram
        this.email = email?.takeIf { isValidEmail(it) }
    }
}