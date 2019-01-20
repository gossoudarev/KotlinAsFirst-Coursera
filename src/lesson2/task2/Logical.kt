@file:Suppress("UNUSED_PARAMETER")
package lesson2.task2

import lesson1.task1.sqr
import kotlin.math.*

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
        sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    val digit1 = Math.floor(number / 1000.0) % 10
    val digit2 = Math.floor(number / 100.0) % 10
    val digit3 = Math.floor(number / 10.0) % 10
    val digit4 = number % 10
    return digit1 + digit2 == digit3 + digit4
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean = TODO()


/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int = TODO()

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */

fun circleInside(x1: Double, y1: Double, r1: Double,
                 x2: Double, y2: Double, r2: Double): Boolean {

    val D = Math.sqrt(Math.pow((x2 - x1), 2.0)  + Math.pow((y2 - y1), 2.0));
    return if ((D == 0.0 && r1 <= r2) || (D <= Math.abs(r2 - r1)  && r1 < r2)) true
    else false
}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    val kmax = Math.max(Math.max(a, b), c)
    val kmin = Math.min(Math.min(a, b), c)
    val hmax = Math.max(r, s)
    val hmin = Math.min(r, s)
    val kave = when {
        (a == kmax && b == kmin) || (b == kmax && a == kmin) -> c
        (a == kmax && c == kmin) || (c == kmax && a == kmin) -> b
        else -> a
    }

    return if (hmax  >= kave  && hmin >= kmin) true else false

}


fun main(args: Array<String>) {
    println(brickPasses(111,444,3333,3444,443))
    println(brickPasses(2, 10, 5, 6, 3))
}