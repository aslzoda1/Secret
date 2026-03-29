import java.util.Scanner

fun main() {
    println("--- 🛡️ MAXFIY XABARCHI TIZIMI ---")
val sc = Scanner(System.`in`)
    print("Xabar kiriting: ")
    val originalText = sc.nextLine()
    val secretKey = 5

     val encrypted = transformText(originalText, secretKey)

     val decrypted = transformText(encrypted, -secretKey)

    println("""
        📄 Asl matn:      $originalText
        🔒 Shifrlangan:   $encrypted
        🔓 Qayta o'qildi: $decrypted
    """.trimIndent())
}

fun transformText(input: String, shift: Int): String {
    return input.map { char ->
        if (char.isLetter()) {
            val base = if (char.isUpperCase()) 'A' else 'a'
              val shifted = (char.code - base.code + shift).mod(26)
            (base.code + shifted).toChar()
        } else {
            char
        }
    }.joinToString("")
}